package dijkstra.unify;

import dijkstra.ast.expr.ExprAST;
import dijkstra.ast.expr.TerminalAST;
import dijkstra.type.Arrow;
import dijkstra.unify.rlist.RList;

public class TypeUnificationTable
{
	private final ReverseNameIndex rni;
	
	private RList<Constraint> temp = RList.emptyList();
	
	public TypeUnificationTable(RList<Constraint> cs, ReverseNameIndex r)
	{
		this(r);
		temp = cs;
	}
	
	public TypeUnificationTable(ReverseNameIndex r)
	{
		rni = r;
	}
	
	public void register(ExprAST tree, Term t)
	{
		temp = temp.setAdd(new Constraint(tree, t));
	}
	
	public String toString()
	{
		return rni.sanatize(temp.toString());
	}
	
	public TypeUnificationTable getOnlyTerminalValues()
	{
		RList<Constraint> mew = RList.emptyList();
		RList<Constraint> temp = this.temp;
		
		while(!temp.empty())
		{
			if (temp.first().left() instanceof TerminalAST)
			{
				mew = mew.cons(temp.first());
			}
			temp = temp.rest();
		}
		
		return new TypeUnificationTable(mew, rni);
	}
	
	
	public static RList<Constraint> unify(RList<Constraint> stack, RList<Constraint> subst)
	{
		if (stack.empty())
		{
			return subst;
		}
		
		Constraint current = stack.first();
		stack = stack.rest();
		
		if (current.same())
		{
			return unify(stack, subst);
		}
		
		if (current.left().isID())
		{
			stack = replaceInList(current.left(), current.right(), stack);
			subst = replaceInList(current.left(), current.right(), subst);
			return unify(stack, subst.cons(current));
		}
		
		if (current.right().isID())
		{
			stack = replaceInList(current.right(), current.left(), stack);
			subst = replaceInList(current.right(), current.left(), subst);
			return unify(stack, subst.cons(current));
		}
		
		if (current.matchingArity())
		{
			RList<Constraint> additions = current.generateAdditions();
			stack = RList.append(additions, stack);
			return unify(stack, subst);
		}
		
		throw new RuntimeException("didn't know what to do with: "+current);
	}

	private static RList<Constraint> replaceInList(Term l, Term r, RList<Constraint> s)
	{
		if (l instanceof Arrow) {
			return replaceInList(((Arrow) l).o, r, s);
		}
		if (r instanceof Arrow) {
			return replaceInList(l, ((Arrow) r).o, s);
		}
		return s.map(a -> new Constraint(a.left().replace(l, r), a.right().replace(l, r)));
	}
	
	public TypeUnificationTable check(RList<Constraint> cons)
	{
		return new TypeUnificationTable(unify(temp, cons), rni);
	}
}