package dijkstra.ast;

import java.util.Set;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;
import dijkstra.ast.expr.ExprAST;
import dijkstra.unify.ScopedSet;
import dijkstra.unify.TypeUnificationTable;

public class ReturnAST implements AST
{
	private final ExprAST parts;

	public ExprAST getParts()
	{
		return parts;
	}
	
	public ReturnAST(AST accept)
	{
		parts = (ExprAST) accept;
	}

	public String toString()
	{
		return "return "+parts.toString();
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{	
		return scope;
	}
	
	@Override
	public AST renameVars(Set<VarBind> scope)
	{
		return new ReturnAST(parts.renameVars(scope));
	}
	
	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		parts.buildTUT(tut);
	}
	
	@Override
	public void generateCode(ClassWriter writer, MethodVisitor mv, TypeUnificationTable tut)
	{
		parts.generateCode(writer, mv, tut);
		mv.visitInsn(IRETURN);
	}
}
