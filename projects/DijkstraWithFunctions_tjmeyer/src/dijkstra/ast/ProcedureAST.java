package dijkstra.ast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import dijkstra.ast.expr.TerminalAST;
import dijkstra.unify.ScopedSet;
import dijkstra.unify.TypeUnificationTable;

public class ProcedureAST implements AST
{
	private final String procname;
	private final ArrayList<TerminalAST> args = new ArrayList<>();
	private final CompoundBodyAST body;
	
	public ProcedureAST(String text, Stream<AST> map, AST accept)
	{
		procname = text;
		body = (CompoundBodyAST) accept;
		map.map(x -> (TerminalAST)x).forEach(x -> args.add(x));
	}
	
	@Override
	public String toString()
	{
		LinkedList<String> argsS = new LinkedList<>();
		args.stream().forEach(a -> argsS.push(a.toString()));
		StringBuilder sb = new StringBuilder("proc " + procname + "(" + String.join(",", argsS) + ")");
		sb.append(body);
		return sb.toString();
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		ScopedSet<String> current = new ScopedSet<>(this);
		scope.insert(procname);
		
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
		String name = procname;
		for(VarBind b : scope)
		{
			if (b.old.equals(name))
			{
				name = b.New;
			}
		}
		
		return new ProcedureAST(name,
				args.stream().map(a -> {return a.renameVars(scope); }),
		   		body.renameVars(scope));
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
		
		AST bod = body.renameVars(vb.getScopeVars(body));
		bod = bod.renameVars(vb.getScopeVars(this));
		bod = bod.renameScoping(vb);
		
		return new ProcedureAST(procname, newChildren.stream(), bod);
	}

	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		body.trySetReturn(tut, null);
		args.stream().forEach(a -> a.buildTUT(tut));
	}
	
	@Override
	public void generateCode(ClassWriter writer, MethodVisitor method, TypeUnificationTable tut)
	{
		throw new RuntimeException("NOT IMPLEMENTED");
	}
}
