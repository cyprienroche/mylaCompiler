
parser grammar MylaParser;

options {
  tokenVocab = MylaLexer ;
}

// program
prog : stat EOF ;

// statements
stat : identifier ASSIGN assignRHS  # DeclarationStat
     | assignLHS ASSIGN assignRHS   # AssignStat
     | stat SEMICOLON stat          # SequenceStat
     ;

// assignments
assignLHS : identifier ;
assignRHS : expr       ;

// expressions
expr : literal                      # LiteralExpr
     | identifier                   # VariableExpr
     | unaryOp expr                 # UnaryOpExpr
     | expr mdmBinop expr           # MulDivModExpr
     | expr pnBinop  expr           # AddSubExpr
     | OPENPAR expr CLOSEPAR        # ParensExpr
     ;

unaryOp   : NEG             ;
mdmBinop  : MUL | DIV | MOD ;
pnBinop   : ADD | NEG       ;

literal : ( ADD | NEG )? NAT ;

identifier : IDENT ;
