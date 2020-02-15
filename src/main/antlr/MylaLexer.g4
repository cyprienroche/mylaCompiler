
lexer grammar MylaLexer;

NAT : [0-9]+ ;

// whitespace
WHITESPACE : [ \n\r\t\f] -> skip ;

NEG  : '-' ;

// identifiers
IDENT : [_a-zA-Z] [_a-zA-Z0-9]* ;

MUL  : '*' ;
DIV  : '/' ;
MOD  : '%' ;
PLUS : '+' ;

OPENPAR  : '(' ;
CLOSEPAR : ')' ;

// assignments
ASSIGN : '=' ;
