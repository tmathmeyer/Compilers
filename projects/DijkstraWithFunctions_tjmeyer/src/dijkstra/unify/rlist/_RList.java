package dijkstra.unify.rlist;

import java.util.function.Function;

public class _RList<T extends Combinable<T>> implements RList<T>
{
	private final RList<T> list;
	private final T t;
	
	_RList(RList<T> RList, T t2)
	{
		list = RList;
		t = t2;
	}

	@Override
	public RList<T> rest()
	{
		return list;
	}

	@Override
	public RList<T> cons(T t)
	{
		return new _RList<T>(this, t);
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
	public <X extends Combinable<X>> RList<X> map(Function<T, X> fnx)
	{
		return new _RList<X>(list.map(fnx), fnx.apply(t));
	}

	@Override
	public RList<T> setAdd(T a)
	{
		if (a.equals(t))
		{
			return new _RList<T>(list, a.combine(t));
		}
		
		return new _RList<T>(list.setAdd(a), t);
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		RList<T> temp = this;
		while(!temp.empty())
		{
			sb.append(temp.first()).append("\n");
			temp = temp.rest();
		}
		return sb.toString();
	}

}
