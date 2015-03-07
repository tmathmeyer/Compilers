package dijkstra.ast;

import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.ISTORE;

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
	public void generateCode(ClassWriter writer, MethodVisitor mv, TypeUnificationTable tut)
	{
		for(TerminalAST tast : input)
		{
			mv.visitLdcInsn(tast.toString());
			switch(tut.getTypeByName(tast))
			{
			case BOOLEAN:
				mv.visitMethodInsn(INVOKESTATIC, "dijkstra/runtime/DijkstraRuntime", "inputBoolean", 
						"(Ljava/lang/String;)Z", false);
				break;
			case FLOAT:
				mv.visitMethodInsn(INVOKESTATIC, "dijkstra/runtime/DijkstraRuntime", "inputFloat", 
						"(Ljava/lang/String;)F", false);
			case INT:
				mv.visitMethodInsn(INVOKESTATIC, "dijkstra/runtime/DijkstraRuntime", "inputInt", 
						"(Ljava/lang/String;)I", false);
				break;
			default:
				throw new RuntimeException("Can't print this type");
			}
			mv.visitVarInsn(ISTORE, tast.getAddr());
		}
	}
}
