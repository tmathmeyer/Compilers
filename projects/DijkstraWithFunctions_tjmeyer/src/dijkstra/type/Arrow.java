package dijkstra.type;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

import dijkstra.ast.expr.TerminalAST;
import dijkstra.unify.Term;

public class Arrow implements AType
{
	public final Term i, o;
	
	public Arrow(Term i, Term o)
	{
		this.i = i;
		this.o = o;
	}

	@Override
	public boolean isID()
	{
		return false;
	}

	@Override
	public Term replace(Term l, Term r)
	{
		if (equals(l))
		{
			return r;
		}
		
		return new Arrow(i.replace(l, r), o.replace(l, r));
	}

	public static AType fromList(Collection<TerminalAST> args)
	{
		if (args.size() == 0)
		{
			return Type.VOID;
		}
		
		Queue<TerminalAST> q = new LinkedList<>();
		q.addAll(args);
		TerminalAST t = q.remove();
		if (q.size() == 0)
		{
			if (t.getT() == Type.UNKNOWN)
			{
				return t;
			}
			return t.getT();
		}
		
		if (q.size() == 1)
		{
			if (t.getT() == Type.UNKNOWN)
			{
				return new Arrow(t, q.remove());
			}
			return new Arrow(t.getT(), q.remove());
		}
		
		return new Arrow(t.getT(), fromList(q));
	}
	
	public String toString()
	{
		return "(" + i + ") -> " + o;
	}

	@Override
	public Term combine(Term other)
	{
		if (other.equals(this))
		{
			return this;
		}
		
		if (other.equals(o))
		{
			return o;
		}
		
		throw new RuntimeException("cant consolidate "+this+" and "+other);
	}
}
