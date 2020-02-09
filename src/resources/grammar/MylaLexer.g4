
lexer grammar MylaLexer;

NAT : [0-9]+ ;

// whitespace
WHITESPACE : [ \n\r\t\f] -> skip ;

NEG  : '-'  ;

MUL  : '*' ;
DIV  : '/' ;
MOD  : '%' ;
PLUS : '+' ;

OPENPAR  : '(' ;
CLOSEPAR : ')' ;
