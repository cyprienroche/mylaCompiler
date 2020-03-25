package visitor

import ast.Arithmetic
import ast.AssignmentTree
import ast.Identifier
import ast.StatementTree
import generated.MylaParser
import generated.MylaParserBaseVisitor

class StatementTreeVisitor : MylaParserBaseVisitor<List<StatementTree>>() {

    /* variable '=' expression */
    override fun visitAssignStat(ctx: MylaParser.AssignStatContext): List<StatementTree> {
        // val lhs = ctx.variable().accept(VariableVisitor())
        // val rhs = ctx.expression().accept(ExpressionVisitor())
        return listOf(AssignmentTree(Identifier, Arithmetic))
    }

    /* stat ';' stat  */
    override fun visitSequenceStat(ctx: MylaParser.SequenceStatContext): List<StatementTree> {
        return emptyList()
    }
}
