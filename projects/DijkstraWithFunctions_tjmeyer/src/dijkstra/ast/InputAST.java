package dijkstra.ast;

import java.util.Set;

import dijkstra.lexparse.DijkstraParser.InputStatementContext;
import dijkstra.unify.ScopedSet;
import dijkstra.unify.Type;
import dijkstra.unify.TypeUnificationTable;

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
	
	@Override
	public String toString()
	{
		return "input " + input;
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		return input.getDeclaredVariables(scope);
	}
	
	@Override
	public AST renameVars(Set<VarBind> s)
	{
		return new InputAST(input.renameVars(s));
	}
	
	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		input.buildTUT(tut);
	}
}
