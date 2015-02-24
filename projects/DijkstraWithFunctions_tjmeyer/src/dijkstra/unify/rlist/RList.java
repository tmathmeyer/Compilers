package dijkstra.unify.rlist;

import java.util.Set;
import java.util.function.Function;

import dijkstra.unify.Constraint;

public interface RList<T extends Combinable<T>>
{
	public RList<T> rest();
	public RList<T> cons(T t);
	public RList<T> setAdd(T t);
	public T first();
	public boolean empty();
	
	
	public <X extends Combinable<X>> RList<X> map(Function<T, X> fnx);
	
	public static <Y extends Combinable<Y>> RList<Y> emptyList()
	{
		return new RList<Y>()
		{
			@Override
			public RList<Y> rest() { return this; }

			@Override
			public RList<Y> cons(Y t) { return new _RList<Y>(this, t); }

			@Override
			public Y first() { return null; }

			@Override
			public boolean empty() { return true; }

			@Override
			public <X extends Combinable<X>> RList<X> map(Function<Y, X> fnx) { return RList.emptyList(); }

			@Override
			public RList<Y> setAdd(Y t) { return cons(t); }
			
			@Override
			public String toString() { return ""; }
		};
	}

	public static RList<Constraint> append(RList<Constraint> add, RList<Constraint> to)
	{
		while(!add.empty())
		{
			to = to.cons(add.first());
			add = add.rest();
		}
		return to;
	}
	public static <M extends Combinable<M>> RList<M> fromSet(Set<M> terms)
	{
		RList<M> res = emptyList();
		for(M m : terms)
		{
			res = res.cons(m);
		}
		return res;
	}
}
