
lexer grammar MylaLexer;

NAT : [0-9]+ ;

NEG  : '-' ;

MUL  : '*' ;
DIV  : '/' ;
MOD  : '%' ;
PLUS : '+' ;

OPENPAR  : '(' ;
CLOSEPAR : ')' ;

// whitespace
WHITESPACE : [ \n\r\t\f] -> skip ;

// identifiers
IDENT : [_a-zA-Z] [_a-zA-Z0-9]* ;

// assignments
ASSIGN : '=' ;
