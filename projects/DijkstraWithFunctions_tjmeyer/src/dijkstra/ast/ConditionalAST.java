package dijkstra.ast;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ConditionalAST implements AST
{
	private final List<AST> conditionals = new LinkedList<>();
	
	public ConditionalAST(Stream<AST> map)
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
		sb.append("if\n");
		for(AST t : conditionals)
		{
			sb.append("   ").append(t).append("\n");
		}
		sb.append("fi");
		return sb.toString();
	}

	@Override
	public AST renameVars(Set<VarBind> scope)
	{
		return new ConditionalAST(conditionals.stream().map(a -> a.renameVars(scope)));
	}
}
