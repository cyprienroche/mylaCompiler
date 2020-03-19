package visitor

import ast.ProgramTree
import generated.MylaParser
import generated.MylaParserBaseVisitor

class ProgramTreeVisitor : MylaParserBaseVisitor<ProgramTree>() {
    override fun visitProg(ctx: MylaParser.ProgContext?): ProgramTree {
        return ProgramTree(emptyList())
    }
}
