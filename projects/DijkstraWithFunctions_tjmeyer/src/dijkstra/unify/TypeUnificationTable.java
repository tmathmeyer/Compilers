package dijkstra.unify;

import dijkstra.ast.AST;
import dijkstra.ast.expr.ExprAST;
import dijkstra.ast.expr.TerminalAST;
import dijkstra.type.Arrow;
import dijkstra.type.Monad;
import dijkstra.type.Type;
import dijkstra.unify.rlist.RList;

public class TypeUnificationTable
{
	private final ReverseNameIndex rni;
	
	private RList<Term, Constraint> temp = RList.emptyList();
	
	public TypeUnificationTable(RList<Term, Constraint> cs, ReverseNameIndex r)
	{
		this(r);
		temp = cs;
	}
	
	public TypeUnificationTable(ReverseNameIndex r)
	{
		rni = r;
	}
	
	public Term register(ExprAST tree, Term t)
	{
		Monad<Term> monad = Monad.of();
		temp = temp.setAdd(new Constraint(tree, t), monad);
		return monad.get();
	}
	
	public String toString()
	{
		return rni.sanatize(temp.toString());
	}
	
	public TypeUnificationTable getOnlyTerminalValues()
	{
		RList<Term, Constraint> mew = RList.emptyList();
		RList<Term, Constraint> temp = this.temp;
		
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
	
	
	public static RList<Term, Constraint> unify(RList<Term, Constraint> stack, RList<Term, Constraint> subst)
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
			RList<Term, Constraint> additions = current.generateAdditions();
			stack = RList.append(additions, stack);
			return unify(stack, subst);
		}
		
		throw new RuntimeException("didn't know what to do with: "+current);
	}

	private static RList<Term, Constraint> replaceInList(Term l, Term r, RList<Term, Constraint> s)
	{
		if (l instanceof Arrow) {
			return replaceInList(((Arrow) l).o, r, s);
		}
		if (r instanceof Arrow) {
			return replaceInList(l, ((Arrow) r).o, s);
		}
		return s.map(a -> new Constraint(a.left().replace(l, r), a.right().replace(l, r)));
	}
	
	public TypeUnificationTable check(RList<Term, Constraint> cons)
	{
		return new TypeUnificationTable(unify(temp, cons), rni);
	}

	public Type getTypeByName(AST outputAST)
	{
		while(!temp.empty())
		{
			Constraint c = temp.first();
			
			if (c.left().equals(outputAST))
			{
				if (c.right() instanceof Type)
				{
					return (Type) c.right();
				}
			}
			
			if (c.right().equals(outputAST))
			{
				if (c.left() instanceof Type)
				{
					return (Type) c.left();
				}
			}
			
			temp = temp.rest();
		}
		
		return Type.INT;
	}
}