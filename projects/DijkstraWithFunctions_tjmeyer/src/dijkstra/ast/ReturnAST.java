package dijkstra.ast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Stream;

import dijkstra.unify.ScopedSet;

public class ReturnAST implements AST
{
	private final ArrayList<AST> parts = new ArrayList<>();
	
	public ReturnAST(Stream<AST> map)
	{
		map.forEach(a -> parts.add(a));
	}

	public String toString()
	{
		LinkedList<String> partsS = new LinkedList<>();
		parts.stream().forEach(e -> partsS.add(e.toString()));
		return "return "+String.join(",", partsS);
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{	
		return scope;
	}
	
	@Override
	public AST renameVars(Set<VarBind> scope)
	{
		return new ReturnAST(parts.stream().map(a -> a.renameVars(scope)));
	}
}
