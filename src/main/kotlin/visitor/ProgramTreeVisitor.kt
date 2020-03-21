package visitor

import ast.ProgramTree
import ast.StatementTree
import generated.MylaParser.ProgContext
import generated.MylaParserBaseVisitor

class ProgramTreeVisitor : MylaParserBaseVisitor<ProgramTree>() {
    override fun visitProg(ctx: ProgContext): ProgramTree {
        return ProgramTree(visitMain(ctx))
    }

    private fun visitMain(ctx: ProgContext): List<StatementTree> = ctx.stat().accept(StatementTreeVisitor())
}
