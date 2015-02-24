package dijkstra.ast.expr;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import dijkstra.ast.AST;
import dijkstra.unify.Type;
import dijkstra.unify.TypeUnificationTable;

public class NegExpr extends ExprAST
{
	private final AST n;
	public NegExpr(AST next)
	{
		n = next;
	}
	
	@Override
	protected List<AST> getChildren() {
		List<AST> t = new LinkedList<>();
		t.add(n);
		return t;
	}

	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		n.buildTUT(tut);
		
		tut.register(n, Type.NUMERIC_GENERAL);
		tut.register(this, Type.NUMERIC_GENERAL);
	}
	
	@Override
	public ExprAST renameVars(Set<VarBind> s)
	{
		return new NegExpr(n.renameVars(s));
	}
	
	@Override
	public String toString()
	{
		return "-" + n;
	}
}
