package dijkstra.ast;

import static dijkstra.ParseUtils.getTree;

import org.junit.Test;

import dijkstra.Tuple;
import dijkstra.lexparse.DijkstraParser;
import dijkstra.lexparse.DijkstraParser.DijkstraTextContext;
import dijkstra.unify.ReverseNameIndex;
import dijkstra.unify.TypeUnificationTable;
import dijkstra.unify.rlist.RList;

public class Unification {
	
	@Test
	public void test()
	{
		Tuple<DijkstraTextContext, DijkstraParser> tree = getTree("input b "
																 +"input c "
																 +"print 1 "
																 +"print  (b + c) mod (b - c) ");
		
		ReverseNameIndex rsi = new ReverseNameIndex();
		
		AST t = AST.makeUnique(true, tree.a.accept(new ASTBuilder(tree.b)), rsi);
		
		TypeUnificationTable tut = new TypeUnificationTable(rsi);
		
		t.buildTUT(tut);
		
		tut = tut.check(RList.emptyList());
	}
	
	
	@Test
	public void testFail()
	{
		Tuple<DijkstraTextContext, DijkstraParser> tree = getTree("float a "
																 +"int b "
																 +"print a+b "
																 +"print a mod b ");
		
		ReverseNameIndex rsi = new ReverseNameIndex();
		
		AST t = AST.makeUnique(true, tree.a.accept(new ASTBuilder(tree.b)), rsi);
		
		TypeUnificationTable tut = new TypeUnificationTable(rsi);
		
		t.buildTUT(tut);
		
		tut = tut.check(RList.emptyList());
	}
	
	
	@Test
	public void testfunc()
	{
		Tuple<DijkstraTextContext, DijkstraParser> tree = getTree("fun test(a):int { "
																 +"   return 4 mod a; "
																 +"} "
																 +"a <- test(5) + 0.5"
																 +"print a");
		
		ReverseNameIndex rsi = new ReverseNameIndex();
		
		AST t = AST.makeUnique(true, tree.a.accept(new ASTBuilder(tree.b)), rsi);
		
		TypeUnificationTable tut = new TypeUnificationTable(rsi);
		
		t.buildTUT(tut);

		tut = tut.check(RList.emptyList()).getOnlyTerminalValues();
	}
	
	
	
	@Test
	public void testNotFail()
	{
		Tuple<DijkstraTextContext, DijkstraParser> tree = getTree("float a "
																 +"int b "
																 +"b <- a "
																 +"print b+a ");
		
		ReverseNameIndex rsi = new ReverseNameIndex();
		
		AST t = AST.makeUnique(false, tree.a.accept(new ASTBuilder(tree.b)), rsi);
		
		TypeUnificationTable tut = new TypeUnificationTable(rsi);
		
		t.buildTUT(tut);
		
		System.out.println(tut);
		
		System.out.println("\n\n\n");
		
		tut = tut.check(RList.emptyList());
		
		System.out.println(tut);
	}
	
	
	
	@Test
	public void testNotFailHAHA()
	{
		Tuple<DijkstraTextContext, DijkstraParser> tree = getTree("float a "
				 												 +"a <- b "
																 +"float b ");
		
		ReverseNameIndex rsi = new ReverseNameIndex();
		
		AST t = AST.makeUnique(false, tree.a.accept(new ASTBuilder(tree.b)), rsi);
		
		TypeUnificationTable tut = new TypeUnificationTable(rsi);
		
		t.buildTUT(tut);

		tut = tut.check(RList.emptyList());
	}

}
