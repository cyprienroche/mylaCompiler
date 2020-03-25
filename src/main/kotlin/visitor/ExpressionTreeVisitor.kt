package visitor

import ast.assignments.Arithmetic
import ast.assignments.ExpressionTree
import ast.assignments.Identifier
import generated.MylaParser
import generated.MylaParserBaseVisitor

/* arithmeticExpr */
class ExpressionTreeVisitor : MylaParserBaseVisitor<ExpressionTree>() {

    override fun visitLiteral(ctx: MylaParser.LiteralContext): ExpressionTree {
        return Arithmetic
    }

    override fun visitVariable(ctx: MylaParser.VariableContext): ExpressionTree {
        return Identifier
    }
}
