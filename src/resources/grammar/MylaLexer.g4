
lexer grammar MylaLexer;

fragment DIGIT : ('0'..'9') ;

UINT : DIGIT+ ;

// whitespace
WHITESPACE : (' ' | '\n' | '\r' | '\t' | '\f' ) -> skip ;
