package dijkstra.ast;

import java.util.ArrayList;
import java.util.stream.Stream;

import dijkstra.ast.FunctionAST.Param;
import dijkstra.ds.ScopedSet;

public class CompoundBodyAST implements AST
{
	private final ArrayList<AST> parts = new ArrayList<>();
	
	public CompoundBodyAST(Stream<AST> map)
	{
		map.forEach(a -> parts.add(a));
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder("{\n");
		for(AST t : parts)
		{
			sb.append("  ").append(t.toString()).append("\n");
		}
		return sb.append("}").toString();
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		ScopedSet<String> current = new ScopedSet<>(this);
		
		for(AST t : parts)
		{
			t.getDeclaredVariables(current);
		}
		
		scope.merge(current.finish());
		return scope;
	}
}
