package dijkstra.unify;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ReverseNameIndex
{
	private final Map<String, String> reverse = new HashMap<>();

	public void addLookup(String from, String to)
	{
		reverse.put(stripLeadingAndTrailingQuotes(to), stripLeadingAndTrailingQuotes(from));
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
			replaceAll = replaceAll.replaceAll("_"+t.getKey()+"_", t.getValue());
		}
		return replaceAll;
	}

	static String stripLeadingAndTrailingQuotes(String str)
	{
		if (str.startsWith("_"))
		{
			str = str.substring(1, str.length());
		}
		if (str.endsWith("_"))
		{
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}
}
