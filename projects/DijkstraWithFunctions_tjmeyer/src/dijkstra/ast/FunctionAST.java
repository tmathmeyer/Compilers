package dijkstra.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import org.antlr.v4.runtime.tree.TerminalNode;

import dijkstra.lexparse.DijkstraParser.TypeContext;

public class FunctionAST implements AST
{
	private final String name;
	private final List<String> types = new ArrayList<>();
	private final List<Param> args = new ArrayList<>();
	private final AST body;
	
	public FunctionAST(String n, Stream<AST> a, Stream<String> t, AST b)
	{
		name = n;
		body = b;
		Iterator<Param> ar = a.map(x -> Param.fromAST(x)).iterator();
		Iterator<String> ty = t.iterator();
		
		while(ar.hasNext())
		{
			args.add(ar.next());
		}
		
		while(ty.hasNext())
		{
			types.add(ty.next());
		}
	}

	@Override
	public String toString()
	{
		LinkedList<String> argsS = new LinkedList<>();
		args.stream().forEach(a -> argsS.push(a.toString()));
		StringBuilder sb = new StringBuilder("fun " + name + "(" + String.join(",", argsS) + ") : " + String.join(",", types) + " {\n");
		sb.append(body);
		sb.append("}");
		return sb.toString();
	}
	
	
	
	
	
	public static class Param implements AST
	{
		private String type;
		private String name;
		
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
