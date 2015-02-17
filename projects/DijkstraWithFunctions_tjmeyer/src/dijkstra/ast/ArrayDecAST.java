package dijkstra.ast;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import dijkstra.ds.ScopedSet;
import dijkstra.lexparse.DijkstraParser.TypeContext;

public class ArrayDecAST implements AST
{
	private final String arrayType; // a type
	private final AST arraySize; // an expression that evaluates to a number
	private final List<String> ids = new LinkedList<>(); // a series of names
	
	public ArrayDecAST(TypeContext type, AST expr, List<TerminalNode> iDsFromList)
	{
		arrayType = type.getText();
		arraySize = expr;
		Iterator<String> it = iDsFromList.stream().map(e -> e.getText()).iterator();
		while(it.hasNext())
		{
			ids.add(it.next());
		}
	}

	public String toString()
	{
		return arrayType + "[" + arraySize + "] " + String.join(",", ids);
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		for(String p : ids)
		{
			scope.insert(p);
		}
		
		return scope;
	}
}
