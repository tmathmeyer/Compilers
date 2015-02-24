package dijkstra.ast;

import java.util.Set;

import dijkstra.unify.ScopedSet;

public class ReturnAST implements AST
{
	private final AST parts;

	public AST getParts()
	{
		return parts;
	}
	
	public ReturnAST(AST accept)
	{
		parts = accept;
	}

	public String toString()
	{
		return "return "+parts.toString();
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{	
		return scope;
	}
	
	@Override
	public AST renameVars(Set<VarBind> scope)
	{
		return new ReturnAST(parts.renameVars(scope));
	}
}
