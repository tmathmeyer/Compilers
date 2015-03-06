package dijkstra.ast.expr;

import static org.objectweb.asm.Opcodes.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import dijkstra.ast.AST;
import dijkstra.type.Type;
import dijkstra.unify.TypeUnificationTable;

public class ModuloExpr extends ExprAST
{
	private final ExprAST f, l;
	
	public ModuloExpr(ExprAST first, ExprAST last)
	{
		f = first;
		l = last;
	}
	
	@Override
	protected List<AST> getChildren() {
		List<AST> t = new LinkedList<>();
		t.add(f);
		t.add(l);
		return t;
	}
	
	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		f.buildTUT(tut);
		l.buildTUT(tut);
		
		tut.register(f, Type.INT);
		tut.register(l, Type.INT);
		tut.register(this, Type.INT);
	}
	
	@Override
	public ExprAST renameVars(Set<VarBind> s)
	{
		return new ModuloExpr(f.renameVars(s), l.renameVars(s));
	}
	
	@Override
	public String toString()
	{
		return f + "%" + l;
	}
	
	@Override
	public void generateCode(ClassWriter writer, MethodVisitor mv, TypeUnificationTable tut)
	{
		Type ff = tut.getTypeByName(f);
		Type ll = tut.getTypeByName(l);
		
		f.generateCode(writer, mv, tut);
		if (ff==Type.FLOAT) {
			mv.visitInsn(F2I);
		}
		
		l.generateCode(writer, mv, tut);
		if (ll==Type.FLOAT) {
			mv.visitInsn(F2I);
		}

		mv.visitInsn(IREM);
	}
}
