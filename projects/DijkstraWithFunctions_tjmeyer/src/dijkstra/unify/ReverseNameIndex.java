package dijkstra.unify;

import java.util.HashMap;
import java.util.Map;

public class ReverseNameIndex
{
	private final Map<String, String> reverse = new HashMap<>();
	
	public void addLookup(String from, String to)
	{
		reverse.put(to, from);
	}
	
	public String lookup(String s)
	{
		return reverse.get(s);
	}
	
	public String toString()
	{
		return reverse.toString();
	}
}
