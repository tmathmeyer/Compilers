package dijkstra.unify.rlist;

import java.util.Set;
import java.util.function.Function;

import dijkstra.type.Monad;
import dijkstra.unify.Constraint;
import dijkstra.unify.Term;

public interface RList<W, T extends Combinable<T, W>>
{
	public RList<W, T> rest();
	public RList<W, T> cons(T t);
	public RList<W, T> setAdd(T t, Monad<W> monad);
	public T first();
	public boolean empty();
	public <X extends Combinable<X, W>> RList<W, X> map(Function<T, X> fnx);
	
	
	
	
	public static <L, Y extends Combinable<Y, L>> RList<L, Y> emptyList()
	{
		return new RList<L, Y>()
		{
			@Override
			public RList<L, Y> rest() { return this; }

			@Override
			public RList<L, Y> cons(Y t) { return new _RList<L, Y>(this, t); }

			@Override
			public Y first() { return null; }

			@Override
			public boolean empty() { return true; }

			@Override
			public <X extends Combinable<X, L>> RList<L, X> map(Function<Y, X> fnx) { return RList.emptyList(); }

			@Override
			public RList<L, Y> setAdd(Y t, Monad<L> monad)
			{
				monad.set(t.important());
				return cons(t);
			}
			
			@Override
			public String toString() { return ""; }
		};
	}

	public static RList<Term, Constraint> append(RList<Term, Constraint> add, RList<Term, Constraint> to)
	{
		while(!add.empty())
		{
			to = to.cons(add.first());
			add = add.rest();
		}
		return to;
	}
	
	public static <N, M extends Combinable<M,N>> RList<N, M> fromSet(Set<M> terms)
	{
		RList<N, M> res = emptyList();
		for(M m : terms)
		{
			res = res.cons(m);
		}
		return res;
	}
}
