package dijkstra.symbols;

import static dijkstra.ParseUtils.getTree;

import org.junit.Test;

import dijkstra.Tuple;
import dijkstra.ast.AST;
import dijkstra.ast.ASTBuilder;
import dijkstra.lexparse.DijkstraParser;
import dijkstra.lexparse.DijkstraParser.DijkstraTextContext;

public class SymbolScience {

	@Test
	public void test()
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
						  				   						 +"proc foo (int q, r) { "
						  				   						 +"   c[b-a] <- q-r "
						  				   						 +"} "
						  				   						 +"m,n <- func(0, 0, 0.0)"
						  				   						 +"if "
						  				   						 +"  x>10 :: print product "
						  				   						 +"  x<10 :: print product + 10 "
						  				   						 +"  -x=-10 :: print 0 "
						  				   						 +"fi");
		
		
		AST t = tree.a.accept(new ASTBuilder(tree.b));
		
		
		System.out.println(t);
	}

}
