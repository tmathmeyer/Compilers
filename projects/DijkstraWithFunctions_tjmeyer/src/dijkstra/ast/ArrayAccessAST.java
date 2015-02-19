package dijkstra.ast;

import java.util.Set;

import dijkstra.unify.ScopedSet;

public class ArrayAccessAST implements AST
{
	private final AST numericEqu;
	private final String arr;
	
	public ArrayAccessAST(String id, AST expr)
	{
		arr = id;
		numericEqu = expr;
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
	public AST renameVars(Set<VarBind> s)
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
}
