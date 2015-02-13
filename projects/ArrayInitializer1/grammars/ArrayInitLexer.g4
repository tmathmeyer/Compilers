/** Grammars always start with a grammar header. This grammar is called
 *  ArrayInit and must match the filename: ArrayInit.g4
 */
lexer grammar ArrayInitLexer;


// parser rules start with lowercase letters, lexer rules with uppercase
INT :   [0-9]+ ;             // Define token INT as one or more digits
WS  :   [ \t\r\n]+ -> skip;
COMMENT : '##'~('\n')*('\n')*;

LBRACE : '{';
RBRACE : '}';
LBRACKET : '[';
RBRACKET : ']';

COMMA : ',';

STRING : '"' .*? '"';

TRUE : ('true'|'TRUE');
FALSE : ('false'|'FALSE');
ID : [a-z_A-Z]+[a-z_A-Z0-9]*;
