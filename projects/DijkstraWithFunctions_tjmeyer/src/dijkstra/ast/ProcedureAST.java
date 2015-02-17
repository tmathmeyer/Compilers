package dijkstra.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import dijkstra.ast.FunctionAST.Param;
import dijkstra.ds.ScopedSet;

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

}
