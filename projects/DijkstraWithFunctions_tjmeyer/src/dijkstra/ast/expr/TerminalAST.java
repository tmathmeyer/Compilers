package dijkstra.ast.expr;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import dijkstra.ast.AST;
import dijkstra.type.AType;
import dijkstra.type.Type;
import dijkstra.unify.ScopedSet;
import dijkstra.unify.Term;
import dijkstra.unify.TypeUnificationTable;

public class TerminalAST extends ExprAST
{
	private final String name;
	private AType t = Type.UNKNOWN;
	
	public TerminalAST(TerminalNodeImpl tree)
	{
		this(tree.getText());
	}
	
	public TerminalAST(String name2, AType a)
	{
		name = name2;
		t = a;
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

	public AType getT()
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
				if (t != Type.UNKNOWN)
				{
					tut.register(this, t);
				}
		}
	}

	@Override
	protected List<AST> getChildren()
	{
		return new LinkedList<>();
	}

	@Override
	public Term replace(Term l, Term r)
	{
		if (l.equals(this))
		{
			return r;
		}
		
		return this;
	}
	
	@Override
	public void buildAssignment(TypeUnificationTable tut)
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
				if (t != Type.UNKNOWN)
				{
					tut.register(this, Type.getCastable(t));
				}
				else
				{
					tut.register(this, Type.CASTABLE);
				}
		}
	}
}
