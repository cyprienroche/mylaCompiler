package visitor

import ast.ProgramTree
import ast.StatementTree
import generated.MylaParser
import generated.MylaParserBaseVisitor

/* prog */
class ProgramTreeVisitor : MylaParserBaseVisitor<ProgramTree>() {

    /* stat EOF */
    override fun visitProgram(ctx: MylaParser.ProgramContext): ProgramTree {
        return ProgramTree(visitMain(ctx))
    }

    private fun visitMain(ctx: MylaParser.ProgramContext): List<StatementTree> =
        ctx.stat().accept(StatementTreeVisitor())
}
