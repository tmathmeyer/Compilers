package dijkstra.ast;

import java.util.Set;

import dijkstra.ast.expr.ExprAST;
import dijkstra.type.Type;
import dijkstra.unify.ScopedSet;
import dijkstra.unify.TypeUnificationTable;

public class GuardedAST implements AST
{
	private final ExprAST conditional;
	private final AST statement;
	
	public GuardedAST(AST c, AST s)
	{
		conditional = (ExprAST) c;
		statement = s;
	}
	
	@Override
	public String toString()
	{
		return conditional + " :: " + statement;
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		return statement.getDeclaredVariables(scope);
	}
	
	@Override
	public AST renameVars(Set<VarBind> scope)
	{
		return new GuardedAST(conditional.renameVars(scope), statement.renameVars(scope));
	}
	
	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		tut.register(conditional, Type.BOOLEAN);
		
		conditional.buildTUT(tut);
		statement.buildTUT(tut);
	}
}
