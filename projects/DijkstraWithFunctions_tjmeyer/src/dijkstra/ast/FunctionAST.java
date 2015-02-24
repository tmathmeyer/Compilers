package dijkstra.ast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import dijkstra.unify.ScopedSet;
import dijkstra.unify.Type;
import dijkstra.unify.TypeUnificationTable;

public class FunctionAST implements AST
{
	private final String name;
	private final Type type;
	private final ArrayList<TerminalAST> args = new ArrayList<>();
	private final CompoundBodyAST body;
	
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
		tut.register(this, type);
	}
}
