package dijkstra.type;

import dijkstra.unify.Term;

public class MethodSignitureGenerator
{
	private final Arrow a;
	public MethodSignitureGenerator(Term term)
	{
		if (term instanceof Arrow)
		{
			a = (Arrow) term;
		}
		else
		{
			throw new RuntimeException("can't make a method signiture out of: "+term);
		}
	}

	
	public String toString()
	{
		return "(" + jvmName(a.i, false) + ")" + jvmName(a.o, true);
	}
	
	private String semiArrow(Arrow a)
	{
		return jvmName(a.i, false)+","+jvmName(a.o, false);
	}
	
	private String jvmName(Term t, boolean isReturn)
	{
		if (t instanceof Type)
		{
			Type ty = (Type) t;
			switch(ty)
			{
			case BOOLEAN:
				return "B";
			case FLOAT:
				return "F";
			case INT: case NUMERIC_GENERAL:
				return "I";
			case VOID:
				return isReturn?"V":"";
			default:
				throw new RuntimeException("can't have a function of this type: " + ty);
			}
		}
		return semiArrow((Arrow) t);
	}
}
