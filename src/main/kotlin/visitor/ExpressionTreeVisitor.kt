package visitor

import ast.assignments.ExpressionTree
import ast.assignments.Identifier
import ast.assignments.Literal
import generated.MylaParser
import generated.MylaParserBaseVisitor

/* arithmeticExpr */
class ExpressionTreeVisitor : MylaParserBaseVisitor<ExpressionTree>() {

    override fun visitLiteral(ctx: MylaParser.LiteralContext): ExpressionTree {
        return Literal
    }

    override fun visitVariable(ctx: MylaParser.VariableContext): ExpressionTree {
        return Identifier
    }
}
