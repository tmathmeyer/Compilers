package dijkstra.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import dijkstra.ast.FunctionAST.Param;

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
		StringBuilder sb = new StringBuilder("proc " + procname + "(" + String.join(",", argsS) + ")" + " {\n");
		sb.append(body);
		sb.append("}");
		return sb.toString();
	}

}
