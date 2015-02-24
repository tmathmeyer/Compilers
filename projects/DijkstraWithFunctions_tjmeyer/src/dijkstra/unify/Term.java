package dijkstra.unify;

public interface Term
{
	boolean isID();

	Term replace(Term l, Term r);

	Term combine(Term left);
}
