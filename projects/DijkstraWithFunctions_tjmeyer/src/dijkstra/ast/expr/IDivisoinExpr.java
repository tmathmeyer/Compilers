package dijkstra.ast.expr;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import dijkstra.ast.AST;
import dijkstra.unify.Type;
import dijkstra.unify.TypeUnificationTable;

public class IDivisoinExpr extends ExprAST
{
	private final AST f, l;
	
	public IDivisoinExpr(AST first, AST last)
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
		f.buildTUT(tut);
		l.buildTUT(tut);
		
		tut.register(f, Type.INT);
		tut.register(l, Type.INT);
		tut.register(this, Type.INT);
	}
	
	@Override
	public ExprAST renameVars(Set<VarBind> s)
	{
		return new IDivisoinExpr(f.renameVars(s), l.renameVars(s));
	}
	
	@Override
	public String toString()
	{
		return f + "//" + l;
	}
}
