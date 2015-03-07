package dijkstra.ast.expr;

import static org.objectweb.asm.Opcodes.FCMPL;
import static org.objectweb.asm.Opcodes.GOTO;
import static org.objectweb.asm.Opcodes.I2F;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.ICONST_1;
import static org.objectweb.asm.Opcodes.IF_ICMPNE;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import dijkstra.ast.AST;
import dijkstra.type.Type;
import dijkstra.unify.TypeUnificationTable;

public class NeqExpr extends ExprAST
{
	private final ExprAST f, l;
	
	public NeqExpr(ExprAST first, ExprAST last)
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
		
		tut.register(f, l);
		tut.register(this, Type.BOOLEAN);
	}
	
	@Override
	public ExprAST renameVars(Set<VarBind> s)
	{
		return new NeqExpr(f.renameVars(s), l.renameVars(s));
	}
	
	@Override
	public String toString()
	{
		return f + "~=" + l;
	}
	
	@Override
	public void generateCode(ClassWriter writer, MethodVisitor mv, TypeUnificationTable tut)
	{
		Type ff = tut.getTypeByName(f);
		Type ll = tut.getTypeByName(l);
		
		
		if (ff == ll)
		{
			f.generateCode(writer, mv, tut);
			l.generateCode(writer, mv, tut);
			if (ff == Type.FLOAT)
			{
				mv.visitInsn(FCMPL); // pushes into to stack... 0 if same
				mv.visitInsn(ICONST_0); // pushes 0 onto stack
			}
		}
		else if (ff == Type.FLOAT)
		{
			f.generateCode(writer, mv, tut);
			l.generateCode(writer, mv, tut);
			mv.visitInsn(I2F);
			mv.visitInsn(FCMPL);
			mv.visitInsn(ICONST_0);
		}
		else if (ll == Type.FLOAT)
		{
			f.generateCode(writer, mv, tut);
			mv.visitInsn(I2F);
			l.generateCode(writer, mv, tut);
			mv.visitInsn(FCMPL);
			mv.visitInsn(ICONST_0);
		}
		
		
		
		Label lab1 =  new Label();
		mv.visitJumpInsn(IF_ICMPNE, lab1);
		mv.visitInsn(ICONST_0);		// left = right
		Label lab2 = new Label();
		mv.visitJumpInsn(GOTO, lab2);
		mv.visitLabel(lab1);
		mv.visitInsn(ICONST_1);		// left ~= right
		mv.visitLabel(lab2);
	}
}
