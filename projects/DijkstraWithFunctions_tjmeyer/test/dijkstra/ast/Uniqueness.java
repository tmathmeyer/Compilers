package dijkstra.ast;

import static dijkstra.ParseUtils.getTree;

import org.junit.Test;

import dijkstra.Tuple;
import dijkstra.lexparse.DijkstraParser;
import dijkstra.lexparse.DijkstraParser.DijkstraTextContext;

public class Uniqueness
{
	private static String reps  ="input a "
								+"input b "
								+"input c "
								+"fun abc (a, b, c) : int { "
								+"    return a + b + c "
								+"} "
								+"X <- abc(b, a, c) ";
	
	
	
	@Test
	public void test()
	{
		Tuple<DijkstraTextContext, DijkstraParser> tree = getTree(reps);
		AST t = tree.a.accept(new ASTBuilder(tree.b));
		
		
		t.getDeclaredVariables(null).finish().print();

		System.out.println("\n\n");
		
		System.out.println(t);
	}

}
