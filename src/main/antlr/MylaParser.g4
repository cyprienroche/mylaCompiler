
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
     | expr mdmBinop expr
     | expr pnBinop  expr
     | OPENPAR expr CLOSEPAR
     ;

mdmBinop  : MUL | DIV | MOD ;
pnBinop   : PLUS | NEG      ;

literal : ( PLUS | NEG )? NAT ;

identifier : IDENT ;
