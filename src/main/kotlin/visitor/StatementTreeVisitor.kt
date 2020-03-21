package visitor

import ast.StatementTree
import generated.MylaParser
import generated.MylaParserBaseVisitor

class StatementTreeVisitor : MylaParserBaseVisitor<List<StatementTree>>() {

    override fun visitDeclarationStat(ctx: MylaParser.DeclarationStatContext): List<StatementTree> {
        return emptyList()
    }

    override fun visitAssignStat(ctx: MylaParser.AssignStatContext?): List<StatementTree> {
        return emptyList()
    }

    override fun visitSequenceStat(ctx: MylaParser.SequenceStatContext?): List<StatementTree> {
        return emptyList()
    }
}
