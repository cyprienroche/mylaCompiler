package visitor

import ast.AssignmentTree
import ast.StatementTree
import generated.MylaParser
import generated.MylaParserBaseVisitor

/* stat */
class StatementTreeVisitor : MylaParserBaseVisitor<List<StatementTree>>() {

    /* variable '=' expression */
    override fun visitAssignStat(ctx: MylaParser.AssignStatContext): List<StatementTree> {
        val rhs = ctx.expression().accept(ExpressionTreeVisitor())
        val lhs = ctx.variable().accept(VariableTreeVisitor())
        return listOf(AssignmentTree(lhs, rhs))
    }

    /* stat ';' stat  */
    override fun visitSequenceStat(ctx: MylaParser.SequenceStatContext): List<StatementTree> {
        return emptyList()
    }
}
