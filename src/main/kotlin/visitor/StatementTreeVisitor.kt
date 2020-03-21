package visitor

import ast.StatementTree
import generated.MylaParser
import generated.MylaParserBaseVisitor

class StatementTreeVisitor : MylaParserBaseVisitor<List<StatementTree>>() {

    /* identifier */
    override fun visitDeclarationStat(ctx: MylaParser.DeclarationStatContext): List<StatementTree> {
        return emptyList()
    }

    /* assignLHS '=' assignRHS */
    override fun visitAssignStat(ctx: MylaParser.AssignStatContext?): List<StatementTree> {
        return emptyList()
    }

    /* stat ';' stat  */
    override fun visitSequenceStat(ctx: MylaParser.SequenceStatContext?): List<StatementTree> {
        return emptyList()
    }
}
