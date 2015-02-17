package dijkstra.ds;

public interface Stack<T>
{
	Stack<T> pop();
	Stack<T> push(T t);
	T peek();
	T lookup(T t);
	int size();
	
	
	public static <T> Stack<T> getEmptyStack()
	{
		return new Stack<T>()
		{
			@Override
			public Stack<T> pop()
			{
				return this;
			}

			@Override
			public Stack<T> push(T t)
			{
				return new _Stack<T>(t, this);
			}

			@Override
			public T peek()
			{
				return null;
			}

			@Override
			public int size()
			{
				return 0;
			}

			@Override
			public T lookup(T t)
			{
				return null;
			}
		};
	}
}

class _Stack<T> implements Stack<T>
{
	private final int size;
	private final T t;
	private final Stack<T> rest;
	
	public _Stack(T t2, Stack<T> _Stack)
	{
		t = t2;
		rest = _Stack;
		size = rest.size()+1;
	}

	@Override
	public Stack<T> pop()
	{
		return rest;
	}

	@Override
	public Stack<T> push(T t) 
	{
		return new _Stack<T>(t, this);
	}

	@Override
	public T peek()
	{
		return t;
	}

	@Override
	public int size()
	{
		return size;
	}

	@Override
	public T lookup(T t)
	{
		if (this.t.equals(t))
		{
			return this.t;
		}
		return rest.lookup(t);
	}
	
}
