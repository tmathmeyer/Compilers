package dijkstra.ast;

public class GuardedAST implements AST
{
	private final AST conditional;
	private final AST statement;
	
	public GuardedAST(AST c, AST s)
	{
		conditional = c;
		statement = s;
	}
	
	@Override
	public String toString()
	{
		return conditional + " :: " + statement;
	}
}
