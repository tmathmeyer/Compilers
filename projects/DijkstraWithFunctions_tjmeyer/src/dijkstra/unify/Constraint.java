package dijkstra.unify;

import dijkstra.type.Arrow;
import dijkstra.type.Type;
import dijkstra.unify.rlist.Combinable;
import dijkstra.unify.rlist.RList;

public class Constraint implements Combinable<Constraint, Term>
{
	public static final boolean PRETTY = true;
	
	private final Term left, right;
	
	public Constraint(Term l, Term r)
	{
		left = l;
		right = r;
	}
	
	public String toString()
	{
		return left + " :: "+ right;
	}

	public String pretty(ReverseNameIndex rni)
	{
		return PRETTY?rni.sanatize(toString()):toString();
	}
	
	public boolean same()
	{
		return eqh(left, right);
	}
	
	private boolean eqh(Term left, Term right)
	{
		if (left instanceof Type && right instanceof Type)
		{
			Type l = (Type)left;
			Type r = (Type)right;
			return l == r || l.eq(l, r) || r.eq(r, l);
		}
		
		if (left instanceof Arrow && right instanceof Type)
		{
			return eqh(((Arrow)left).o, right);
		}
		
		if (right instanceof Arrow && left instanceof Type)
		{
			return eqh(((Arrow)right).o, left);
		}
		
		return left.equals(right);
	}
	
	
	public Term left()
	{
		return left;
	}

	public Term right()
	{
		return right;
	}
	
	public boolean matchingArity()
	{
		return false;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		
		Constraint other = (Constraint) obj;
		if (left == null)
		{
			if (other.left != null)
			{
				return false;
			}
		}
		else if (!eqh(left, other.left))
		{
			return false;
		}
		if (right == null)
		{
			if (other.right != null)
			{
				return false;
			}
		}
		else if (!eqh(right, other.right))
		{
			return false;
		}
		return true;
	}

	
	
	public RList<Term, Constraint> generateAdditions()
	{
		throw new RuntimeException("stop. you should not be doing that");
	}

	@Override
	public Constraint combine(Constraint x)
	{
		return new Constraint(left.combine(x.left), right.combine(x.right));
	}

	@Override
	public Term important()
	{
		if (left == Type.INT && right == Type.INT)
		{
			return Type.INT;
		}
		
		if (left == Type.FLOAT && right == Type.FLOAT)
		{
			return Type.FLOAT;
		}
		
		if (left == Type.INT && right == Type.FLOAT)
		{
			return Type.NUMERIC_GENERAL;
		}
		
		if (right == Type.INT && left == Type.FLOAT)
		{
			throw new RuntimeException("you can't do that Dave");
		}
		
		if ((left==Type.INT || left==Type.FLOAT) && right == Type.NUMERIC_GENERAL)
		{
			return left;
		}
		
		if ((right==Type.INT || right==Type.FLOAT) && left == Type.NUMERIC_GENERAL)
		{
			return right;
		}
		
		if (!(left instanceof Type))
		{
			return right;
		}
		
		if (!(right instanceof Type))
		{
			return left;
		}
		
		return Type.NUMERIC_GENERAL;
	}

	
}
