package dijkstra.ast.expr;

import static org.objectweb.asm.Opcodes.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import dijkstra.ast.AST;
import dijkstra.type.Type;
import dijkstra.unify.Term;
import dijkstra.unify.TypeUnificationTable;

public class NegExpr extends ExprAST
{
	private final ExprAST n;
	public NegExpr(ExprAST next)
	{
		n = next;
	}
	
	@Override
	protected List<AST> getChildren() {
		List<AST> t = new LinkedList<>();
		t.add(n);
		return t;
	}

	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		n.buildTUT(tut);
		
		tut.register(n, Type.NUMERIC_GENERAL);
		tut.register(this, n);
	}
	
	@Override
	public ExprAST renameVars(Set<VarBind> s)
	{
		return new NegExpr(n.renameVars(s));
	}
	
	@Override
	public String toString()
	{
		return "-" + n;
	}
	
	@Override
	public Term replace(Term l, Term r)
	{
		if (this.equals(l))
		{
			return r;
		}

		return this;
	}
	
	@Override
	public void generateCode(ClassWriter writer, MethodVisitor mv, TypeUnificationTable tut)
	{
		Type me = tut.getTypeByName(this);
		Type nn = tut.getTypeByName(n);
		int V = NOP;
		
		switch(me)
		{
		case INT:
			mv.visitInsn(ICONST_0);
			V = (ISUB);
			break;
		case FLOAT:
			mv.visitInsn(FCONST_0);
			V = (FSUB);
			break;
		default:
			break;
		}
		
		
		n.generateCode(writer, mv, tut);
		if (me==Type.INT && nn==Type.FLOAT) {
			mv.visitInsn(F2I);
		} else if (me==Type.FLOAT && nn==Type.INT) {
			mv.visitInsn(I2F);
		}
		
		mv.visitInsn(V);
	}
}
