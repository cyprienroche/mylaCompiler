
parser grammar MylaParser;

options {
  tokenVocab = MylaLexer ;
}

// program
prog : stat EOF  # Program
     ;

// statements
stat : variable '=' expression  # AssignStat
     | stat ';' stat            # SequenceStat
     ;

// expressions
expression     : literal                                 # LiteralExpr
               | variable                                # VariableExpr
               | unaryOp expression                      # UnaryOpExpr
               | expression op=('*'|'/'|'%') expression  # MulDivModExpr
               | expression op=('+'|'-')  expression     # AddSubExpr
               | '(' expression ')'                      # ParensExpr
               ;

unaryOp : NEG ;

literal : ( ADD | NEG )? NAT  # IntLiteral
        ;

variable : IDENT ;
