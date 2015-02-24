package dijkstra.unify;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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

	public String sanatize(String replaceAll)
	{
		for(Entry<String, String> t : reverse.entrySet())
		{
			replaceAll = replaceAll.replaceAll(t.getKey(), t.getValue());
		}
		return replaceAll;
	}
}
