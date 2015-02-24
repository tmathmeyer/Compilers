package dijkstra.unify.rlist;

import java.util.function.Function;

import dijkstra.type.Monad;

public class _RList<D, T extends Combinable<T, D>> implements RList<D, T>
{
	private final RList<D, T> list;
	private final T t;
	
	_RList(RList<D, T> RList, T t2)
	{
		list = RList;
		t = t2;
	}

	@Override
	public RList<D, T> rest()
	{
		return list;
	}

	@Override
	public RList<D, T> cons(T t)
	{
		return new _RList<D, T>(this, t);
	}

	@Override
	public T first()
	{
		return t;
	}

	@Override
	public boolean empty()
	{
		return false;
	}

	@Override
	public <X extends Combinable<X, D>> RList<D, X> map(Function<T, X> fnx)
	{
		return new _RList<D, X>(list.map(fnx), fnx.apply(t));
	}

	@Override
	public RList<D, T> setAdd(T a, Monad<D> monad)
	{
		if (a.equals(t))
		{
			return new _RList<D, T>(list, a.combine(t));
		}
		
		return new _RList<D, T>(list.setAdd(a, monad), t);
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		RList<D, T> temp = this;
		while(!temp.empty())
		{
			sb.append(temp.first()).append("\n");
			temp = temp.rest();
		}
		return sb.toString();
	}

}
