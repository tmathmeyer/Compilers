package dijkstra.ast.expr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Stream;

import dijkstra.ast.AST;
import dijkstra.ast.TerminalAST;
import dijkstra.unify.ScopedSet;
import dijkstra.unify.TypeUnificationTable;

public abstract class ExprAST implements AST 
{
	public static AST getExpr(Stream<AST> map)
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
			return new TerminalAST(it.next().toString());
		}
		else if (size == 2)
		{
			AST t = it.next();
			if (t.toString().equals("~"))
			{
				return new NotExpr(it.next());
			}
			else if (t.toString().equals("-"))
			{
				return new NegExpr(it.next());
			}
		}
		else if (size == 3)
		{
			AST first = it.next();
			AST op = it.next();
			AST last = it.next();
			
			if (first.toString().equals("("))
			{
				return  op;
			}
			
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
		List<AST> newChildren = new ArrayList<>();
		for(AST a : getChildren())
		{
			a = a.renameVars(vb.getScopeVars(a));
			a = a.renameVars(vb.getScopeVars(this));
			a = a.renameScoping(vb);
			newChildren.add(a);
		}
		
		return ExprAST.getExpr(newChildren.stream());
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
	
	
	
}
