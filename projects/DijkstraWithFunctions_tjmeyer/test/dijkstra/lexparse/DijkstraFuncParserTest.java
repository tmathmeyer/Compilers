package dijkstra.lexparse;

import static dijkstra.ParseUtils.parse;
import static dijkstra.ParseUtils.parseToTree;

import org.junit.Test;

public class DijkstraFuncParserTest
{

	@Test
	public void testMultipleAssignment()
	{
		parse("a, b <- 4, 4");
	}
	
	@Test
	public void testArrays()
	{
		parse("int[5] a, b, c");

		parse("int[7+7] b");
		
		parse("int[func()] b");
		
		parse("int[1] b; b <- 5");
	}
	
	@Test
	public void testProcDecl()
	{
		parse("proc setA () { a <- 5 }");

		parse("proc setA () { a <- 5; }");
		
		parse("proc setA (int b) { a <- b }");
	}
	
	@Test(expected=DijkstraParserException.class)
	public void progInsideProg()
	{
		parse("program test 4");
	}
	
	@Test
	public void testFuncDecl()
	{
		parse("fun foo (a) : int { return 5; }");
	}
	
	@Test(expected=DijkstraParserException.class)
	public void testNoStatement()
	{
		parse("fun foo (a) : int {  }");
	}
	
	@Test
	public void testNoArgs()
	{
		parse("fun foo () : int {b <- a;}");
	}
	
	@Test
	public void testMultiType()
	{
		parse("fun foo () : int, int {b <- a;}");
	}
	
	@Test
	public void testMultiReturn()
	{
		parse("fun foo () : int, int {return a,b;}");
	}
	
	@Test
	public void testAndBeforeOr()
	{
		parseToTree("a <- true | false & true", "(expr (expr true) | (expr (expr false) & (expr true)))");
	}
	
	@Test
	public void testEqualityRightAssoc()
	{
		parseToTree("V <- a = b ~= c", "(expr (expr a) = (expr (expr b) ~= (expr c)))");
	}
	
	@Test
	public void PEMDAS()
	{
		// parens before all else
		parseToTree("V <- (a - b) - c", "(expr (expr ( (expr (expr a) - (expr b)) )) - (expr c))");
		parseToTree("V <- (a - b) * c", "(expr (expr ( (expr (expr a) - (expr b)) )) * (expr c))");
		
		// sadly, no exponents
		
		// mult/div before plus/minus
		parseToTree("a <- a * b - c", "(expr (expr (expr a) * (expr b)) - (expr c))");
		parseToTree("a <- a / b - c", "(expr (expr (expr a) / (expr b)) - (expr c))");
		parseToTree("a <- a * b + c", "(expr (expr (expr a) * (expr b)) + (expr c))");
		parseToTree("a <- a / b + c", "(expr (expr (expr a) / (expr b)) + (expr c))");
		
		//reverse, reverse
		parseToTree("a <- a - b * c", "(expr (expr a) - (expr (expr b) * (expr c)))");
		parseToTree("a <- a - b / c", "(expr (expr a) - (expr (expr b) / (expr c)))");
		parseToTree("a <- a + b * c", "(expr (expr a) + (expr (expr b) * (expr c)))");
		parseToTree("a <- a + b / c", "(expr (expr a) + (expr (expr b) / (expr c)))");
	}
	
	@Test(expected=DijkstraParserException.class)
	public void arrayTypeMuchoBado()
	{
		parse("fun foo () : int[5] {return a,b;}");
	}
	
	@Test
	public void canParseBasicAwfulFibbonacci()
	{
		parse("print fib(10) "
			+" fun fib (int a) : int,int {"
				+" if"
					+" a = 0 :: return 1, 1;"
					+" a > 0 :: {"
						+" x,y <- fib(a - 1);"
						+" return x+y, x;"
					+" }"
					+" a < 0 :: return 0,0;"
				+" fi"
			+" }");
	}
}
