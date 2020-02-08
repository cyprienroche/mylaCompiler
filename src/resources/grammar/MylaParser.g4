
parser grammar MylaParser;

options {
  tokenVocab = MylaLexer;
}

// program
prog : expr* EOF ;

// statements
expr: literal
    | expr mulBinop expr
    | expr addBinop expr
    ;

mulBinop  : MUL | DIV | MOD ;
addBinop  : PLUS | NEG      ;

literal : ( PLUS | NEG )? UINT ;
