package dijkstra.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import dijkstra.unify.ScopedSet;

public class ExprAST implements AST 
{
	// this is a stack !!
	private final List<AST> children = new ArrayList<>();
	
	public ExprAST(Stream<AST> map)
	{
		map.forEach(a -> children.add(a));
	}

	@Override
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		
		for(AST t : children)
		{
			s.append(t);
		}
		
		return s.toString();
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		for(AST t : children)
		{
			t.getDeclaredVariables(scope);
		}
		
		return scope;
	}
	
	@Override
	public AST renameVars(Set<VarBind> s)
	{
		List<AST> newChildren = new ArrayList<>();
		for(AST a : children)
		{
			newChildren.add(a.renameVars(s));
		}
		
		return new ExprAST(newChildren.stream());
	}
	
	@Override
	public AST renameScoping(ScopedSet<VarBind> vb)
	{
		List<AST> newChildren = new ArrayList<>();
		for(AST a : children)
		{
			a = a.renameVars(vb.getScopeVars(a));
			a = a.renameVars(vb.getScopeVars(this));
			a = a.renameScoping(vb);
			newChildren.add(a);
		}
		
		return new ExprAST(newChildren.stream());
	}
}
