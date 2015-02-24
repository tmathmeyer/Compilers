package dijkstra.unify.rlist;

public interface Combinable<X, Y>
{
	public X combine(X x);
	
	public Y important();
}
