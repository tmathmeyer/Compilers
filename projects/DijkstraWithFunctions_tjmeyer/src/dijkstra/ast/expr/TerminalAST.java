package dijkstra.ast.expr;

import static org.objectweb.asm.Opcodes.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import dijkstra.ast.AST;
import dijkstra.gen.JVMInfo;
import dijkstra.type.AType;
import dijkstra.type.Type;
import dijkstra.unify.ScopedSet;
import dijkstra.unify.Term;
import dijkstra.unify.TypeUnificationTable;

public class TerminalAST extends ExprAST implements AType
{
	private final String name;
	private AType t = Type.UNKNOWN;
	private int constant;
	
	public TerminalAST(TerminalNodeImpl tree)
	{
		this(tree.getText());
	}
	
	public TerminalAST(String name2, AType a)
	{
		name = name2;
		t = a;
	}
	
	public TerminalAST(String tree)
	{
		name = tree;
		constant = 0;
		
		try
		{
			Integer.parseInt(name);
			t = Type.INT;
			constant = 1;
		} catch(Exception e) {
			try
			{
				Float.parseFloat(name);
				t = Type.FLOAT;
				constant = 2;
			} catch(Exception ee) {
				
			}
		}
		
		
		if (name.equals("true") || name.equals("false"))
		{
			t = Type.BOOLEAN;
			constant = 3;
		}
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((t == null) ? 0 : t.hashCode());
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
		TerminalAST other = (TerminalAST) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public TerminalAST(String name, Type t)
	{
		this.name = name;
		this.t = t;
	}

	@Override
	public String toString()
	{
		return name;
	}

	public AType getT()
	{
		return t;
	}

	public void setT(Type t)
	{
		this.t = t;
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		scope.insert(name);
		return scope;
	}
	
	@Override
	public TerminalAST renameVars(Set<VarBind> s)
	{
		for(VarBind vb : s)
		{
			if (name.equals(vb.old))
			{
				return new TerminalAST(vb.New, t);
			}
		}
		return this;
	}
	
	@Override
	public void buildTUT(TypeUnificationTable tut)
	{
		switch(name)
		{
			case "-": case "~":
			case ">": case "<":
			case "*": case "/":
			case "&": case "|":
			case "div": case "mod":
			case "=": case "+":
				break;
			default:
				if (t != Type.UNKNOWN)
				{
					tut.register(this, t);
				}
		}
	}

	@Override
	protected List<AST> getChildren()
	{
		return new LinkedList<>();
	}

	@Override
	public Term replace(Term l, Term r)
	{
		if (l.equals(this))
		{
			return r;
		}
		
		return this;
	}
	
	@Override
	public void buildAssignment(TypeUnificationTable tut)
	{
		switch(name)
		{
			case "-": case "~":
			case ">": case "<":
			case "*": case "/":
			case "&": case "|":
			case "div": case "mod":
			case "=": case "+":
				break;
			default:
				if (t != Type.UNKNOWN)
				{
					tut.register(this, Type.getCastable(t));
				}
				else
				{
					tut.register(this, Type.UNKNOWN);
				}
		}
	}
	
	@Override
	public void generateCode(ClassWriter writer, MethodVisitor mv, TypeUnificationTable tut)
	{
		if (constant == 1)
		{
			mv.visitLdcInsn(Integer.parseInt(name));
			return;
		}
		if (constant == 2)
		{
			mv.visitLdcInsn(new Float(name));
			return;
		}
		if (constant == 3)
		{
			if (name.equals("true"))
			{
				mv.visitInsn(ICONST_1);
			}
			
			if (name.equals("false"))
			{
				mv.visitInsn(ICONST_0);
			}
			
			return;
		}
		
		switch(tut.getTypeByName(this))
		{
			case INT: case BOOLEAN:
				mv.visitVarInsn(ILOAD, getAddr());
				break;
			case FLOAT:
				mv.visitVarInsn(FLOAD, getAddr());
				break;
			case A_INT: case A_FLOAT: case A_BOOL:
				mv.visitVarInsn(ASTORE, getAddr());
				break;
			default:
				throw new RuntimeException("Cant Load that type " + t);
		}
	}
	
	private int addr = Integer.MIN_VALUE;
	public int getAddr()
	{
		if (addr == Integer.MIN_VALUE)
		{
			addr = JVMInfo.addressOf(name);
		}
		return addr;
	}
}
