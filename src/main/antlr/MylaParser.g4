
parser grammar MylaParser;

options {
  tokenVocab = MylaLexer;
}

// program
prog : stat* EOF ;

// statements
stat : expr
     | identifier ASSIGN expr
     ;

// expressions
expr : literal
     | OPENPAR expr CLOSEPAR
     | expr mdmBinop expr
     | expr pnBinop  expr
     ;

mdmBinop  : MUL | DIV | MOD ;
pnBinop   : PLUS | NEG      ;

literal : ( PLUS | NEG )? NAT ;

identifier : IDENT ;
