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
		this(tree.getText());
	}
	
	public TerminalAST(String tree)
	{
		name = tree;
		
		try
		{
			Integer.parseInt(name);
			t = Type.INT;
		} catch(Exception e) {
			try
			{
				Float.parseFloat(name);
				t = Type.FLOAT;
			} catch(Exception ee) {
				
			}
		}
		
		if (name.equals("true") || name.equals("false"))
		{
			t = Type.BOOLEAN;
		}
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((t == null) ? 0 : t.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TerminalAST other = (TerminalAST) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
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
				return new TerminalAST(vb.New, t);
			}
		}
		return this;
	}
	
	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		switch(name)
		{
			case "-": case "~":
			case ">": case "<":
			case "*": case "/":
			case "&": case "|":
			case "div": case "mod":
			case "=": case "+":
				break;
			default:
				tut.register(this, t);
		}
	}
}
