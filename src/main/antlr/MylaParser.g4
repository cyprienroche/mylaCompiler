
parser grammar MylaParser;

options {
  tokenVocab = MylaLexer ;
}

// program
prog : stat EOF ;

// statements
stat : identifier ASSIGN assignRHS  # DeclarationStat
     | assignLHS ASSIGN assignRHS   # AssignLHSStat
     | stat SEMICOLON stat          # SequenceStat
     ;

// assignments
assignLHS : identifier ;
assignRHS : expr       ;

// expressions
expr : literal                      # LiteralExpr
     | identifier                   # VariableExpr
     | unaryOp expr                 # UnaryOpExpr
     | expr mdmBinop expr           # MulDivModBinOpExpr
     | expr pnBinop  expr           # AddSubOpExpr
     | OPENPAR expr CLOSEPAR        # BracExpr
     ;

unaryOp   : NEG             ;
mdmBinop  : MUL | DIV | MOD ;
pnBinop   : ADD | NEG       ;

literal : ( ADD | NEG )? NAT ;

identifier : IDENT ;
