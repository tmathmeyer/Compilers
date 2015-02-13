/*******************************************************************************
 * Copyright (c) 2014 Gary F. Pollice
 *
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Used in CS3733, Software Engineering at Worcester Polytechnic Institute
 *******************************************************************************/

package demo1;

import static org.junit.Assert.*;
import org.antlr.v4.runtime.*;		// Make sure you use antlr.v4.runtime
import static org.antlr.v4.runtime.Token.EOF;
import static demo1.ArrayInitLexer.*;
import org.junit.*;

/**
 * Test cases for the ArrayInitLexer class.
 * 
 * @version Jan 17, 2015
 */
public class ArrayInitLexerTest
{
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{

	}

	@Test
	public void emptyStringReturnsEOF()
	{
		final ArrayInitLexer lexer = makeLexer("");
		assertEquals(EOF, lexer.nextToken().getType());
	}
	
	@Test
	public void recognizeInt()
	{
		final ArrayInitLexer lexer = makeLexer("42");
		final Token t = lexer.nextToken();
		assertEquals(INT, t.getType());
		assertEquals("42", t.getText());
		assertEquals(0, t.getCharPositionInLine());
		assertEquals(1, t.getLine());	// Note this starts at 1!
	}
	
	@Test
	public void intThenComment()
	{
		final ArrayInitLexer lexer = makeLexer("42##This is a comment\n");
		Token t = lexer.nextToken();
		assertEquals(INT, t.getType());
		assertEquals("42", t.getText());
		t = lexer.nextToken();
		assertEquals(COMMENT, t.getType());
		assertEquals("##This is a comment\n", t.getText());
	}

	private ArrayInitLexer makeLexer(String text)
	{
		ArrayInitLexer lexer =  new ArrayInitLexer(new ANTLRInputStream(text));
		
		lexer.removeErrorListeners();
		lexer.addErrorListener(new InvalidSyntaxExceptionThrowingError());
		
		return lexer;
	}

}
