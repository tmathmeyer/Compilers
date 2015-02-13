package dijkstra.ast;

import java.util.LinkedList;
import java.util.stream.Stream;

public class FunctionCallAST implements AST
{
	private final String fname;
	private final LinkedList<AST> args = new LinkedList<>();
	
	public FunctionCallAST(String id, Stream<AST> map)
	{
		fname = id;
		map.forEach(a -> args.push(a));
	}

	public String toString()
	{
		LinkedList<String> argsS = new LinkedList<>();
		args.stream().forEach(e -> argsS.add(e.toString()));
		return fname + "(" + String.join(",", argsS) + ")";
	}
}
