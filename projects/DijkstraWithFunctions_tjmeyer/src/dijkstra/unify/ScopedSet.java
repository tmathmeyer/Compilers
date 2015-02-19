package dijkstra.unify;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;

import dijkstra.ast.AST;

public class ScopedSet<T>
{
	private final Map<AST, Set<T>> scope = new HashMap<>();
	private final Set<T> current = new HashSet<>();
	private boolean finalized = false;
	private final AST ast;
	
	public ScopedSet(AST t)
	{
		ast = t;
	}
	
	public void merge(ScopedSet<T> set)
	{
		if (finalized)
		{
			throw new RuntimeException("scoped set locked");
		}
		
		for(Entry<AST, Set<T>> s : set.scope.entrySet())
		{
			scope.put(s.getKey(), s.getValue());
		}
	}
	
	public void insert(T t)
	{
		if (finalized)
		{
			throw new RuntimeException("scoped set locked");
		}
		
		current.add(t);
	}
	
	public ScopedSet<T> finish()
	{
		if (finalized)
		{
			throw new RuntimeException("scoped set locked");
		}
		
		finalized = true;
		scope.put(ast, current);
		
		return this;
	}
	
	public Set<T> getScopeVars(AST t)
	{
		Set<T> g = scope.get(t);
		if (g == null)
		{
			return new HashSet<>();
		}
		return g;
	}
	
	public void print()
	{
		if (!finalized)
		{
			System.out.println("unfinished");
			return;
		}
		
		for(Entry<AST, Set<T>> s : scope.entrySet())
		{
			System.out.println(s.getKey().toString().replaceAll("\n", " ").replaceAll("[\\ ]+", " "));
			for(T t : s.getValue())
			{
				System.out.println(t);
			}

			System.out.println("");
		}
	}
	
	public <X> ScopedSet<X> convertScopedSet(Function<T, X> fun)
	{
		ScopedSet<X> result = new ScopedSet<>(null);
		
		for(Entry<AST, Set<T>> s : scope.entrySet())
		{
			Set<X> ns = new HashSet<X>();
			for(T t : s.getValue())
			{
				ns.add(fun.apply(t));
			}
			result.scope.put(s.getKey(), ns);
		}
		
		result.finalized = finalized;
		
		return result;
	}
}
