/*******************************************************************************
 * Copyright (c) 2015 Gary F. Pollice / Ted Meyer
 *
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Used in CS4533/CS544 at Worcester Polytechnic Institute
 *******************************************************************************/
 /*
  * This is the grammar for Dijkstra with Functions
  */
grammar Dijkstra;

@header {

package dijkstra.lexparse;

}

// tokens {
// 	FLOAT
// }
 
// Parser rules
dijkstraText : 			program EOF ;
program :				PROGRAM ID (declaration | statement)+ ;
 
declaration :			variableDeclaration
						| arrayDeclaration
						| procedureDeclaration
						| functionDeclaration;
						
						
						
// compound types
type :					FLOAT | BOOLEAN | INT ;
var :					ID | arrayAccessor;
parameter :				ID | type ID;
argument :				expr;
separator :				SEMICOLON?;
guard :					expr GUARD statement;

// list types
varList :				var | varList COMMA var;
parameterList :			parameter | parameterList COMMA parameter;
typeList :				type | typeList COMMA type;
idList :				ID | idList COMMA ID;
expressionList :		expr | expressionList COMMA expr;
argList :				argument | argList COMMA argument;
guardedStatementList :	guard | guardedStatementList guard;





// procedures and procedure calls
procedureDeclaration :	PROC ID LPAR parameter* RPAR compoundStatement;

// function definitions
functionDeclaration :	FUN ID LPAR RPAR COLON typeList compoundStatement
						|FUN ID LPAR parameterList RPAR COLON typeList compoundStatement;

// array declarations
arrayDeclaration :		type LBRACK expr RBRACK idList separator;


// variable declarations
variableDeclaration :	type idList separator ;





 
statement :				assignStatement
	 				 	| inputStatement 
	 				 	| outputStatement
	 				 	| iterativeStatement
	 				 	| compoundStatement
	 				 	| alternativeStatement
	 				 	| returnStatement
	 				 	| procedureCall;
assignStatement :		varList ASSIGN expressionList SEMICOLON?;
inputStatement :		INPUT ID SEMICOLON? ;
outputStatement :		PRINT expr SEMICOLON? ;
iterativeStatement :	DO guardedStatementList OD ;
compoundStatement :		LBRACE compoundBody RBRACE ;
alternativeStatement :	IF guard+ FI ;
returnStatement :		(RETURN | RETURN expressionList) SEMICOLON?;
procedureCall :			ID LPAR RPAR
						| ID LPAR argList RPAR;
functionCall :			ID LPAR RPAR
						| ID LPAR argList RPAR;


compoundBody :			compDeclOrStatement 
						| compDeclOrStatement compoundBody;

compDeclOrStatement :	variableDeclaration
						| arrayDeclaration
						| statement;

arrayAccessor :			ID LBRACK expr RBRACK;

 
/* Note that the equality operators are right-associative. This allows for a = b ~= c to be
 * interpreted as a = (b ~= c). Semantic analysis would guarantee that a is a boolean.
 * NOTE also that the placement of the <assoc=right> in different from the description in
 * TDAR. The new way of doing this is described at 
 * https://theantlrguy.atlassian.net/wiki/display/ANTLR4/Left-recursive+rules
 */
expr :			arrayAccessor
						| functionCall
						|LPAR expr RPAR
						| (TILDE | MINUS) expr
						| expr (STAR | SLASH | MOD | DIV) expr
						| expr (PLUS | MINUS) expr
						| expr (LT | GT | GTEQ | LTEQ) expr
						| <assoc=right> expr (EQ | NEQ) expr
						| expr AMP expr
						| expr BAR expr
						| ID
						| (TRUE | FALSE)
						| FLOAT_CONST
						| INTEGER
						;

//expr:   expr '.' ID                 // suffix operator, precedence 11
//    |   expr '[' expr ']'           // suffix operator, precedence 10
//    |   '-' expr                    // prefix operator, precedence 9
//    |   expr ('*'|'/') expr         // binary operator, precedence 8
//    |   expr ('+'|'-') expr         // binary operator, precedence 7
//    |   expr '&' expr               // binary operator, precedence 6
//    |   expr '?' expr ':' expr      // ternary operator, precedence 5
//    |   expr '='<assoc=right> expr  // binary right-associative op, prec 4
//    |   ID                          // primary
//    |   INT                         // primary
//    |   '(' expr ')'                // primary
//    ;
/* Lexical rules */
 
// Separators and operators
ASSIGN :		'<-' ;
EQ :			'=' ;
GT :			'>' ;
GUARD :			'::' ;
LBRACE :		'{' ;
LPAR :			'(' ;
LT :			'<' ;
MINUS :			'-' ;
NEQ :			'~=' ;
PLUS :			'+' ;
RBRACE :		'}' ;
RPAR :			')' ;
SEMICOLON :		';' ;
SLASH :			'/' ;
STAR :			'*' ;
TILDE :			'~' ;
LBRACK :		'[' ;
RBRACK :		']' ;
COLON :			':' ;
COMMA :			',' ;
AMP :			'&' ;
BAR :			'|' ;
GTEQ :			'>=' ;
LTEQ :			'<=' ;
MOD :			'mod' ;
DIV :			'div' ;
 
// Reserved words
BOOLEAN :		'boolean' ;
FALSE :			'false' ;
FI :			'fi' ;
IF :			'if' ;
DO :			'do' ;
OD :			'od' ;
INPUT :			'input' ;
INT:			'int' ;
PRINT :			'print' ;
PROGRAM :		'program' ;
TRUE :			'true' ;
FUN :			'fun' ;
PROC :			'proc' ;
FLOAT : 		'float' ;
RETURN :		'return' ;

 // The rest
 ID : 			LETTER (LETTER|DIGIT|'_'|'?')* ;
 
 INTEGER : 		DIGIT+ ;
 
 FLOAT_CONST : 	INTEGER'.'INTEGER;
 
 WS :			[ \t\r\n]+ -> skip ;
 COMMENT :		'#' .*? ('\n'|EOF);
 
 fragment
 LETTER :		[A-Za-z] ;
 
 fragment
 DIGIT :		[0-9] ;