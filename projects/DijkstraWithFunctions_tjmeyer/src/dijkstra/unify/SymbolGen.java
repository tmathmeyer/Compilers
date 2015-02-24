package dijkstra.unify;

public class SymbolGen
{
	private static int ctr = (int) (Math.random() * 0);
	
	public static String gensym()
	{
		return "_g_"+((ctr++) + 'a')+"_";
	}
}
