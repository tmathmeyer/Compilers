package dijkstra.lexparse;

import static org.junit.Assert.*;

import static dijkstra.lexparse.DijkstraLexer.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Token;
import org.junit.Test;

import dijkstra.utility.DijkstraFactory;

public class DijkstraFuncLexerTests {

	private DijkstraLexer lexer;
	private Token t;
	
	@Test
	public void recognizeReservedWords()
	{
		makeLexer(">= <= mod div & | , do od :: fun proc float return");
		checkNextToken(GTEQ, ">=");
		checkNextToken(LTEQ, "<=");
		checkNextToken(MOD, "mod");
		checkNextToken(DIV, "div");
		checkNextToken(AMP, "&");
		checkNextToken(BAR, "|");
		checkNextToken(COMMA, ",");
		checkNextToken(DO, "do");
		checkNextToken(OD, "od");
		checkNextToken(GUARD, "::");
		checkNextToken(FUN, "fun");
		checkNextToken(PROC, "proc");
		checkNextToken(FLOAT, "float");
		checkNextToken(RETURN, "return");
		
	}
	
	// Helper methods
	private void makeLexer(String text)
	{
		lexer = DijkstraFactory.makeLexer(new ANTLRInputStream(text));
	}

	private void nextToken()
	{
		t = lexer.nextToken();
	}
	
	private void checkNextToken(int tokenType, String tokenText)
	{
		nextToken();
		assertEquals(tokenType, t.getType());
		assertEquals(tokenText, t.getText());
	}

}
