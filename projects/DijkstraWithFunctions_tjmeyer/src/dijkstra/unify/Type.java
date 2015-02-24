package dijkstra.unify;

import dijkstra.lexparse.DijkstraParser.TypeContext;

public enum Type
{
	INT, FLOAT, NUMERIC_GENERAL,
	A_INT, A_FLOAT, A_BOOL,
	FUNCTION, UNKNOWN,
	BOOLEAN;
	
	public static Type fromString(String s)
	{
		switch(s.toLowerCase())
		{
			case "int":
				return INT;
			case "float":
				return FLOAT;
			case "boolean":
				return BOOLEAN;
			default:
				throw new RuntimeException("bad type!");
		}
	}
	
	public static Type getArrayOf(Type t)
	{
		switch(t)
		{
			case INT:
				return A_INT;
			case FLOAT:
				return A_FLOAT;
			case BOOLEAN:
				return A_BOOL;
			default:
				throw new RuntimeException("bad type!");
		}
	}

	public static Type fromTC(TypeContext type)
	{
		if (type == null)
		{
			return UNKNOWN;
		}
		return fromString(type.getText());
	}
}
