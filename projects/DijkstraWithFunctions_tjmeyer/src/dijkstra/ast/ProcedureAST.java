package dijkstra.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import dijkstra.ast.FunctionAST.Param;
import dijkstra.unify.ScopedSet;

public class ProcedureAST implements AST
{
	private final String procname;
	private final List<Param> args = new ArrayList<>();
	private final AST body;
	
	public ProcedureAST(String text, Stream<AST> map, AST accept)
	{
		procname = text;
		body = accept;
		
		Iterator<Param> ar = map.map(x -> Param.fromAST(x)).iterator();
		
		while(ar.hasNext())
		{
			args.add(ar.next());
		}
	}
	
	@Override
	public String toString()
	{
		LinkedList<String> argsS = new LinkedList<>();
		args.stream().forEach(a -> argsS.push(a.toString()));
		StringBuilder sb = new StringBuilder("proc " + procname + "(" + String.join(",", argsS) + ")");
		sb.append(body);
		return sb.toString();
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		ScopedSet<String> current = new ScopedSet<>(this);
		scope.insert(procname);
		
		for(Param p : args)
		{
			current.insert(p.name);
		}
		
		body.getDeclaredVariables(current);
		
		scope.merge(current.finish());
		return scope;
	}
	
	@Override
	public AST renameVars(Set<VarBind> scope)
	{
		String name = procname;
		for(VarBind b : scope)
		{
			if (b.old.equals(name))
			{
				name = b.New;
			}
		}
		
		return new ProcedureAST(name,
				args.stream().map(a -> {return a.renameVars(scope); }),
		   		body.renameVars(scope));
	}
	
	@Override
	public AST renameScoping(ScopedSet<VarBind> vb)
	{
		List<AST> newChildren = new ArrayList<>();
		for(Param a : args)
		{
			a = a.renameVars(vb.getScopeVars(a));
			a = a.renameVars(vb.getScopeVars(this));
			a = a.renameScoping(vb);
			newChildren.add(a);
		}
		
		AST bod = body.renameVars(vb.getScopeVars(body));
		bod = bod.renameVars(vb.getScopeVars(this));
		bod = bod.renameScoping(vb);
		
		return new ProcedureAST(procname, newChildren.stream(), bod);
	}

}
