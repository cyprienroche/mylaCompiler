package visitor

import ast.Expression
import generated.MylaParserBaseVisitor

/* arithmeticExpr */
class ExpressionVisitor : MylaParserBaseVisitor<Expression>()
