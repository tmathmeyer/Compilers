package dijkstra.ast;

import static dijkstra.ParseUtils.getTree;
import static org.junit.Assert.*;

import org.junit.Test;

import dijkstra.Tuple;
import dijkstra.ast.AST;
import dijkstra.ast.ASTBuilder;
import dijkstra.lexparse.DijkstraParser;
import dijkstra.lexparse.DijkstraParser.DijkstraTextContext;

public class SymbolScience {

	@Test
	public void testLiterallyEveryLanguageConstruct()
	{
		Tuple<DijkstraTextContext, DijkstraParser> tree = getTree("input a "
						  				   						 +"input b "
						  				   						 +"int x,y, z "
						  				   						 +"int[a+b] c "
						  				   						 +"c[b],c[a] <- a,b "
						  				   						 +"product <- a*b+a/b; "
						  				   						 +"fun func (int x, y, float q) : int,int { "
						  				   						 +"  return x+y, x*y; "
						  				   						 +"} "
						  				   						 +"fun fn () : int { "
						  				   						 +"  return 1; "
						  				   						 +"} "
						  				   						 +"do "
						  				   						 +"  x=y :: {x <- x+1} "
						  				   						 +"  x<y :: y <- y-1 "
						  				   						 +"od "
						  				   						 +"proc foo (int q, r) { "
						  				   						 +"   c[b-a] <- q-r "
						  				   						 +"} "
						  				   						 +"m,n <- func(0, 0, 0.0)"
						  				   						 +"if "
						  				   						 +"  x>10 :: print product "
						  				   						 +"  x<10 :: print product + 10 "
						  				   						 +"  -x=-10 :: print 0 "
						  				   						 +"fi");
		
		String astToString = "input a\n"
						   + "input b\n"
						   + "int z,y,x\n"
						   + "int[a+b] c\n"
						   + "c[a],c[b] <- b,a\n"
						   + "product <- a*b+a/b\n"
						   + "fun func(int x,y,float q) : int,int{\n"
						   + "  return x+y,x*y\n"
						   + "}\n"
						   + "fun fn() : int{\n"
						   + "  return 1\n"
						   + "}\n"
						   + "do\n"
						   + "   x=y :: {\n"
						   + "  x <- x+1\n"
						   + "}\n"
						   + "   x<y :: y <- y-1\n"
						   + "od\n"
						   + "proc foo(int q,r){\n"
						   + "  c[b-a] <- q-r\n"
						   + "}\n"
						   + "n,m <- func(0,0,0.0)\n"
						   + "if\n"
						   + "   x>10 :: print product\n"
						   + "   x<10 :: print product+10\n"
						   + "   -x=-10 :: print 0\n"
						   + "fi\n";
		
		
		AST t = tree.a.accept(new ASTBuilder(tree.b));
		
		AST.getBindings(t.getDeclaredVariables(null).finish()).print();
		
		//t.getDeclaredVariables(null).finish().print();
		
		System.out.println("\n\n");
		
		System.out.println(t);
		
		assertEquals(t.toString(), astToString);
	}

}
