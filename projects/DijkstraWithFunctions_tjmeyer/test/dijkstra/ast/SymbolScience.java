package dijkstra.ast;

import static dijkstra.ParseUtils.getTree;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import dijkstra.Tuple;
import dijkstra.ast.AST;
import dijkstra.ast.ASTBuilder;
import dijkstra.lexparse.DijkstraParser;
import dijkstra.lexparse.DijkstraParser.DijkstraTextContext;
import dijkstra.unify.ReverseNameIndex;
import dijkstra.unify.TypeUnificationTable;
import dijkstra.unify.rlist.RList;

public class SymbolScience {
	
	Tuple<DijkstraTextContext, DijkstraParser> tree;
	
	@Before
	public void makeNewTree()
	{
		tree = getTree("input a "
					  +"input b "
					  +"int x,y, z "
					  +"int[a+b+1] c "
					  +"c[b],c[a] <- a,b "
					  +"product <- a*b+a/b; "
					  +"fun func (int x, yy, float q) : int { "
					  +"  return x+yy; "
					  +"} "
					  +"fun fn () : int { "
					  +"  return 1 + z; "
					  +"} "
					  +"do "
					  +"  x=y :: {x <- x+1} "
					  +"  x<y :: y <- -y "
					  +"od "
					  +"proc foo (int q, r) { "
					  +"   c[b-a] <- q-r "
					  +"} "
					  +"foo(b, z); "
					  +"m <- func(0, x+y, 0.0)"
					  +"if "
					  +"  true :: print x+y "
					  +"  x>10 :: print product "
					  +"  x<10 :: print product + 10 "
					  +"  -x=-10 :: print 0 "
					  +"fi");
	}

	@Test
	public void testLiterallyEveryLanguageConstructCanBeVisited()
	{
		String astToString = "input a input b INT z,y,x A_INT[a+b+1] c c[a],c[b] <- b,a product <- a*b+a/b fun func(x,yy,q) : INT{  return x+yy } fun fn() : INT{  return 1+z } do  x=y :: {  x <- x+1 }  x<y :: y <- -y od proc foo(q,r){  c[b-a] <- q-r } foo(b,z) m <- func(0,x+y,0.0) if  true :: print x+y  x>10 :: print product  x<10 :: print product+10  -x=-10 :: print 0 fi ";
		
		AST t = tree.a.accept(new ASTBuilder(tree.b));
		
		assertEquals(t.toString().replaceAll("[\n]+|[\\ ]+", " "), astToString);
		
	}
	
	@Test
	public void testLiterallyEveryLanguageConstructCanBeMadeUnique()
	{
		AST t = tree.a.accept(new ASTBuilder(tree.b));
		
		t = AST.makeUnique(true, t);
		
		assertTrue(t != null); // no exceptions were thrown
	}
	
	@Test
	public void huh()
	{
		ReverseNameIndex rsi = new ReverseNameIndex();
		
		AST t = AST.makeUnique(true, tree.a.accept(new ASTBuilder(tree.b)), rsi);
		
		TypeUnificationTable tut = new TypeUnificationTable(rsi);
		
		t.buildTUT(tut);
		
		System.out.println(tut);
		
		tut = tut.check(RList.emptyList()).getOnlyTerminalValues();
		
		System.out.println("\n\n\n\n\n\n");
		
		System.out.println(tut);
	}

}
