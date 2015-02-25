package dijkstra.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import dijkstra.unify.ScopedSet;
import dijkstra.unify.TypeUnificationTable;

public class ProgramAST implements AST
{
	private final List<AST> children = new ArrayList<>(); // bottom up storage
	
	public ProgramAST(Stream<AST> c)
	{	
		this(c.iterator());
	}
	
	public ProgramAST(Iterator<AST> c)
	{	
//		if (c.hasNext())
//		{
//			children.add(c.next());
//			children.add(new ProgramAST(c));
//		}

		while(c.hasNext())
		{
			children.add(c.next());
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
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		scope = new ScopedSet<String>(this);
		
		for(AST t : children)
		{
			t.getDeclaredVariables(scope);
		}
		
		return scope;
	}
	
	@Override
	public AST renameScoping(ScopedSet<VarBind> vb)
	{
		List<AST> newChildren = new ArrayList<>();
		for(AST a : children)
		{
			a = a.renameScoping(vb);
			a = a.renameVars(vb.getScopeVars(a));
			a = a.renameVars(vb.getScopeVars(this));
			newChildren.add(a);
		}
		
		return new ProgramAST(newChildren.stream());
	}
	
	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		children.stream().forEach(a -> a.buildTUT(tut));
	}
}