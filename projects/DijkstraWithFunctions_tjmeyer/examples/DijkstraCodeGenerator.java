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

package dijkstra.gen;

import java.util.Stack;
import org.objectweb.asm.*;
import dijkstra.ast.*;
import dijkstra.ast.ASTNodeFactory.*;
import dijkstra.lexparse.DijkstraParser;
import dijkstra.utility.*;
import static dijkstra.utility.DijkstraType.*;
import static org.objectweb.asm.Opcodes.*;

/**
 * Description
 * @version Feb 21, 2015
 */
public class DijkstraCodeGenerator extends ASTVisitor<byte[]>
{
	private final boolean debug = true;
	private ClassWriter cw = null;
	private MethodVisitor mv = null;
	
	private final String DEFAULT_PACKAGE = "djkcode";
	private String classPackage;
	private boolean needValue;		// used to indicate whether we need an ID value or address
	final private Stack<Label> guardLabelStack;
	
	public DijkstraCodeGenerator()
	{
		classPackage = DEFAULT_PACKAGE;
		guardLabelStack = new Stack<Label>();
	}
	
	/**
	 * Generate the program prolog, then visit the children, then generate
	 * the program end.
	 * @see dijkstra.ast.ASTVisitor#visit(dijkstra.ast.ASTNodeFactory.ProgramNode)
	 */
	public byte[] visit(ProgramNode program) 
	{
		// prolog
		cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES); 
		cw.visit(V1_8, ACC_PUBLIC + ACC_STATIC, classPackage + "/" + program.programName, null, 
				"java/lang/Object", null);
		mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
		mv.visitCode();
		mv.visitVarInsn(ALOAD, 0);
		mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
		mv.visitInsn(RETURN);
		mv.visitMaxs(0, 0);
		mv.visitEnd();
		// Start the main() method
		mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
		mv.visitCode();
		
		visitChildren(program);
		
		// program end
		//  End of main
		mv.visitInsn(RETURN);
		mv.visitMaxs(0, 0);
		mv.visitEnd();
		// Actual end of generation
		cw.visitEnd();
		return cw.toByteArray();
	}
	
	public byte[] visit(DeclarationNode decl)
	{
		return null;
	}
	
	/**
	 * Call the runtime input for the ID and then stor the result in the 
	 * @see dijkstra.ast.ASTVisitor#visit(dijkstra.ast.ASTNodeFactory.InputNode)
	 */
	public byte[] visit(InputNode input)
	{
		IDNode id = input.getID();
		mv.visitLdcInsn(id.token.getText());	// Name of the variable
		if (id.getType() == INT) {
			mv.visitMethodInsn(INVOKESTATIC, "dijkstra/runtime/DijkstraRuntime", "inputInt", 
					"(Ljava/lang/String;)I", false);
		} else {
			mv.visitMethodInsn(INVOKESTATIC, "dijkstra/runtime/DijkstraRuntime", "inputBoolean", 
					"(Ljava/lang/String;)Z", false);
		}
		mv.visitVarInsn(ISTORE, id.getAddress());
		return null;
	}
	
	/**
	 * Get the expression onto the stack and then call the runtime print
	 * routine.
	 * @see dijkstra.ast.ASTVisitor#visit(dijkstra.ast.ASTNodeFactory.OutputNode)
	 */
	public byte[] visit(OutputNode output)
	{
		output.getExpression().accept(this);	// TOS = expression value
		if (output.type == INT) {
			mv.visitMethodInsn(INVOKESTATIC, 
				"dijkstra/runtime/DijkstraRuntime", "printInt", "(I)V", false);
		} else {
			mv.visitMethodInsn(INVOKESTATIC, 
					"dijkstra/runtime/DijkstraRuntime", "printBoolean", "(Z)V", false);
		}
		return null;
	}
	
	public byte[] visit(AssignNode assign)
	{
		assign.getExpression().accept(this);	// TOS = expression value
		mv.visitVarInsn(ISTORE, assign.getId().getAddress());
		return null;
	}
	
	public byte[] visit(AlternativeNode alternative)
	{
		final Label endLabel = new Label();
		guardLabelStack.push(endLabel);
		visitChildren(alternative);
		guardLabelStack.pop();
		mv.visitIntInsn(BIPUSH, alternative.getLineNumber());
		mv.visitMethodInsn(INVOKESTATIC, "dijkstra/runtime/DijkstraRuntime", 
				"abortNoAlternative", "(I)V", false);
		mv.visitLabel(endLabel);
		return null;
	}
	
	public byte[] visit(IterativeNode loop)
	{
		final int tempAddress = JVMInfo.getNextAddress();	// store the counter
		loop.getExpression().accept(this);					// TOS = expression
		mv.visitVarInsn(ISTORE, tempAddress);
		final Label testConditionLabel = new Label();
		mv.visitJumpInsn(GOTO, testConditionLabel);
		final Label startStatementLabel = new Label();
		mv.visitLabel(startStatementLabel);
		loop.getStatement().accept(this);
		// now decrement 1 from the counter
		mv.visitIincInsn(tempAddress, -1);
		mv.visitLabel(testConditionLabel);
		mv.visitVarInsn(ILOAD, tempAddress);
		mv.visitJumpInsn(IFNE, startStatementLabel);
		return null;
	}
	
	public byte[] visit(GuardNode guard)
	{
		final Label failLabel = new Label();
		guard.getExpression().accept(this);
		mv.visitJumpInsn(IFEQ, failLabel);
		guard.getStatement().accept(this);
		mv.visitJumpInsn(GOTO, guardLabelStack.peek());
		mv.visitLabel(failLabel);
		return null;
	}
	
	/**
	 * Evaluate the child expression and then negate it (logical or arithmetic). Logical
	 * negation is more difficult because there is no logical negate instruction in the 
	 * JVM instruction set.
	 * @see dijkstra.ast.ASTVisitor#visit(dijkstra.ast.ASTNodeFactory.UnaryExpressionNode)
	 */
	public byte[] visit(UnaryExpressionNode unary)
	{
		visitChildren(unary);	// Evaluate the expression
		// TOS = the child expression
		if (unary.type == INT) {
			mv.visitInsn(INEG);
		} else {	// Boolean ~
			final Label l1 = new Label();
			final Label l2 = new Label();
			mv.visitJumpInsn(IFEQ, l1);
			mv.visitInsn(ICONST_0);		// true -> false
			mv.visitJumpInsn(GOTO, l2);
			mv.visitLabel(l1);
			mv.visitInsn(ICONST_1);		// false -> true
			mv.visitLabel(l2);
		}
		return null;
	}
	
	/**
	 * Get the values of the left and right children on the stack and then perform
	 * the operation.
	 * @see dijkstra.ast.ASTVisitor#visit(dijkstra.ast.ASTNodeFactory.BinaryExpressionNode)
	 */
	public byte[] visit(BinaryExpressionNode binary)
	{
		visitChildren(binary);		// Stack = ... left right
		Label lab1, lab2;
		switch (binary.getOp()) {
			case DijkstraParser.LT:
				lab1 =  new Label();
				mv.visitJumpInsn(IF_ICMPGE, lab1);
				mv.visitInsn(ICONST_1);		// left < right
				lab2 = new Label();
				mv.visitJumpInsn(GOTO, lab2);
				mv.visitLabel(lab1);
				mv.visitInsn(ICONST_0);		// right >= left
				mv.visitLabel(lab2);
				break;
			case DijkstraParser.GT:
				lab1 =  new Label();
				mv.visitJumpInsn(IF_ICMPLE, lab1);
				mv.visitInsn(ICONST_1);		// left > right
				lab2 = new Label();
				mv.visitJumpInsn(GOTO, lab2);
				mv.visitLabel(lab1);
				mv.visitInsn(ICONST_0);		// right <= left
				mv.visitLabel(lab2);
				break;
			case DijkstraParser.EQ:
				lab1 =  new Label();
				mv.visitJumpInsn(IF_ICMPNE, lab1);
				mv.visitInsn(ICONST_1);		// left = right
				lab2 = new Label();
				mv.visitJumpInsn(GOTO, lab2);
				mv.visitLabel(lab1);
				mv.visitInsn(ICONST_0);		// left ~= right
				mv.visitLabel(lab2);
				break;
			case DijkstraParser.NEQ:
				lab1 =  new Label();
				mv.visitJumpInsn(IF_ICMPEQ, lab1);
				mv.visitInsn(ICONST_1);		// left != right
				lab2 = new Label();
				mv.visitJumpInsn(GOTO, lab2);
				mv.visitLabel(lab1);
				mv.visitInsn(ICONST_0);		// left = right
				mv.visitLabel(lab2);
				break;
			case DijkstraParser.PLUS:
				mv.visitInsn(IADD);
				break;
			case DijkstraParser.MINUS:
				mv.visitInsn(ISUB);
				break;
			case DijkstraParser.STAR:
				mv.visitInsn(IMUL);
				break;
			case DijkstraParser.SLASH:
				mv.visitInsn(IDIV);
				break;
		}
		return null;
	}
	
	/**
	 * Simply load the constant value onto the stack.
	 * @see dijkstra.ast.ASTVisitor#visit(dijkstra.ast.ASTNodeFactory.ConstantNode)
	 */
	public byte[] visit(ConstantNode constant)
	{
		if (constant.type == INT) {
			int i = Integer.parseInt(constant.token.getText());
			mv.visitLdcInsn(i);
		} else {
			// boolean
			if (constant.token.getText().equals("true")) {
				mv.visitInsn(ICONST_1);
			} else {
				mv.visitInsn(ICONST_0);
			}
		}
		return null;
	}
	
	/**
	 * When visiting an ID node, we want the value of the ID on the top of stack
	 * @see dijkstra.ast.ASTVisitor#visit(dijkstra.ast.ASTNodeFactory.IDNode)
	 */
	public byte[] visit(IDNode id)
	{
		mv.visitVarInsn(ILOAD, id.getAddress());
		return null;
	}
	
	//------------------------ Helper methods -----------------------------
	
	public byte[] getByteCode()
	{
		return cw.toByteArray();
	}
	
	/**
	 * Print out a debugging message. If you're not debugging, just set the debugging
	 * variable.
	 * @param msg
	 */
	private void debug(String msg) 
	{
		if (debug) {
			debug(msg, "    ");
		}
	}
	
	private void debug(String msg, String pad)
	{
		System.out.println("DBG> " + pad + msg);
	}
}
