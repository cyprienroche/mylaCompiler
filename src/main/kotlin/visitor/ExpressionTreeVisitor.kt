package visitor

import ast.assignments.ExpressionTree
import generated.MylaParser
import generated.MylaParserBaseVisitor

/* expression */
class ExpressionTreeVisitor : MylaParserBaseVisitor<ExpressionTree>() {

    /* literal */
    override fun visitLiteral(ctx: MylaParser.LiteralContext): ExpressionTree {
        return ctx.accept(LiteralTreeVisitor())
    }

    /* variable */
    override fun visitVariable(ctx: MylaParser.VariableContext): ExpressionTree {
        return ctx.accept(VariableTreeVisitor())
    }
}
