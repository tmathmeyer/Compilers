package dijkstra.ast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Stream;

import org.antlr.v4.runtime.tree.TerminalNode;

import dijkstra.ds.ScopedSet;
import dijkstra.lexparse.DijkstraParser.TypeContext;

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
	}
}
