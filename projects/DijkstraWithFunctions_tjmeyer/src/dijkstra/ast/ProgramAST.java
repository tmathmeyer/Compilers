package dijkstra.ast;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.V1_8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import dijkstra.unify.ScopedSet;
import dijkstra.unify.TypeUnificationTable;

public class ProgramAST implements AST
{
	private final List<AST> children = new ArrayList<>(); // bottom up storage
	private final String programName;
	
	public ProgramAST(String s, Stream<AST> c)
	{	
		this(s, c.iterator());
	}
	
	public ProgramAST(String s, Iterator<AST> c)
	{
		programName = s;
		while(c.hasNext())
		{
			children.add(c.next());
		}
	}

	@Override
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		for(AST t : children)
		{
			s.append(t).append("\n");
		}
		
		return s.toString();
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		scope = new ScopedSet<String>(this);
		
		for(AST t : children)
		{
			t.getDeclaredVariables(scope);
		}
		
		return scope;
	}
	
	@Override
	public AST renameScoping(ScopedSet<VarBind> vb)
	{
		List<AST> newChildren = new ArrayList<>();
		for(AST a : children)
		{
			a = a.renameScoping(vb);
			a = a.renameVars(vb.getScopeVars(a));
			a = a.renameVars(vb.getScopeVars(this));
			newChildren.add(a);
		}
		
		return new ProgramAST(programName, newChildren.stream());
	}
	
	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		children.stream().forEach(a -> a.buildTUT(tut));
	}
	
	@Override
	public void generateCode(ClassWriter cw, MethodVisitor method, TypeUnificationTable tut)
	{
		cw.visit(V1_8, ACC_PUBLIC + ACC_STATIC, "djkcode/" + programName, null, 
				"java/lang/Object", null);
		MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
		mv.visitCode();
		mv.visitVarInsn(ALOAD, 0);
		mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
		mv.visitInsn(RETURN);
		mv.visitMaxs(0, 0);
		mv.visitEnd();
		// Start the main() method
		final MethodVisitor mv2 = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
		mv2.visitCode();
		
		
		children.stream().forEach(a -> a.generateCode(cw, mv2, tut));
		
		// program end
		//  End of main
		mv2.visitInsn(RETURN);
		mv2.visitMaxs(0, 0);
		mv2.visitEnd();
		// Actual end of generation
		cw.visitEnd();
	}
}