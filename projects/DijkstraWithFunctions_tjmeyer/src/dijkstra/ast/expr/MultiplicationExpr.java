package dijkstra.ast.expr;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import dijkstra.ast.AST;
import dijkstra.type.Type;
import dijkstra.unify.TypeUnificationTable;

public class MultiplicationExpr extends ExprAST
{
	private final ExprAST f, l;
	
	public MultiplicationExpr(ExprAST first, ExprAST last)
	{
		f = first;
		l = last;
	}
	
	@Override
	protected List<AST> getChildren() {
		List<AST> t = new LinkedList<>();
		t.add(f);
		t.add(l);
		return t;
	}
	
	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		f.buildAssignment(tut);
		l.buildAssignment(tut);
		
		tut.register(f, Type.NUMERIC_GENERAL);
		tut.register(l, Type.NUMERIC_GENERAL);
		tut.register(this, Type.NUMERIC_GENERAL);
	}

	@Override
	public ExprAST renameVars(Set<VarBind> s)
	{
		return new MultiplicationExpr(f.renameVars(s), l.renameVars(s));
	}
	
	@Override
	public String toString()
	{
		return f + "*" + l;
	}
	
	
}
