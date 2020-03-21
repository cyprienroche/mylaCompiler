
parser grammar MylaParser;

options {
  tokenVocab = MylaLexer ;
}

// program
prog : stat EOF                     # Program
     ;

// statements
stat : identifier                   # DeclarationStat
     | assignLHS '=' assignRHS      # AssignStat
     | stat ';' stat                # SequenceStat
     ;

// assignments
assignLHS : identifier ;
assignRHS : expr       ;

// expressions
expr : literal                      # LiteralExpr
     | identifier                   # VariableExpr
     | unaryOp expr                 # UnaryOpExpr
     | expr op=('*'|'/'|'%') expr   # MulDivModExpr
     | expr op=('+'|'-')  expr      # AddSubExpr
     | '(' expr ')'                 # ParensExpr
     ;

unaryOp : NEG ;

literal : ( ADD | NEG )? NAT ;

identifier : IDENT ;
