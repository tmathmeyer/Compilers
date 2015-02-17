package dijkstra.ast;

import dijkstra.ds.ScopedSet;

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
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		return statement.getDeclaredVariables(scope);
	}
}
