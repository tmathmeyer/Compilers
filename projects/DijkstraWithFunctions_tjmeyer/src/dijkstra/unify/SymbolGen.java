package dijkstra.unify;

public class SymbolGen
{
	private static int ctr = (int) (Math.random() * Integer.MAX_VALUE);
	
	public static String gensym()
	{
		return "__gen__"+ctr++;
	}
}
