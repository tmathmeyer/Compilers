package demo1;

import static demo1.ArrayInitLexer.LBRACKET;
import static demo1.ArrayInitLexer.RBRACKET;
import static demo1.ArrayInitLexer.COMMENT;
import static demo1.ArrayInitLexer.STRING;
import static demo1.ArrayInitLexer.COMMA;
import static demo1.ArrayInitLexer.TRUE;
import static demo1.ArrayInitLexer.INT;
import static demo1.ArrayInitLexer.ID;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Token;
import org.junit.Test;

public class TedsTests
{

	@Test
	public void testCommentsDontSuck()
	{
		final ArrayInitLexer lexer = makeLexer("##communistent\n12345##anotherone");
		Token t = lexer.nextToken();
		assertEquals(COMMENT, t.getType());
		assertEquals("##communistent\n", t.getText());
		
		t = lexer.nextToken();
		assertEquals(INT, t.getType());
		assertEquals("12345", t.getText());
		
		t = lexer.nextToken();
		assertEquals(COMMENT, t.getType());
		assertEquals("##anotherone", t.getText());
	}
	
	@Test
	public void testArrayThingsDontSuck()
	{
		final ArrayInitLexer lexer = makeLexer("[\"call me maybe\",GNU_LINUX,true]");
		Token t = lexer.nextToken();
		assertEquals(LBRACKET, t.getType());
		
		t = lexer.nextToken();
		assertEquals(STRING, t.getType());
		assertEquals("\"call me maybe\"", t.getText());
		
		t = lexer.nextToken();
		assertEquals(COMMA, t.getType());
		
		t = lexer.nextToken();
		assertEquals(ID, t.getType());
		assertEquals("GNU_LINUX", t.getText());
		
		t = lexer.nextToken();
		assertEquals(COMMA, t.getType());
		
		t = lexer.nextToken();
		assertEquals(TRUE, t.getType());
		assertEquals("true", t.getText());
		
		t = lexer.nextToken();
		assertEquals(RBRACKET, t.getType());
	}
	
	@Test(expected=RuntimeException.class)
	public void testBadSymbolsDoSuck()
	{
		final ArrayInitLexer lexer = makeLexer("$$bill yall");
		Token t = lexer.nextToken();
		assertEquals(LBRACKET, t.getType());
	}
	
	@Test
	public void testPoemsAndWhitespace()
	{
		final String[] poem1 = {"A wpi student named tyler\n",
								"was learning to write a compiler\n",
								"but his regexs sucked\n",
								"for he could not deduct\n",
								"that you need to use stars to match \"???\""}; // apparently I can't write limmericks
		final int[] tokTypeP1 = {ID, ID, ID, ID, ID,
								 ID, ID, ID, ID, ID, ID,
								 ID, ID, ID, ID,
								 ID, ID, ID, ID, ID,
								 ID, ID, ID, ID, ID, ID, ID, ID, STRING};
		final ArrayInitLexer p1lex = makeLexer(Arrays.asList(poem1).stream().collect(Collectors.joining("")));
		for(int i : tokTypeP1)
		{
			assertEquals(p1lex.nextToken().getType(), i);
		}
	}
	
	
	
	
	
	
	private ArrayInitLexer makeLexer(String text)
	{
		ArrayInitLexer lexer =  new ArrayInitLexer(new ANTLRInputStream(text));
		
		lexer.removeErrorListeners();
		lexer.addErrorListener(new InvalidSyntaxExceptionThrowingError());
		
		return lexer;
	}
}
