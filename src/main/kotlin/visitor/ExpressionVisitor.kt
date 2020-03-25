package visitor

import ast.Expression
import generated.MylaParserBaseVisitor

class ExpressionVisitor : MylaParserBaseVisitor<Expression>()
