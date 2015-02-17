package dijkstra.ds;

import java.util.LinkedList;
import java.util.List;

import dijkstra.ast.AST;
import dijkstra.ast.Type;

public class TypeUnificationTable
{
	public final List<Object> table = new LinkedList<>();
	
	public TypeUnificationTable register(AST a, AST b)
	{
		return null;
	}
	
	public TypeUnificationTable register(AST a, Type b)
	{
		return null;
	}
	
	public static class TypedTuple
	{
		private final AST a = null;
	}
}
