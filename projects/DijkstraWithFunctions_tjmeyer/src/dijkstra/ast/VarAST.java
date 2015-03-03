package dijkstra.ast;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import dijkstra.unify.ScopedSet;
import dijkstra.unify.TypeUnificationTable;

public class VarAST implements AST
{
	private final String name;
	//private String type;
	
	public VarAST(String text)
	{
		name = text;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
	
	@Override
	public ScopedSet<String> getDeclaredVariables(ScopedSet<String> scope)
	{
		scope.insert(name);
		return scope;
	}
	
	@Override
	public void generateCode(ClassWriter writer, MethodVisitor method, TypeUnificationTable tut)
	{
		throw new RuntimeException("NOT IMPLEMENTED");
	}
}
