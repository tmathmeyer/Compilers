package dijkstra.ast;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import dijkstra.lexparse.DijkstraParser.TypeContext;

public class ArrayDecAST implements AST
{
	private final String arrayType;
	private final AST arraySize;
	private final List<String> ids = new LinkedList<>();
	
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
}
