package dijkstra.ast;

public class OutputAST implements AST
{
	private final AST outputAST;
	
	public OutputAST(AST accept)
	{
		outputAST = accept;
	}
	
	public String toString()
	{
		return "print "+outputAST;
	}
	
}
