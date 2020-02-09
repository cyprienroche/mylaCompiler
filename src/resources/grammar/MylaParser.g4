
parser grammar MylaParser;

options {
  tokenVocab = MylaLexer;
}

// program
prog : expr* EOF ;

// expressions
expr: expr mdmBinop expr
    | expr pnBinop  expr
    | OPENPAR expr CLOSEPAR
    | literal
    ;

mdmBinop  : MUL | DIV | MOD ;
pnBinop   : PLUS | NEG      ;

literal : ( PLUS | NEG )? NAT ;
