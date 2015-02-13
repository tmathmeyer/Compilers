package dijkstra;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.antlr.v4.runtime.ANTLRInputStream;

import dijkstra.lexparse.DijkstraParser;
import dijkstra.lexparse.DijkstraParser.DijkstraTextContext;
import dijkstra.utility.DijkstraFactory;

public class ParseUtils
{
	public static Tuple<DijkstraTextContext, DijkstraParser> getTree(String s)
	{
		DijkstraParser dp = makeParser(s);
		return new Tuple<DijkstraTextContext, DijkstraParser>(makeParser(s).dijkstraText(), dp);
	}
	
	public static void parse(String s)
	{
		with(makeParser(s), new Tester(){
			@Override
            public void test(String s)
            {
	            parser.dijkstraText();
	            assertTrue(true);
            }
		});
	}
	
	public static void parseToTree(String prog, String tree)
	{
		withtree(makeParser(prog), new Tester(){
			@Override
			void test(String s) {
				if (s.contains(tree))
				{
					assertTrue(true);
				}
				else
				{
					System.out.println(s);
					fail();
				}
			}
		});
	}
	
	private static void with(DijkstraParser dl, Tester test)
	{
		test.parser = dl;
		test.test("");
	}
	
	private static void withtree(DijkstraParser dl, Tester test)
	{
		test.parser = dl;
		test.test(dl.dijkstraText().toStringTree(dl));
	}
	
	private static DijkstraParser makeParser(String text)
	{
		return DijkstraFactory.makeParser(new ANTLRInputStream("program test " + text));
	}
	
	private static abstract class Tester
	{
		public DijkstraParser parser;
		abstract void test(String s);
	}
}
