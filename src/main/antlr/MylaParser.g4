
parser grammar MylaParser;

options {
  tokenVocab = MylaLexer ;
}

// program
prog : stat EOF                     # Program
     ;

// statements
stat : variable '=' expression      # AssignStat
     | stat ';' stat                # SequenceStat
     ;

// assignments
variable   : identifier          ;
expression : arithmeticExpr      ;

// expressions
arithmeticExpr : literal                                          # LiteralExpr
               | identifier                                       # VariableExpr
               | unaryOp arithmeticExpr                           # UnaryOpExpr
               | arithmeticExpr op=('*'|'/'|'%') arithmeticExpr   # MulDivModExpr
               | arithmeticExpr op=('+'|'-')  arithmeticExpr      # AddSubExpr
               | '(' arithmeticExpr ')'                           # ParensExpr
               ;

unaryOp : NEG ;

literal : ( ADD | NEG )? NAT ;

identifier : IDENT ;
