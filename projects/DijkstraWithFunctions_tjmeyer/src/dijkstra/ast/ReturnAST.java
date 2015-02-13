package dijkstra.ast;

import java.util.LinkedList;
import java.util.stream.Stream;

public class ReturnAST implements AST
{
	private final LinkedList<AST> parts = new LinkedList<>();
	
	public ReturnAST(Stream<AST> map)
	{
		map.forEach(a -> parts.push(a));
	}

	public String toString()
	{
		LinkedList<String> partsS = new LinkedList<>();
		parts.stream().forEach(e -> partsS.add(e.toString()));
		return "return "+String.join(",", partsS);
	}
}
