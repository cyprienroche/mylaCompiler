package visitor

import ast.assignments.ExpressionTree
import generated.MylaParserBaseVisitor

/* arithmeticExpr */
class ExpressionVisitor : MylaParserBaseVisitor<ExpressionTree>()
