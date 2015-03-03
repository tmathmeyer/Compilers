package dijkstra.unify;

public class SymbolGen
{
	private static int ctr = (int) (Math.random() * 0);
	private static int addr = 0;
	
	public static String gensym()
	{
		addr++;
		return "_g_"+((ctr++) + 'a')+"_";
	}
	
	public static int getAddr()
	{
		return addr;
	}
	
	
}
