package dijkstra.ast;

import java.util.LinkedList;
import java.util.stream.Stream;

public class AssignmentAST implements AST
{
	private final LinkedList<AST> assignTo = new LinkedList<>();
	private final LinkedList<AST> assignFrom = new LinkedList<>();
	
	public AssignmentAST(Stream<AST> vars, Stream<AST> xpressions)
	{
		vars.forEach(a -> assignTo.push(a));
		xpressions.forEach(a -> assignFrom.push(a));
	}
	
	@Override
	public String toString()
	{
		LinkedList<String> left = new LinkedList<>();
		LinkedList<String> right = new LinkedList<>();
		
		assignTo.forEach(a -> left.push(a.toString()));
		assignFrom.forEach(a -> right.push(a.toString()));
		
		return String.join(",", left) + " <- " + String.join(",", right);
	}

}
