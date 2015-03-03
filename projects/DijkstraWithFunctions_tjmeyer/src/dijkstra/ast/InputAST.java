package dijkstra.ast;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import dijkstra.ast.expr.TerminalAST;
import dijkstra.type.Type;
import dijkstra.unify.ScopedSet;
import dijkstra.unify.TypeUnificationTable;

public class InputAST implements AST
{
	private final List<TerminalAST> input = new LinkedList<>();
	
	public InputAST(List<TerminalNode> stream)
	{
		this(stream.stream().map(a -> new TerminalAST(a.getText(), Type.UNKNOWN)));
	}
	
	public InputAST(Stream<TerminalAST> stream)
	{
		Iterator<TerminalAST> it = stream.iterator();
		while(it.hasNext())
		{
			input.add(it.next());
		}
	}

	public String getSymbolString()
	{
		return input.toString();
	}

	@Override
	public String toString()
	{
		return "input " + input;
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		ScopedSet<String> s = scope;
		for(TerminalAST tast : input)
		{
			s = tast.getDeclaredVariables(s);
		}
		return s;
				
	}
	
	@Override
	public AST renameVars(Set<VarBind> s)
	{
		return new InputAST(input.stream().map(a -> a.renameVars(s)));
	}
	
	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		input.stream().forEach(a -> a.buildTUT(tut));
	}
	
	@Override
	public void generateCode(ClassWriter writer, MethodVisitor method, TypeUnificationTable tut)
	{
		//throw new RuntimeException("NOT IMPLEMENTED");
	}
}
