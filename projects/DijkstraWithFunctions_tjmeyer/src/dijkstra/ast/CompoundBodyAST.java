package dijkstra.ast;

import java.util.LinkedList;
import java.util.stream.Stream;

public class CompoundBodyAST implements AST
{
	private final LinkedList<AST> parts = new LinkedList<>();
	
	public CompoundBodyAST(Stream<AST> map)
	{
		map.forEach(a -> parts.push(a));
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
}
