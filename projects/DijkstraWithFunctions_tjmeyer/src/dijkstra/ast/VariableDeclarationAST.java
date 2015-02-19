package dijkstra.ast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.tree.TerminalNode;

import dijkstra.lexparse.DijkstraParser.TypeContext;
import dijkstra.unify.ScopedSet;
import dijkstra.unify.Type;
import dijkstra.unify.TypeUnificationTable;

public class VariableDeclarationAST implements AST
{
	private final Type type;
	private final List<TerminalAST> decs = new ArrayList<>();
	
	public VariableDeclarationAST(TypeContext t, List<TerminalNode> iDsFromList)
	{
		type = Type.fromString(t.getText());
		for(TerminalNode tt : iDsFromList)
		{
			decs.add(new TerminalAST(tt.getText(), type));
		}
	}
	
	public VariableDeclarationAST(Type t, List<String> newdecs)
	{
		type = t;
		for(String tt : newdecs)
		{
			decs.add(new TerminalAST(tt, t));
		}
	}

	@Override
	public String toString()
	{
		List<String> strings = new LinkedList<>();
		
		decs.stream().forEach(a -> strings.add(a.toString()));
		
		return type + " " + String.join(",", strings);
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		for(TerminalAST p : decs)
		{
			scope.insert(p.toString());
		}
		
		return scope;
	}

	@Override
	public AST renameVars(Set<VarBind> s)
	{
		List<String> newdecs = new ArrayList<>();
		for(TerminalAST a : decs)
		{
			boolean flagged = true;
			for(VarBind vb : s)
			{
				if (a.toString().equals(vb.old))
				{
					newdecs.add(vb.New);
					flagged = false;
				}
			}
			if (flagged) {
				newdecs.add(a.toString());
			}
		}
		
		return new VariableDeclarationAST(type, newdecs);
	}
	
	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		decs.stream().forEach(t -> t.buildTUT(tut));
	}
}
