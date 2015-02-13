/*******************************************************************************
 * Copyright (c) 2015 Gary F. Pollice
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Used in CS4533/CS544 at Worcester Polytechnic Institute
 *******************************************************************************/

package dijkstra.lexparse;

import static org.junit.Assert.assertTrue;

import java.io.*;
import java.util.*;

import javax.swing.JFrame;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.gui.TreeViewer;
import org.junit.Test;

import dijkstra.utility.DijkstraFactory;

/**
 * Description
 * @version Jan 27, 2015
 */
public class DijkstraParserTest
{
	private DijkstraParser parser;
	private ParserRuleContext tree;
	
	@Test
	public void minimalprogram()
	{
		doParse("int i");
	}
	
	@Test
	public void twoDeclarationProgram()
	{
		doParse("int i boolean b");
	}
	
	@Test
	public void singleAssignmentProgram()
	{
		doParse("i <- 1");
	}
	
	@Test
	public void declarationFollowedBySemicolon()
	{
		doParse("int i;");
	}
	
	@Test
	public void assignStatement()
	{
		doParse("a <- 42");
	}
	
	@Test
	public void assignmentStatementFollowedBySemicolon()
	{
		doParse("a <- 42;");
	}
	
	@Test
	public void inputStatement()
	{
		doParse("input x");
	}
	
	@Test
	public void inputStatementFollowedBySemicolon()
	{
		doParse("input x;");
	}
	
	@Test
	public void outputStatement()
	{
		doParse("print 1");
	}
	
	@Test
	public void outputStatementFollowedBySemicolon()
	{
		doParse("print 2;");
	}
	
	@Test
	public void iterativeStatement()
	{
		doParse("loop 5 a <- 1");
	}
	
	@Test
	public void compoundStatement()
	{
		doParse("{ print 3; }");
	}
	
	@Test
	public void compoundStatementWithDeclaration()
	{
		doParse("{ int i i <- 3 }");
	}
	
	@Test
	public void singleGuard()
	{
		doParse("if b :: print 1 fi");
	}
	
	@Test
	public void testEqualityExpression()
	{
		doParse("mybool <- a = b = c");
	}
	
	@Test
	public void arithmeticPrecedence1()
	{
		doParse("a <- a + b * c");
	}
	
	@Test
	public void arithmeticPrecedence2()
	{
		doParse("a <- a * b + c");
	}
	
	// Helper methods
	private void makeParser(String inputText)
	{
		parser = DijkstraFactory.makeParser(new ANTLRInputStream(inputText));
	}

	/**
	 * This method performs the parse. If you want to see what the tree looks like, use
	 * 		<br><code>System.out.println(tree.toStringTree());<code></br>
	 * after calling this method.
	 * @param inputText the text to parse
	 */
	private void doParse(String inputText)
	{
		makeParser("program test " + inputText);
		tree = parser.dijkstraText();
		assertTrue(true);
	}
	
	/**
	 * Call this routine to display the parse tree. Hit ENTER on the console to continue.
	 */
	@SuppressWarnings("unused")
    private void showTree()
	{
		System.out.println(tree.toStringTree());
		List<String> ruleNames = Arrays.asList(parser.getRuleNames());
		TreeViewer tv = new TreeViewer(ruleNames, tree);
		JFrame frame = new JFrame("Parse Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(tv);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
        try {
			br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
