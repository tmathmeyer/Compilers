package dijkstra.ast;

import static dijkstra.ParseUtils.getTree;

import org.junit.Test;

import dijkstra.Tuple;
import dijkstra.lexparse.DijkstraParser;
import dijkstra.lexparse.DijkstraParser.DijkstraTextContext;
import dijkstra.unify.ReverseNameIndex;
import dijkstra.unify.TypeUnificationTable;

public class Unification {
	
	@Test
	public void test()
	{
		Tuple<DijkstraTextContext, DijkstraParser> tree = getTree("input b "
																 +"input c "
																 +"print 1 "
																 +"print  (b + c) mod (b - c) ");
		
		ReverseNameIndex rsi = new ReverseNameIndex();
		
		AST t = AST.makeUnique(tree.a.accept(new ASTBuilder(tree.b)), rsi);
		
		TypeUnificationTable tut = new TypeUnificationTable();
		
		t.buildTUT(tut);
		
		tut.unify();
		
		System.out.println(tut.toString(rsi));
		System.out.println("\n\n\n");
		
		tut.unify();
		System.out.println(tut.getFinishedTypes(rsi));
	}

}
