
parser grammar MylaParser;

options {
  tokenVocab = MylaLexer;
}

// program
prog : expr* EOF ;

// expressions
expr: literal
    | OPENPAR expr CLOSEPAR
    | expr mdmBinop expr
    | expr pnBinop  expr
    ;

mdmBinop  : MUL | DIV | MOD ;
pnBinop   : PLUS | NEG      ;

literal : ( PLUS | NEG )? NAT ;
