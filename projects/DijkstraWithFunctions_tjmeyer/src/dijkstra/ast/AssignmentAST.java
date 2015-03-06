package dijkstra.ast;

import static org.objectweb.asm.Opcodes.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import dijkstra.ast.expr.ArrayAccessAST;
import dijkstra.ast.expr.ExprAST;
import dijkstra.ast.expr.FunctionCallExpr;
import dijkstra.ast.expr.TerminalAST;
import dijkstra.type.Type;
import dijkstra.unify.ScopedSet;
import dijkstra.unify.TypeUnificationTable;

public class AssignmentAST implements AST
{
	private final LinkedList<ExprAST> assignTo = new LinkedList<>();
	private final LinkedList<ExprAST> assignFrom = new LinkedList<>();
	
	public AssignmentAST(Stream<AST> vars, Stream<AST> xpressions)
	{
		vars.forEach(a -> assignTo.push((ExprAST) a));
		xpressions.forEach(a -> assignFrom.push((ExprAST) a));
		
		if (assignFrom.size() != assignTo.size())
		{
			throw new RuntimeException("mismatched assignment stament");
		}
	}
	
	@Override
	public String toString()
	{
		LinkedList<String> left = new LinkedList<>();
		LinkedList<String> right = new LinkedList<>();
		
		assignTo.forEach(a -> left.push(a.toString()));
		assignFrom.forEach(a -> right.push(a.toString()));
		
		return String.join(",", left) + " <- " + String.join(",", right);
	}
	
	@Override
	public AST renameVars(Set<VarBind> s)
	{	
		return new AssignmentAST(assignTo.stream().map(a -> a.renameVars(s)),
								 assignFrom.stream().map(a -> a.renameVars(s)));
	}
	
	@Override
	public AST renameScoping(ScopedSet<VarBind> vb)
	{
		List<AST> afr = new ArrayList<>();
		List<AST> ato = new ArrayList<>();
		for(AST a : assignFrom)
		{
			a = a.renameVars(vb.getScopeVars(a));
			a = a.renameVars(vb.getScopeVars(this));
			a = a.renameScoping(vb);
			afr.add(a);
		}
		
		for(AST a : assignTo)
		{
			a = a.renameVars(vb.getScopeVars(a));
			a = a.renameVars(vb.getScopeVars(this));
			a = a.renameScoping(vb);
			ato.add(a);
		}
		
		return new AssignmentAST(ato.stream(), afr.stream());
	}
	
	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		Iterator<ExprAST> to = assignTo.iterator();
		Iterator<ExprAST> from = assignFrom.iterator();
		for(int i=0; i<assignTo.size(); i++)
		{
			ExprAST t = to.next();
			ExprAST f = from.next();
			t.buildTUT(tut);
			f.buildAssignment(tut);
			if (f instanceof FunctionCallExpr)
			{
				tut.register(t, new TerminalAST(((FunctionCallExpr)f).getName(), Type.UNKNOWN));
			}
			else
			{
				tut.register(t, f);
				tut.register(f, t);
			}
		}
	}
	
	@Override
	public void generateCode(ClassWriter writer, MethodVisitor mv, TypeUnificationTable tut)
	{
		Iterator<ExprAST> to = assignTo.iterator();
		Iterator<ExprAST> from = assignFrom.iterator();
		for(int i=0; i<assignTo.size(); i++)
		{
			ExprAST t = to.next();
			ExprAST f = from.next();
			
			if (t instanceof ArrayAccessAST)
			{
				((ArrayAccessAST)t).store(writer, mv, tut);
			}
			f.generateCode(writer, mv, tut);
			switch(tut.getTypeByName(t))
			{
				case INT: case C_INT: case NUMERIC_GENERAL:
				case BOOLEAN:
					if (t instanceof ArrayAccessAST)
					{
						mv.visitInsn(IASTORE);
					}
					else
					{
						mv.visitVarInsn(ISTORE, t.getAddr());
					}
					break;
				case A_FLOAT: case C_FLOAT: case FLOAT:
					if (t instanceof ArrayAccessAST)
					{
						mv.visitInsn(FASTORE);
					}
					else
					{
						mv.visitVarInsn(FSTORE, t.getAddr());
					}
					break;
				default:
					throw new RuntimeException("Cant Load that type " + t);
			}
			
			
			
		}
	}
}
