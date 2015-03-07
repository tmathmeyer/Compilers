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

public class SubtractionExpr extends ExprAST
{
	private final ExprAST f, l;
	
	public SubtractionExpr(ExprAST first, ExprAST last)
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
		
		tut.register(f, Type.NUMERIC_GENERAL);
		tut.register(l, Type.NUMERIC_GENERAL);
		tut.register(this, Type.NUMERIC_GENERAL);
	}
	
	@Override
	public ExprAST renameVars(Set<VarBind> s)
	{
		return new SubtractionExpr(f.renameVars(s), l.renameVars(s));
	}
	
	@Override
	public String toString()
	{
		return f + "-" + l;
	}
	
	@Override
	public void generateCode(ClassWriter writer, MethodVisitor mv, TypeUnificationTable tut)
	{
		Type me = tut.getTypeByName(this);
		Type ff = tut.getTypeByName(f);
		Type ll = tut.getTypeByName(l);
		
		if (me == Type.UNKNOWN)
		{
			me = ff;
		}
		
		f.generateCode(writer, mv, tut);
		if (me==Type.INT && ff==Type.FLOAT) {
			mv.visitInsn(F2I);
		} else if (me==Type.FLOAT && ff==Type.INT) {
			mv.visitInsn(I2F);
		}
		
		l.generateCode(writer, mv, tut);
		if (me==Type.INT && ll==Type.FLOAT) {
			mv.visitInsn(F2I);
		} else if (me==Type.FLOAT && ll==Type.INT) {
			mv.visitInsn(I2F);
		}
		
		switch(me)
		{
		case INT:
			mv.visitInsn(ISUB);
			break;
		case FLOAT:
			mv.visitInsn(FSUB);
			break;
		default:
			break;
		}
	}
}
