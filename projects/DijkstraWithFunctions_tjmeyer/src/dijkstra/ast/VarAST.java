package dijkstra.ast;

import dijkstra.unify.ScopedSet;

public class VarAST implements AST
{
	private final String name;
	//private String type;
	
	public VarAST(String text)
	{
		name = text;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		scope.insert(name);
		return scope;
	}
}
