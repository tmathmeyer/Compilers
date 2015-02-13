package dijkstra.ast;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import dijkstra.lexparse.DijkstraParser.VarContext;

public class AssignmentAST implements AST
{
	private final Map<String, Type> types = new HashMap<>();
	private final Map<String, AST> exprs = new HashMap<>();
	
	public AssignmentAST(List<VarContext> vars, Stream<AST> xpressions)
	{
		Iterator<VarContext> varsI = vars.iterator();
		Iterator<AST> exprsI = xpressions.iterator();
		
		while(varsI.hasNext() && exprsI.hasNext())
		{
			String var = varsI.next().getText();
			AST ast = exprsI.next();
			types.put(var, Type.UNKNOWN);
			exprs.put(var, ast);
		}
		
		if(varsI.hasNext() != exprsI.hasNext())
		{
			throw new RuntimeException("YOU HAVE MISMATCHED SHIT YO");
		}
	}
	
	@Override
	public String toString()
	{
		List<String> left = new LinkedList<>();
		List<String> right = new LinkedList<>();
		
		for(Entry<String, AST> e : exprs.entrySet())
		{
			left.add(e.getKey());
			right.add(e.getValue()+"");
		}
		
		return String.join(",", left) + " <- " + String.join(",", right);
	}

}
