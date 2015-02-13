package dijkstra.ast;

import dijkstra.lexparse.DijkstraParser.InputStatementContext;

public class InputAST implements AST
{
	private final String symbolString;
	private Type inputVariableType;
	
	public InputAST(InputStatementContext ctx)
	{
		this.symbolString = ctx.ID().getText();
	}

	public String getSymbolString()
	{
		return symbolString;
	}

	public Type getInputVariableType()
	{
		return inputVariableType;
	}

	public void setInputVariableType(Type inputVariableType)
	{
		this.inputVariableType = inputVariableType;
	}
	
	public String toString()
	{
		return "input " + symbolString;
	}
}
