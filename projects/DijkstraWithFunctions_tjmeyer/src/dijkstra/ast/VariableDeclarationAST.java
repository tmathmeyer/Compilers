package dijkstra.ast;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import dijkstra.lexparse.DijkstraParser.TypeContext;

public class VariableDeclarationAST implements AST
{
	private final String type;
	private final List<String> decs = new ArrayList<>();
	public VariableDeclarationAST(TypeContext t, List<TerminalNode> iDsFromList)
	{
		type = t.getText();
		for(TerminalNode tt : iDsFromList)
		{
			decs.add(tt.getText());
		}
	}
	
	@Override
	public String toString()
	{
		return type + " " + String.join(",", decs);
	}

}
