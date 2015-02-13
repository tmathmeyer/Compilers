package dijkstra.ast;

public class ArrayAccessAST implements AST
{
	private final AST numericEqu;
	private final String arr;
	
	public ArrayAccessAST(String id, AST expr)
	{
		arr = id;
		numericEqu = expr;
	}
	
	@Override
	public String toString()
	{
		return arr + "[" + numericEqu + "]";
	}

}
