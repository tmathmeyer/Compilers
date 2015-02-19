package dijkstra.unify;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import dijkstra.ast.AST;

public class TypeUnificationTable
{
	private final Map<AST, Type> table = new HashMap<>();
	
	public void register(AST tree, Type t)
	{
		table.put(tree, t);
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(Entry<AST, Type> t : table.entrySet())
		{
			sb.append(t.getKey().toString().replaceAll("\n", " ").replaceAll("[\\ ]+", " "));
			sb.append(":").append(t.getValue());
			sb.append("\n");
		}
		return sb.toString();
	}
}
