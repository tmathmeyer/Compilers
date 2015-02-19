package dijkstra.ast;

import java.util.Set;

import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import dijkstra.unify.ScopedSet;
import dijkstra.unify.Type;
import dijkstra.unify.TypeUnificationTable;

public class TerminalAST implements AST
{
	private final String name;
	private Type t = Type.UNKNOWN;
	
	public TerminalAST(TerminalNodeImpl tree)
	{
		name = tree.getText();
	}
	
	public TerminalAST(String tree)
	{
		name = tree;
	}
	
	public TerminalAST(String name, Type t)
	{
		this.name = name;
		this.t = t;
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
		scope.insert(name);
		return scope;
	}
	
	@Override
	public TerminalAST renameVars(Set<VarBind> s)
	{
		for(VarBind vb : s)
		{
			if (name.equals(vb.old))
			{
				return new TerminalAST(vb.New);
			}
		}
		return this;
	}
	
	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		tut.register(this, t);
	}
}
