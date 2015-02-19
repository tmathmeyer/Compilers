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
					  +"fun func (int x, y, float q) : int,int { "
					  +"  return x+y, x*y; "
					  +"} "
					  +"fun fn () : int { "
					  +"  return 1 + z; "
					  +"} "
					  +"do "
					  +"  x=y :: {x <- x+1} "
					  +"  x<y :: y <- y-1 "
					  +"od "
					  +"proc foo (int q, r) { "
					  +"   c[b-a] <- q-r "
					  +"} "
					  +"foo(b, z); "
					  +"m,n <- func(0, x+y, 0.0)"
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
		String astToString = "input a input b INT z,y,x A_INT[a+b+1] c c[a],c[b] <- b,a product <- a*b+a/b fun func(int x,y,float q) : int,int{  return x*y,x+y } fun fn() : int{  return 1+z } do  x=y :: {  x <- x+1 }  x<y :: y <- y-1 od proc foo(int q,r){  c[b-a] <- q-r } foo(b,z) n,m <- func(0,x+y,0.0) if  true :: print x+y  x>10 :: print product  x<10 :: print product+10  -x=-10 :: print 0 fi ";
		
		AST t = tree.a.accept(new ASTBuilder(tree.b));
		
		assertEquals(t.toString().replaceAll("[\n]+|[\\ ]+", " "), astToString);
		
	}
	
	@Test
	public void testLiterallyEveryLanguageConstructCanBeMadeUniqui()
	{
		AST t = tree.a.accept(new ASTBuilder(tree.b));
		
		t = AST.makeUnique(t);
		
		assertTrue(t != null); // no exceptions were thrown
	}
	
	@Test
	public void huh()
	{
		ReverseNameIndex rsi = new ReverseNameIndex();
		
		AST t = AST.makeUnique(tree.a.accept(new ASTBuilder(tree.b)), rsi);
		
		TypeUnificationTable tut = new TypeUnificationTable();
		
		t.buildTUT(tut);
		
		System.out.println(rsi);
		
		System.out.println(tut);
	}

}
