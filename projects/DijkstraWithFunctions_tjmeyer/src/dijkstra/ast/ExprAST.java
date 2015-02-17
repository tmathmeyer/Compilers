package dijkstra.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import dijkstra.ds.ScopedSet;

public class ExprAST implements AST 
{
	// this is a stack !!
	private final List<AST> children = new ArrayList<>();
	
	public ExprAST(Stream<AST> map)
	{
		Iterator<AST> it = map.iterator();
		
		while(it.hasNext())
		{
			children.add(it.next());
		}
	}

	@Override
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		
		for(AST t : children)
		{
			s.append(t);
		}
		
		return s.toString();
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		for(AST t : children)
		{
			t.getDeclaredVariables(scope);
		}
		
		return scope;
	}
	
}
