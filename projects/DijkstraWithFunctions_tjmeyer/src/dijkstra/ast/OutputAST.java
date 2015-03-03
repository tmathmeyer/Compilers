package dijkstra.ast;

import static org.objectweb.asm.Opcodes.INVOKESTATIC;

import java.util.Set;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import dijkstra.unify.TypeUnificationTable;

public class OutputAST implements AST
{
	private final AST outputAST;
	
	public OutputAST(AST accept)
	{
		outputAST = accept;
	}
	
	public String toString()
	{
		return "print "+outputAST;
	}
	
	@Override
	public AST renameVars(Set<VarBind> s)
	{
		return new OutputAST(outputAST.renameVars(s));
	}
	
	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		outputAST.buildTUT(tut);
	}
	
	@Override
	public void generateCode(ClassWriter writer, MethodVisitor mv, TypeUnificationTable tut)
	{
		outputAST.generateCode(writer, mv, tut);	// TOS = expression value
		
		switch(tut.getTypeByName(outputAST))
		{
		case A_BOOL:
			mv.visitMethodInsn(INVOKESTATIC, "dijkstra/runtime/DijkstraRuntime", "printBoolean", "(Z)V", false);
			break;
		case A_FLOAT:
			mv.visitMethodInsn(INVOKESTATIC, "dijkstra/runtime/DijkstraRuntime", "printFloat", "(F)V", false);
			break;
		case A_INT:
			mv.visitMethodInsn(INVOKESTATIC, "dijkstra/runtime/DijkstraRuntime", "printInt", "(I)V", false);
			break;
		case BOOLEAN:
			mv.visitMethodInsn(INVOKESTATIC, "dijkstra/runtime/DijkstraRuntime", "printBoolean", "(Z)V", false);
			break;
		case CASTABLE:
			mv.visitMethodInsn(INVOKESTATIC, "dijkstra/runtime/DijkstraRuntime", "printInt", "(I)V", false);
			break;
		case C_FLOAT:
			mv.visitMethodInsn(INVOKESTATIC, "dijkstra/runtime/DijkstraRuntime", "printFloat", "(F)V", false);
			break;
		case C_INT:
			mv.visitMethodInsn(INVOKESTATIC, "dijkstra/runtime/DijkstraRuntime", "printInt", "(I)V", false);
			break;
		case FLOAT:
			mv.visitMethodInsn(INVOKESTATIC, "dijkstra/runtime/DijkstraRuntime", "printFloat", "(F)V", false);
			break;
		case INT:
			mv.visitMethodInsn(INVOKESTATIC, "dijkstra/runtime/DijkstraRuntime", "printInt", "(I)V", false);
			break;
		case LOOKUP:
			throw new RuntimeException("Can't print this type");
		case NUMERIC_GENERAL:
			mv.visitMethodInsn(INVOKESTATIC, "dijkstra/runtime/DijkstraRuntime", "printInt", "(I)V", false);
			break;
		case UNKNOWN:
			throw new RuntimeException("Can't print this type");
		case VOID:
			throw new RuntimeException("Can't print this type");
		default:
			throw new RuntimeException("Can't print this type");
		}
	}
}
