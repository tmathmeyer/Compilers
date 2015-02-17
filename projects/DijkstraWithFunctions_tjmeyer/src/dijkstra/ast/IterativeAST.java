package dijkstra.ast;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import dijkstra.ds.ScopedSet;

public class IterativeAST implements AST
{

private final List<AST> conditionals = new LinkedList<>();
	
	public IterativeAST(Stream<AST> map)
	{
		Iterator<AST> it = map.iterator();
		while(it.hasNext())
		{
			conditionals.add(it.next());
		}
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("do\n");
		for(AST t : conditionals)
		{
			sb.append("   ").append(t).append("\n");
		}
		sb.append("od");
		return sb.toString();
	}

	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		ScopedSet<String> current = new ScopedSet<>(this);
		
		for(AST p : conditionals)
		{
			p.getDeclaredVariables(current);
		}
		
		scope.merge(current.finish());
		return scope;
	}
}
