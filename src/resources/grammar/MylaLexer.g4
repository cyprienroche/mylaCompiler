
lexer grammar MylaLexer;

UINT : DIGIT+ ;

fragment DIGIT : ('0'..'9') ;

// whitespace
WHITESPACE : (' ' | '\n' | '\r' | '\t' | '\f' ) -> skip ;

NEG : '-'  ;

MUL : '*'  ;
DIV : '/'  ;
MOD : '%'  ;
PLUS: '+'  ;
