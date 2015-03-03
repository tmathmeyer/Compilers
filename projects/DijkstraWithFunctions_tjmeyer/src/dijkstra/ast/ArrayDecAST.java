package dijkstra.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import dijkstra.ast.expr.ExprAST;
import dijkstra.ast.expr.TerminalAST;
import dijkstra.lexparse.DijkstraParser.TypeContext;
import dijkstra.type.Type;
import dijkstra.unify.ScopedSet;
import dijkstra.unify.TypeUnificationTable;

public class ArrayDecAST implements AST
{
	private final Type type; // a type
	private final ExprAST arraySize; // an expression that evaluates to a number
	private final List<TerminalAST> ids = new LinkedList<>(); // a series of names
	
	public ArrayDecAST(TypeContext type, AST expr, List<TerminalNode> iDsFromList)
	{
		this.type = Type.getArrayOf(Type.fromString(type.getText()));
		arraySize = (ExprAST) expr;
		Iterator<String> it = iDsFromList.stream().map(e -> e.getText()).iterator();
		while(it.hasNext())
		{
			ids.add(new TerminalAST(it.next(), this.type));
		}
	}

	private ArrayDecAST(Type at, ExprAST t, List<String> newdecs)
	{
		type = at;
		arraySize = t;
		for(String s : newdecs)
		{
			ids.add(new TerminalAST(s, type));
		}
	}

	public String toString()
	{
		List<String> strings = new LinkedList<>();
		
		ids.stream().forEach(a -> strings.add(a.toString()));
		
		return type + "[" + arraySize + "] " + String.join(",", strings);
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		for(TerminalAST p : ids)
		{
			scope.insert(p.toString());
		}
		
		return scope;
	}
	
	@Override
	public AST renameVars(Set<VarBind> s)
	{
		List<String> newdecs = new ArrayList<>();
		for(TerminalAST a : ids)
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
		
		ExprAST t = arraySize.renameVars(s);
		
		return new ArrayDecAST(type, t, newdecs);
	}
	
	@Override
	public AST renameScoping(ScopedSet<VarBind> vb)
	{
		return renameVars(vb.getScopeVars(arraySize)).renameVars(vb.getScopeVars(this));
	}
	
	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		tut.register(arraySize, Type.INT);
		arraySize.buildTUT(tut);
		ids.stream().forEach(a -> a.buildTUT(tut));
	}

	@Override
	public void generateCode(ClassWriter writer, MethodVisitor method, TypeUnificationTable tut)
	{
		throw new RuntimeException("NOT IMPLEMENTED");
	}
}
