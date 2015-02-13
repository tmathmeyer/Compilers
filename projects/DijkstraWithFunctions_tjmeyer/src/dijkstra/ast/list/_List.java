package dijkstra.ast.list;

public class _List<T> implements List<T>
{
	private final T t;
	private final List<T> rest;
	private final int size;

	public _List(T t, List<T> r)
	{
		this.t = t;
		this.rest = r;
		this.size = r.size()+1;
	}
	
	@Override
	public List<T> push(T t)
	{
		return new _List<T>(t, this);
	}

	@Override
	public List<T> pop()
	{
		return rest;
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
	public List<T> append(List<T> l)
	{
		return new _List<T>(t, l.append(rest));
	}
	
}
