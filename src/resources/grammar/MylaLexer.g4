
lexer grammar MylaLexer;

fragment DIGIT : ('0'..'9') ;

UINT : DIGIT+ ;

// whitespace
WHITESPACE : (' ' | '\t' | '\n' | '\f' | '\r' ) -> skip ;
