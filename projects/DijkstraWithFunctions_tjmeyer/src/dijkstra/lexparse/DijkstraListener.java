// Generated from Dijkstra.g4 by ANTLR 4.5


package dijkstra.lexparse;


import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DijkstraParser}.
 */
public interface DijkstraListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#dijkstraText}.
	 * @param ctx the parse tree
	 */
	void enterDijkstraText(DijkstraParser.DijkstraTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#dijkstraText}.
	 * @param ctx the parse tree
	 */
	void exitDijkstraText(DijkstraParser.DijkstraTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(DijkstraParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(DijkstraParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(DijkstraParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(DijkstraParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(DijkstraParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(DijkstraParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(DijkstraParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(DijkstraParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(DijkstraParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(DijkstraParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(DijkstraParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(DijkstraParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#separator}.
	 * @param ctx the parse tree
	 */
	void enterSeparator(DijkstraParser.SeparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#separator}.
	 * @param ctx the parse tree
	 */
	void exitSeparator(DijkstraParser.SeparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuard(DijkstraParser.GuardContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuard(DijkstraParser.GuardContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#varList}.
	 * @param ctx the parse tree
	 */
	void enterVarList(DijkstraParser.VarListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#varList}.
	 * @param ctx the parse tree
	 */
	void exitVarList(DijkstraParser.VarListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(DijkstraParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(DijkstraParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(DijkstraParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(DijkstraParser.TypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#idList}.
	 * @param ctx the parse tree
	 */
	void enterIdList(DijkstraParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#idList}.
	 * @param ctx the parse tree
	 */
	void exitIdList(DijkstraParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(DijkstraParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(DijkstraParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(DijkstraParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(DijkstraParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#guardedStatementList}.
	 * @param ctx the parse tree
	 */
	void enterGuardedStatementList(DijkstraParser.GuardedStatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#guardedStatementList}.
	 * @param ctx the parse tree
	 */
	void exitGuardedStatementList(DijkstraParser.GuardedStatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterProcedureDeclaration(DijkstraParser.ProcedureDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitProcedureDeclaration(DijkstraParser.ProcedureDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(DijkstraParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(DijkstraParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclaration(DijkstraParser.ArrayDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclaration(DijkstraParser.ArrayDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(DijkstraParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(DijkstraParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(DijkstraParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(DijkstraParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStatement(DijkstraParser.AssignStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStatement(DijkstraParser.AssignStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#inputStatement}.
	 * @param ctx the parse tree
	 */
	void enterInputStatement(DijkstraParser.InputStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#inputStatement}.
	 * @param ctx the parse tree
	 */
	void exitInputStatement(DijkstraParser.InputStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#outputStatement}.
	 * @param ctx the parse tree
	 */
	void enterOutputStatement(DijkstraParser.OutputStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#outputStatement}.
	 * @param ctx the parse tree
	 */
	void exitOutputStatement(DijkstraParser.OutputStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#iterativeStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterativeStatement(DijkstraParser.IterativeStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#iterativeStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterativeStatement(DijkstraParser.IterativeStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(DijkstraParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(DijkstraParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#alternativeStatement}.
	 * @param ctx the parse tree
	 */
	void enterAlternativeStatement(DijkstraParser.AlternativeStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#alternativeStatement}.
	 * @param ctx the parse tree
	 */
	void exitAlternativeStatement(DijkstraParser.AlternativeStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(DijkstraParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(DijkstraParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#procedureCall}.
	 * @param ctx the parse tree
	 */
	void enterProcedureCall(DijkstraParser.ProcedureCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#procedureCall}.
	 * @param ctx the parse tree
	 */
	void exitProcedureCall(DijkstraParser.ProcedureCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(DijkstraParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(DijkstraParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#compoundBody}.
	 * @param ctx the parse tree
	 */
	void enterCompoundBody(DijkstraParser.CompoundBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#compoundBody}.
	 * @param ctx the parse tree
	 */
	void exitCompoundBody(DijkstraParser.CompoundBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#compDeclOrStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompDeclOrStatement(DijkstraParser.CompDeclOrStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#compDeclOrStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompDeclOrStatement(DijkstraParser.CompDeclOrStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#arrayAccessor}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccessor(DijkstraParser.ArrayAccessorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#arrayAccessor}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccessor(DijkstraParser.ArrayAccessorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DijkstraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(DijkstraParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DijkstraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(DijkstraParser.ExprContext ctx);
}