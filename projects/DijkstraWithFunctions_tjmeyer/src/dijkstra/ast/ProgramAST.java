package dijkstra.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


public class ProgramAST implements AST
{
	private final List<AST> children = new ArrayList<>(); // bottom up storage
	
	public ProgramAST(Stream<AST> c)
	{	
		Iterator<AST> it = c.iterator();
		while(it.hasNext())
		{
			children.add(it.next());
		}
	}

	@Override
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		for(AST t : children)
		{
			s.append(t).append("\n");
		}
		
		return s.toString();
	}
}