package dijkstra.ast;

import java.util.Set;

import dijkstra.unify.TypeUnificationTable;

public class OutputAST implements AST
{
	private final AST outputAST;
	
	public OutputAST(AST accept)
	{
		outputAST = accept;
	}
	
	public String toString()
	{
		return "print "+outputAST;
	}
	
	@Override
	public AST renameVars(Set<VarBind> s)
	{
		return new OutputAST(outputAST.renameVars(s));
	}
	
	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		outputAST.buildTUT(tut);
	}
}
