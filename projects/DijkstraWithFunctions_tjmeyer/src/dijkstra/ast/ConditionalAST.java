package dijkstra.ast;

import static org.objectweb.asm.Opcodes.INVOKESTATIC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import dijkstra.unify.TypeUnificationTable;

public class ConditionalAST implements AST
{
	private final List<GuardedAST> conditionals = new ArrayList<>();
	
	public ConditionalAST(Stream<AST> map)
	{
		Iterator<AST> it = map.iterator();
		while(it.hasNext())
		{
			conditionals.add((GuardedAST) it.next());
		}
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("if\n");
		for(AST t : conditionals)
		{
			sb.append("   ").append(t).append("\n");
		}
		sb.append("fi");
		return sb.toString();
	}

	@Override
	public AST renameVars(Set<VarBind> scope)
	{
		return new ConditionalAST(conditionals.stream().map(a -> a.renameVars(scope)));
	}
	
	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		conditionals.stream().forEach(a -> a.buildTUT(tut));
	}
	
	@Override
	public void generateCode(ClassWriter writer, MethodVisitor mv, TypeUnificationTable tut)
	{
		Label done = new Label();
		for(GuardedAST t : conditionals)
		{
			t.generateCode(writer, mv, tut, done);
		}
		mv.visitMethodInsn(INVOKESTATIC, "dijkstra/runtime/DijkstraRuntime", "condFail", "()V", false);
		
		mv.visitLabel(done);
	}
}
