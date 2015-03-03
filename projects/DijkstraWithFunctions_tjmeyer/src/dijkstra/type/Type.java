package dijkstra.type;

import dijkstra.lexparse.DijkstraParser.TypeContext;
import dijkstra.unify.Term;

public enum Type implements AType
{
	INT, FLOAT, NUMERIC_GENERAL,
	C_INT, C_FLOAT, CASTABLE,
	A_INT, A_FLOAT, A_BOOL,
	UNKNOWN, VOID,
	BOOLEAN, LOOKUP;
	
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

	@Override
	public boolean isID()
	{
		return false;
	}

	@Override
	public Term replace(Term l, Term r)
	{
		return this;
	}

	public boolean eq(Type type, Type other)
	{
		if (type == UNKNOWN || type == VOID)
		{
			return true;
		}
		
		if (type == NUMERIC_GENERAL && (other==INT || other==FLOAT || other==C_INT || other==C_FLOAT))
		{
			return true;
		}
		
		if (type == CASTABLE && (other==INT || other==FLOAT || other==C_INT || other==C_FLOAT || other==NUMERIC_GENERAL))
		{
			return true;
		}
		
		if (type==INT && (other==C_FLOAT || other==C_INT))
		{
			return true;
		}
		
		if (type==FLOAT && (other==C_FLOAT || other==C_INT))
		{
			return true;
		}
		
		if (type==C_INT && other==C_FLOAT)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public Term combine(Term other)
	{
		if (this == other)
		{
			return this;
		}
		if (other instanceof Type)
		{
			return consolidate(this, (Type) other);
		}
		if (other instanceof Arrow)
		{
			return combine(((Arrow)other).o);
		}
		throw new RuntimeException("cant consolidate "+this+" and "+other);
	}

	private Term consolidate(Type a, Type b)
	{
		if (a==UNKNOWN) return b;
		if (b==UNKNOWN) return a;
		
		if (a==VOID) return b;
		if (b==VOID) return a;
		
		if (a==CASTABLE) return getCastable(b);
		if (b==CASTABLE) return getCastable(a);
		

		if (a==INT && b==C_INT) return C_INT;
		if (a==C_INT && b==INT) return C_INT;
		
		if (a==FLOAT && b==C_FLOAT) return C_FLOAT;
		if (a==C_FLOAT && b==FLOAT) return C_FLOAT;
		
		if (a==FLOAT && b==C_INT) return FLOAT;
		if (b==FLOAT && a==C_INT) return FLOAT;
		
		if (a==INT && b==C_FLOAT) return INT;
		if (b==INT && a==C_FLOAT) return INT;
		
		if (a==CASTABLE && b==NUMERIC_GENERAL) return NUMERIC_GENERAL;
		if (b==CASTABLE && a==NUMERIC_GENERAL) return NUMERIC_GENERAL;
		
		if (b==INT && a==FLOAT) return FLOAT;
		if (b==FLOAT && a==INT) return FLOAT;
		
		if (a==INT && b==NUMERIC_GENERAL) return INT;
		if (a==FLOAT && b==NUMERIC_GENERAL) return FLOAT;

		if (b==INT && a==NUMERIC_GENERAL) return INT;
		if (b==FLOAT && a==NUMERIC_GENERAL) return FLOAT;
		
		if (b==C_INT && a==NUMERIC_GENERAL) return C_INT;
		if (b==C_FLOAT && a==NUMERIC_GENERAL) return C_FLOAT;
		
		
		
		
		
		
		throw new RuntimeException("cant consolidate "+a+" and "+b);
	}

	public static Term getCastable(AType t)
	{
		if (t instanceof Type)
		{
			Type tt = (Type)t;
			
			switch(tt)
			{
				case INT:
					return C_INT;
				case FLOAT:
					return C_FLOAT;
				default:
					return t;
			}
		}
		return t;
	}
}
