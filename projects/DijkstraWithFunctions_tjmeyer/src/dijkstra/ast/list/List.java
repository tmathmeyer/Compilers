package dijkstra.ast.list;

import dijkstra.ast.AST;

public interface List<T>
{
	List<T> push(T t);
	List<T> pop();
	T peek();
	int size();
	List<T> append(List<T> l);
	
	public static <T> List<T> newList()
	{
		return new List<T>()
		{
			@Override
			public List<T> push(T t)
			{
				return new _List<T>(t, this);
			}

			@Override
			public List<T> pop()
			{
				return this;
			}

			@Override
			public T peek()
			{
				throw new RuntimeException("cant peek an empty list");
			}

			@Override
			public int size()
			{
				return 0;
			}

			@Override
			public List<T> append(List<T> l)
			{
				return l;
			}
			
		};
	}
}
