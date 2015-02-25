package dijkstra.ast.expr;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import dijkstra.ast.AST;
import dijkstra.type.Type;
import dijkstra.unify.Term;
import dijkstra.unify.TypeUnificationTable;

public class NegExpr extends ExprAST
{
	private final ExprAST n;
	public NegExpr(ExprAST next)
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
		n.buildAssignment(tut);
		
		tut.register(n, Type.NUMERIC_GENERAL);
		tut.register(this, n);
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
	
	@Override
	public Term replace(Term l, Term r)
	{
		if (this.equals(l))
		{
			return r;
		}

		return this;
	}
}
