package dijkstra.ast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.objectweb.asm.Opcodes.*;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import dijkstra.ast.expr.TerminalAST;
import dijkstra.gen.JVMInfo;
import dijkstra.type.Arrow;
import dijkstra.type.MethodSignitureGenerator;
import dijkstra.type.Type;
import dijkstra.unify.Constraint;
import dijkstra.unify.ScopedSet;
import dijkstra.unify.TypeUnificationTable;

public class FunctionAST implements AST
{
	private final String name;
	private final Type type;
	private final ArrayList<TerminalAST> args = new ArrayList<>();
	private final CompoundBodyAST body;
	
	public Type getReturnType()
	{
		return type;
	}
	
	public FunctionAST(String n, Stream<AST> a, String t, AST b)
	{
		this(n, a, Type.fromString(t), (CompoundBodyAST) b);
	}

	public FunctionAST(String n, Stream<AST> a, Type t, CompoundBodyAST b)
	{
		name = n;
		body = b;
		a.map(x -> (TerminalAST)x).forEach(x -> args.add(x));
		type = t;
	}

	@Override
	public String toString()
	{
		LinkedList<String> argsS = new LinkedList<>();
		args.stream().forEach(a -> argsS.push(a.toString()));
		StringBuilder sb = new StringBuilder("fun " + name + "(" + String.join(",", argsS) + ") : " + type);
		sb.append(body);
		return sb.toString();
	}
	
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		ScopedSet<String> current = new ScopedSet<>(this);
		scope.insert(name);
		
		for(TerminalAST p : args)
		{
			current.insert(p.toString());
		}
		
		body.getDeclaredVariables(current);
		
		scope.merge(current.finish());
		return scope;
	}
	
	@Override
	public AST renameVars(Set<VarBind> scope)
	{
		String name = this.name;
		for(VarBind b : scope)
		{
			if (b.old.equals(name))
			{
				name = b.New;
			}
		}
		
		return new FunctionAST(name,
				args.stream().map(a -> {return a.renameVars(scope); }),
		   		type, body.renameVars(scope));
	}
	
	@Override
	public AST renameScoping(ScopedSet<VarBind> vb)
	{
		List<AST> newChildren = new ArrayList<>();
		for(TerminalAST a : args)
		{
			a = a.renameVars(vb.getScopeVars(a));
			a = a.renameVars(vb.getScopeVars(this));
			newChildren.add(a);
		}
		
		CompoundBodyAST bod = body.renameVars(vb.getScopeVars(body));
		bod = bod.renameVars(vb.getScopeVars(this));
		bod = bod.renameScoping(vb);
		
		return new FunctionAST(name, newChildren.stream(), type, bod);
	}
	
	
	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		body.trySetReturn(tut, type);
		args.stream().forEach(a -> a.buildTUT(tut));
		
		Arrow a = new Arrow(Arrow.fromList(args), type);
		
		tut.register(new TerminalAST(name, a), a);
		tut.register(new TerminalAST(name, type), a);
		tut.registerFunction(name, this);
	}
	
	
	private boolean genSwitch = false;
	@Override
	public void generateCode(ClassWriter writer, MethodVisitor DO_NOT_USE, TypeUnificationTable tut)
	{
		if (genSwitch)
		{
			return;
		}
		genSwitch = true;
		
		
		Constraint cons = tut.getConstraintByName(name);
		MethodSignitureGenerator msg = new MethodSignitureGenerator(cons.right());
		final MethodVisitor mv2 = writer.visitMethod(ACC_PUBLIC + ACC_STATIC, name, msg.toString(), null, null);
		mv2.visitCode();
		
		for(int i = 0; i<args.size(); i++)
		{
			JVMInfo.addressOf("arg"+i);
		}
		
		int argc = 0;
		for(TerminalAST tast : args)
		{
			switch(tut.getTypeByName(tast))
			{
			case BOOLEAN:
				mv2.visitVarInsn(ILOAD, JVMInfo.addressOf("arg"+argc++));
				mv2.visitVarInsn(ISTORE, tast.getAddr());
				break;
			case FLOAT:
				mv2.visitVarInsn(FLOAD, JVMInfo.addressOf("arg"+argc++));
				mv2.visitVarInsn(FSTORE, tast.getAddr());
				break;
			case INT:
				mv2.visitVarInsn(ILOAD, JVMInfo.addressOf("arg"+argc++));
				mv2.visitVarInsn(ISTORE, tast.getAddr());
				break;
			default:
				throw new RuntimeException("bad type!!");
			
			}
		}
		
		body.generateCode(writer, mv2, tut);
		
		
		mv2.visitMaxs(10, 10);
		mv2.visitEnd();
	}
}
