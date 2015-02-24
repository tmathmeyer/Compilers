package dijkstra.ast.expr;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import dijkstra.ast.AST;
import dijkstra.type.Type;
import dijkstra.unify.TypeUnificationTable;

public class AdditionExpr extends ExprAST
{
	private final ExprAST f, l;
	
	public AdditionExpr(ExprAST first, ExprAST last)
	{
		f = first;
		l = last;
	}

	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		f.buildTUT(tut);
		l.buildTUT(tut);
		
		tut.register(f, Type.NUMERIC_GENERAL);
		tut.register(l, Type.NUMERIC_GENERAL);
		tut.register(this, Type.NUMERIC_GENERAL);
	}

	@Override
	protected List<AST> getChildren() {
		List<AST> t = new LinkedList<>();
		t.add(f);
		t.add(l);
		return t;
	}
	
	@Override
	public ExprAST renameVars(Set<VarBind> s)
	{
		return new AdditionExpr(f.renameVars(s), l.renameVars(s));
	}
	
	@Override
	public String toString()
	{
		return f + "+" + l;
	}
}
