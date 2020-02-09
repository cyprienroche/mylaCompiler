
lexer grammar MylaLexer;

NAT : [0-9]+ ;

MUL  : '*' ;
DIV  : '/' ;
MOD  : '%' ;
PLUS : '+' ;
NEG  : '-' ;

OPENPAR  : '(' ;
CLOSEPAR : ')' ;

// whitespace
WHITESPACE : [ \n\r\t\f] -> skip ;
