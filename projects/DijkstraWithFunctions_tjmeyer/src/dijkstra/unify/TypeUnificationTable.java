package dijkstra.unify;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import dijkstra.ast.AST;

public class TypeUnificationTable
{
	private final Map<AST, Type> typeTable = new HashMap<>();
	private final Map<AST, AST> astTable = new HashMap<>();
	
	private final Map<AST, Type> results = new HashMap<>();
	
	public void register(AST tree, Type t)
	{
		typeTable.put(tree, t);
	}
	
	public void register(AST tree, AST to)
	{
		astTable.put(tree, to);
	}
	
	public String toString(ReverseNameIndex rni)
	{
		StringBuilder sb = new StringBuilder();
		for(Entry<AST, Type> t : typeTable.entrySet())
		{
			sb.append(rni.sanatize(t.getKey().toString().replaceAll("\n", " ").replaceAll("[\\ ]+", " ")));
			sb.append(":").append(t.getValue());
			sb.append("\n");
		}
		
		for(Entry<AST, AST> t : astTable.entrySet())
		{
			sb.append(rni.sanatize(t.getKey().toString().replaceAll("\n", " ").replaceAll("[\\ ]+", " ")));
			sb.append(":").append(rni.sanatize(t.getValue().toString().replaceAll("\n", " ").replaceAll("[\\ ]+", " ")));
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public String getFinishedTypes(ReverseNameIndex rni)
	{
		StringBuilder sb = new StringBuilder();
		for(Entry<AST, Type> t : results.entrySet())
		{
			sb.append("(");
			sb.append(rni.sanatize(t.getKey().toString().replaceAll("\n", " ").replaceAll("[\\ ]+", " ")));
			sb.append(" # ");
			sb.append(t.getKey().getClass().getSimpleName());
			sb.append(")");
			sb.append("  ::  ").append(t.getValue());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	@Override
	public String toString()
	{
		return toString(new ReverseNameIndex());
	}
	
	public void unify()
	{
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private Type specify(Type a, Type b)
	{
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		if (a == b)
		{
			return a;
		}
		
		Type t = _specify(a, b);
		if (t == null) {
			t = _specify(b, a);
		}
		if (t == null) {
			throw new RuntimeException("mismatched types "+a+" :: "+b);
		}
		return t;
	}
	
	private Type _specify(Type a, Type b)
	{
		if (a == Type.INT && b == Type.NUMERIC_GENERAL)
		{
			return Type.INT;
		}
		
		return null;
	}
}
