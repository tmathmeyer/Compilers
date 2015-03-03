package dijkstra.ast;

import java.util.Set;
import java.util.function.Function;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import dijkstra.unify.ReverseNameIndex;
import dijkstra.unify.ScopedSet;
import dijkstra.unify.SymbolGen;
import dijkstra.unify.TypeUnificationTable;

public interface AST
{		
	public static class VarBind
	{
		public final String old;
		public final String New;
		
		public VarBind(String o, String n)
		{
			old = o;
			New = n;
		}
		
		public String toString()
		{
			return old+":"+New;
		}
	}
	
	public static ScopedSet<VarBind> getBindings(ScopedSet<String> set, ReverseNameIndex ... indicies)
	{
		return set.convertScopedSet(new Function<String, VarBind>(){

			@Override
			public VarBind apply(String t)
			{
				String gen = SymbolGen.gensym();
				if (indicies.length > 0)
				{
					indicies[0].addLookup(t, gen);
				}
				return new VarBind(t, gen);
			}
			
		});
	}
	
	default void buildTUT(TypeUnificationTable tut)
	{
		// do nothing
	}
	
	public static AST makeUnique(boolean b, AST t, ReverseNameIndex ... indicies)
	{
		if (!b)
		{
			return t;
		}
		if (indicies.length > 0)
		{
			return t.renameScoping(getBindings(t.getDeclaredVariables(null).finish(), indicies[0]));
		}
		return t.renameScoping(getBindings(t.getDeclaredVariables(null).finish()));
	}
	
	default AST renameVars(Set<VarBind> s)
	{
		return this;
	}
	
	default AST renameScoping(ScopedSet<VarBind> vb)
	{
		return renameVars(vb.getScopeVars(this));
	}
	
	default ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		return new ScopedSet<String>(this);
	}
	
	public void generateCode(ClassWriter writer, MethodVisitor method, TypeUnificationTable tut);
	
}
