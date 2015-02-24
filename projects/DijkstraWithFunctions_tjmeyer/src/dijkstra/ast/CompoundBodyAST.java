package dijkstra.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import dijkstra.type.Type;
import dijkstra.unify.ScopedSet;
import dijkstra.unify.TypeUnificationTable;

public class CompoundBodyAST implements AST
{
	private final ArrayList<AST> parts = new ArrayList<>();
	
	public CompoundBodyAST(Stream<AST> map)
	{
		map.forEach(a -> parts.add(a));
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder("{\n");
		for(AST t : parts)
		{
			sb.append("  ").append(t.toString()).append("\n");
		}
		return sb.append("}").toString();
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		ScopedSet<String> current = new ScopedSet<>(this);
		
		for(AST t : parts)
		{
			t.getDeclaredVariables(current);
		}
		
		scope.merge(current.finish());
		return scope;
	}
	
	@Override
	public CompoundBodyAST renameVars(Set<VarBind> scope)
	{
		return new CompoundBodyAST(parts.stream().map(a -> a.renameVars(scope)));
	}
	
	@Override
	public CompoundBodyAST renameScoping(ScopedSet<VarBind> vb)
	{
		List<AST> np = new ArrayList<>();
		for(AST a : parts)
		{
			a = a.renameScoping(vb);
			a = a.renameVars(vb.getScopeVars(a));
			a = a.renameVars(vb.getScopeVars(this));
			np.add(a);
		}
		
		return new CompoundBodyAST(np.stream());
	}
	
	public void trySetReturn(TypeUnificationTable tut, Type type)
	{
		for(AST t : parts)
		{
			if (t instanceof ReturnAST)
			{
				tut.register(((ReturnAST)t).getParts(), type);
			}
			
			t.buildTUT(tut);
		}
	}
}
