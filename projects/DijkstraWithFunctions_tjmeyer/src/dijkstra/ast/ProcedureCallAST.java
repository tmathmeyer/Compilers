package dijkstra.ast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Stream;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import dijkstra.unify.TypeUnificationTable;

public class ProcedureCallAST implements AST
{
	private final String fname;
	private final ArrayList<AST> args = new ArrayList<>();
	
	public ProcedureCallAST(String id, Stream<AST> map)
	{
		fname = id;
		map.forEach(a -> args.add(a));
	}

	public String toString()
	{
		LinkedList<String> argsS = new LinkedList<>();
		args.stream().forEach(e -> argsS.add(e.toString()));
		return fname + "(" + String.join(",", argsS) + ")";
	}
	
	@Override
	public AST renameVars(Set<VarBind> scope)
	{
		String name = fname;
		for(VarBind b : scope)
		{
			if (b.old.equals(name))
			{
				name = b.New;
			}
		}
		
		return new ProcedureCallAST(name, args.stream().map(a -> {return a.renameVars(scope); }));
	}
	
	@Override
	public void generateCode(ClassWriter writer, MethodVisitor method, TypeUnificationTable tut)
	{
		throw new RuntimeException("NOT IMPLEMENTED");
	}
}
