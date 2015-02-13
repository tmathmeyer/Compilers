package dijkstra.ast;

import org.antlr.v4.runtime.tree.TerminalNodeImpl;

public class TerminalAST implements AST
{
	private final String name;
	
	public TerminalAST(TerminalNodeImpl tree)
	{
		name = tree.getText();
	}

	@Override
	public String toString()
	{
		return name;
	}
}
