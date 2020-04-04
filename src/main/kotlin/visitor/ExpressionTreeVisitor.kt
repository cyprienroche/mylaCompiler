package visitor

import ast.assignments.ExpressionTree
import ast.assignments.Literal
import generated.MylaParser
import generated.MylaParserBaseVisitor

/* expression */
class ExpressionTreeVisitor : MylaParserBaseVisitor<ExpressionTree>() {

    /* literal */
    override fun visitLiteral(ctx: MylaParser.LiteralContext): ExpressionTree {
        return Literal
    }

    /* variable */
    override fun visitVariable(ctx: MylaParser.VariableContext): ExpressionTree {
        return ctx.accept(VariableTreeVisitor())
    }
}
