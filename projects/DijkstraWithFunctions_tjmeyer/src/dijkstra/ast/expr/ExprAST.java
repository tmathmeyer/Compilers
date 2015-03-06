package dijkstra.ast.expr;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Stream;

import dijkstra.ast.AST;
import dijkstra.unify.ScopedSet;
import dijkstra.unify.Term;
import dijkstra.unify.TypeUnificationTable;

public abstract class ExprAST implements AST, Term
{
	public static ExprAST getExpr(Stream<AST> map)
	{
		long size = 0;
		Iterator<AST> it = map.iterator();
		Stack<AST> tt = new Stack<AST>();
		while(it.hasNext())
		{
			tt.push(it.next());
			size++;
		}
		it = tt.iterator();
		
		if (size == 1)
		{
			AST ttt = it.next();
			if (ttt instanceof FunctionCallExpr)
			{
				return (ExprAST) ttt;
			}
			if (ttt instanceof ArrayAccessAST)
			{
				return (ExprAST) ttt;
			}
			return new TerminalAST(ttt.toString());
		}
		else if (size == 2)
		{
			AST t = it.next();
			if (t.toString().equals("~"))
			{
				return new NotExpr((ExprAST) it.next());
			}
			else if (t.toString().equals("-"))
			{
				return new NegExpr((ExprAST) it.next());
			}
		}
		else if (size == 3)
		{
			AST f = it.next();
			AST op = it.next();
			AST l = it.next();
			
			if (f.toString().equals("("))
			{
				return (ExprAST) op;
			}
			
			ExprAST first = (ExprAST)f;
			ExprAST last = (ExprAST)l;
			switch(op.toString())
			{
			case "*":
				return new MultiplicationExpr(first, last);
			case "/":
				return new DivisionExpr(first, last);
			case "mod":
				return new ModuloExpr(first, last);
			case "div":
				return new IDivisoinExpr(first, last);
			case "+":
				return new AdditionExpr(first, last);
			case "-":
				return new SubtractionExpr(first, last);
			case ">":
				return new GreaterThanExpr(first, last);
			case "<":
				return new LessThanExpr(first, last);
			case "<=":
				return new LTEQExpr(first, last);
			case ">=":
				return new GTEQExpr(first, last);
			case "=":
				return new EqExpr(first, last);
			case "~=":
				return new NeqExpr(first, last);
			case "&":
				return new AndExpr(first, last);
			case "|":
				return new OrExpr(first, last);
			}
		}
		throw new RuntimeException("invalid Expr: "+ tt.toString());
	}
	
	@Override
	public abstract void buildTUT(TypeUnificationTable tut);
	
	@Override
	public abstract ExprAST renameVars(Set<VarBind> s);
	
	
	
	
	
	protected abstract List<AST> getChildren();
	
	@Override
	public AST renameScoping(ScopedSet<VarBind> vb)
	{
		return this;
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		for(AST t : getChildren())
		{
			t.getDeclaredVariables(scope);
		}
		
		return scope;
	}
	
	@Override
	public boolean isID()
	{
		return true;
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
	public Term combine(Term other)
	{
		if (other.equals(this))
		{
			return this;
		}
		
		throw new RuntimeException("cant consolidate "+this+" and "+other);
	}
	
	public void buildAssignment(TypeUnificationTable tut)
	{
		buildTUT(tut);
	}
	
	public int getAddr()
	{
		return Integer.MIN_VALUE;
	}
}
