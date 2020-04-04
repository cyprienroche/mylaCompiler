package visitor

import ast.assignments.ExpressionTree
import generated.MylaParser
import generated.MylaParserBaseVisitor

/* expression */
class ExpressionTreeVisitor : MylaParserBaseVisitor<ExpressionTree>() {

    /* literal */
    override fun visitLiteralExpr(ctx: MylaParser.LiteralExprContext): ExpressionTree {
        return ctx.accept(LiteralTreeVisitor())
    }

    /* variable */
    override fun visitVariableExpr(ctx: MylaParser.VariableExprContext): ExpressionTree {
        return ctx.accept(VariableTreeVisitor())
    }
}
