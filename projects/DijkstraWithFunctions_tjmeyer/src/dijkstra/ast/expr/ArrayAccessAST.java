package dijkstra.ast.expr;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.objectweb.asm.Opcodes.*;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import dijkstra.ast.AST;
import dijkstra.type.Type;
import dijkstra.unify.Constraint;
import dijkstra.unify.ScopedSet;
import dijkstra.unify.TypeUnificationTable;

public class ArrayAccessAST extends ExprAST
{
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arr == null) ? 0 : arr.hashCode());
		result = prime * result
				+ ((numericEqu == null) ? 0 : numericEqu.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArrayAccessAST other = (ArrayAccessAST) obj;
		if (arr == null) {
			if (other.arr != null)
				return false;
		} else if (!arr.equals(other.arr))
			return false;
		if (numericEqu == null) {
			if (other.numericEqu != null)
				return false;
		} else if (!numericEqu.equals(other.numericEqu))
			return false;
		return true;
	}

	private final ExprAST numericEqu;
	private final String arr;
	
	public ArrayAccessAST(String id, AST expr)
	{
		arr = id;
		numericEqu = (ExprAST) expr;
	}
	
	@Override
	public String toString()
	{
		return arr + "[" + numericEqu + "]";
	}

	@Override
	public AST renameScoping(ScopedSet<VarBind> vb)
	{
		AST t = numericEqu.renameVars(vb.getScopeVars(numericEqu));
		t = t.renameVars(vb.getScopeVars(this));
		return new ArrayAccessAST(arr, t);
	}

	@Override
	public ExprAST renameVars(Set<VarBind> s)
	{
		for(VarBind b : s)
		{
			if (b.old.equals(arr))
			{
				return new ArrayAccessAST(b.New, numericEqu.renameVars(s));
			}
		}
		return this;
	}

	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		numericEqu.buildTUT(tut);
		tut.register(numericEqu, Type.INT);
		new TerminalAST(arr, Type.UNKNOWN).buildTUT(tut);
	}

	@Override
	protected List<AST> getChildren()
	{
		return new LinkedList<>();
	}
	
	@Override
	public void generateCode(ClassWriter writer, MethodVisitor mv, TypeUnificationTable tut)
	{
		store(writer, mv, tut);
		switch(tut.getTypeByName(this))
		{
		case INT:
			mv.visitInsn(IALOAD);
			break;
		case FLOAT:
			mv.visitInsn(FALOAD);
			break;
		case BOOLEAN:
			mv.visitInsn(BALOAD);
			break;
		default:
			throw new RuntimeException("cant have an array of: " + tut.getTypeByName(this));
		}
		
	}

	public void store(ClassWriter writer, MethodVisitor mv, TypeUnificationTable tut)
	{
		Constraint c = tut.getConstraintByName(arr);
		TerminalAST t = (TerminalAST) c.left();
		mv.visitVarInsn(ALOAD, t.getAddr());
		
		numericEqu.generateCode(writer, mv, tut);
	}
}
