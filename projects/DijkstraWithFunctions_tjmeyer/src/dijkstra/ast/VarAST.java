package dijkstra.ast;

public class VarAST implements AST
{
	private final String name;
	private String type;
	
	public VarAST(String text)
	{
		name = text;
	}
	
	@Override
	public String toString()
	{
		return name;
	}

}
