package dijkstra.ast.expr;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import dijkstra.ast.AST;
import dijkstra.type.Type;
import dijkstra.unify.Term;
import dijkstra.unify.TypeUnificationTable;

public class NotExpr extends ExprAST
{
	private final ExprAST n;
	
	public NotExpr(ExprAST next)
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
		
		tut.register(n, Type.BOOLEAN);
		tut.register(this, Type.BOOLEAN);
	}
	
	@Override
	public ExprAST renameVars(Set<VarBind> s)
	{
		return new NotExpr(n.renameVars(s));
	}
	
	@Override
	public String toString()
	{
		return "!" + n;
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
	public void generateCode(ClassWriter writer, MethodVisitor method, TypeUnificationTable tut)
	{
		throw new RuntimeException("NOT IMPLEMENTED");
	}
}
