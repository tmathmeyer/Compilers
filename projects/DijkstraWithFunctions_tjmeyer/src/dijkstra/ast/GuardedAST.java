package dijkstra.ast;

import java.util.Set;

import dijkstra.unify.ScopedSet;

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
	
	@Override
	public AST renameVars(Set<VarBind> scope)
	{
		return new GuardedAST(conditional.renameVars(scope), statement.renameVars(scope));
	}
}
