package dijkstra.ast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.antlr.v4.runtime.tree.TerminalNode;

import dijkstra.lexparse.DijkstraParser.TypeContext;
import dijkstra.unify.ScopedSet;

public class FunctionAST implements AST
{
	private final String name;
	private final ArrayList<String> types = new ArrayList<>();
	private final ArrayList<Param> args = new ArrayList<>();
	private final AST body;
	
	public FunctionAST(String n, Stream<AST> a, Stream<String> t, AST b)
	{
		name = n;
		body = b;
		a.map(x -> Param.fromAST(x)).forEach(X -> args.add(X));
		t.forEach(X -> types.add(X));
	}

	@Override
	public String toString()
	{
		LinkedList<String> argsS = new LinkedList<>();
		args.stream().forEach(a -> argsS.push(a.toString()));
		StringBuilder sb = new StringBuilder("fun " + name + "(" + String.join(",", argsS) + ") : " + String.join(",", types));
		sb.append(body);
		return sb.toString();
	}
	
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		ScopedSet<String> current = new ScopedSet<>(this);
		scope.insert(name);
		
		for(Param p : args)
		{
			current.insert(p.name);
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
		   		types.stream(),
		   		body.renameVars(scope));
	}
	
	@Override
	public AST renameScoping(ScopedSet<VarBind> vb)
	{
		List<AST> newChildren = new ArrayList<>();
		for(Param a : args)
		{
			a = a.renameVars(vb.getScopeVars(a));
			a = a.renameVars(vb.getScopeVars(this));
			a = a.renameScoping(vb);
			newChildren.add(a);
		}
		
		AST bod = body.renameVars(vb.getScopeVars(body));
		bod = bod.renameVars(vb.getScopeVars(this));
		bod = bod.renameScoping(vb);
		
		return new FunctionAST(name, newChildren.stream(), types.stream(), bod);
	}
	
	
	
	public static class Param implements AST
	{
		private String type;
		String name;
		
		public Param(String t, String n)
		{
			type = t;
			name = n;
		}

		public Param(TypeContext type2, TerminalNode id)
		{
			name = id.getText();
			type = type2==null?"UNKNOWN":type2.getText();
		}
		
		@Override
		public String toString()
		{
			if (type.equals("UNKNOWN"))
			{
				return name;
			}
			return type+" "+name;
		}

		public static Param fromAST(AST a)
		{
			if (a instanceof Param)
			{
				return (Param) a;
			}
			throw new RuntimeException("cant make a parameter from this: "+a);
		}
		
		@Override
		public Param renameScoping(ScopedSet<VarBind> vb)
		{
			return this;
		}
		
		@Override
		public Param renameVars(Set<VarBind> scope)
		{
			for(VarBind b : scope)
			{
				if (b.old.equals(name))
				{
					return new Param(type, b.New);
				}
			}
			return this;
		}
	}
}
