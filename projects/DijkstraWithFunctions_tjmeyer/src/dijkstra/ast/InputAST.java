package dijkstra.ast;

import dijkstra.ds.ScopedSet;
import dijkstra.lexparse.DijkstraParser.InputStatementContext;

public class InputAST implements AST
{
	private final TerminalAST input;
	
	public InputAST(InputStatementContext ctx)
	{
		input = new TerminalAST(ctx.ID().getText());
	}

	public InputAST(TerminalAST in)
	{
		input = in;
	}

	public String getSymbolString()
	{
		return input.toString();
	}

	public Type getInputVariableType()
	{
		return input.getT();
	}

	public void setInputVariableType(Type inputVariableType)
	{
		input.setT(inputVariableType);
	}
	
	public String toString()
	{
		return "input " + input;
	}
	
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		return input.getDeclaredVariables(scope);
	}
}
