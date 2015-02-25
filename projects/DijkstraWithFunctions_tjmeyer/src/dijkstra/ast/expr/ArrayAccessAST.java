package dijkstra.ast.expr;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import dijkstra.ast.AST;
import dijkstra.type.Type;
import dijkstra.unify.ScopedSet;
import dijkstra.unify.TypeUnificationTable;

public class ArrayAccessAST extends ExprAST
{
	private final ExprAST numericEqu;
	private final String arr;
	
	public ArrayAccessAST(String id, AST expr)
	{
		arr = id;
		numericEqu = (ExprAST) expr;
	}
	
	@Override
	public String toString()
	{
		return arr + "[" + numericEqu + "]";
	}

	@Override
	public AST renameScoping(ScopedSet<VarBind> vb)
	{
		AST t = numericEqu.renameVars(vb.getScopeVars(numericEqu));
		t = t.renameVars(vb.getScopeVars(this));
		return new ArrayAccessAST(arr, t);
	}

	@Override
	public ExprAST renameVars(Set<VarBind> s)
	{
		for(VarBind b : s)
		{
			if (b.old.equals(arr))
			{
				return new ArrayAccessAST(b.New, numericEqu.renameVars(s));
			}
		}
		return this;
	}

	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		numericEqu.buildTUT(tut);
		tut.register(numericEqu, Type.INT);
		new TerminalAST(arr, Type.UNKNOWN).buildTUT(tut);
	}

	@Override
	protected List<AST> getChildren()
	{
		return new LinkedList<>();
	}
}
