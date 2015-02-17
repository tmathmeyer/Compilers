package dijkstra.ast;

import java.util.function.Function;

import dijkstra.ds.ScopedSet;
import dijkstra.unify.SymbolGen;

public interface AST
{
	//public AST makeUnique(Stack<VarBind> bindings);
	
	
	
	
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
	
	public static ScopedSet<VarBind> getBindings(ScopedSet<String> set)
	{
		return set.convertScopedSet(new Function<String, VarBind>(){

			@Override
			public VarBind apply(String t)
			{
				return new VarBind(t, SymbolGen.gensym());
			}
			
		});
	}
	
	
	
	
	default AST assignTypes()
	{
		return this;
	}
	
	default ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		return new ScopedSet<String>(this);
	}
}
