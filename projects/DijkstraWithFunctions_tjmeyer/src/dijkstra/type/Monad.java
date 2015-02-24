package dijkstra.type;

public class Monad<T>
{
	private T t;
	
	public static <T> Monad<T> of()
	{
		return of(null);
	}
	
	public static <T> Monad<T> of(T t)
	{
		return new Monad<T>(t);
	}
	
	private Monad(T tt)
	{
		t = tt;
	}
	
	public T get()
	{
		return t;
	}
	
	public void set(T tt)
	{
		t = tt;
	}
}
