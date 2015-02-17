package dijkstra.ast;

import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import dijkstra.ds.ScopedSet;

public class TerminalAST implements AST
{
	private final int type;
	private final String name;
	private Type t = Type.UNKNOWN;
	
	public TerminalAST(TerminalNodeImpl tree)
	{
		name = tree.getText();
		type = tree.symbol.getType();
	}
	
	public TerminalAST(String tree)
	{
		name = tree;
		type = 42;
	}
	
	public TerminalAST(String name, Type t)
	{
		this.name = name;
		this.t = t;
		type = 42;
	}

	@Override
	public String toString()
	{
		return name;
	}

	public Type getT()
	{
		return t;
	}

	public void setT(Type t)
	{
		this.t = t;
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		if (type > 30)
		{
			scope.insert(name);
		}
		return scope;
	}
}
