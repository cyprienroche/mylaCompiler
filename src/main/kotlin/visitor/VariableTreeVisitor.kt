package visitor

import ast.assignments.Identifier
import ast.assignments.VariableTree
import generated.MylaParser
import generated.MylaParserBaseVisitor

/* identifier */
class VariableTreeVisitor : MylaParserBaseVisitor<VariableTree>() {

    /* IDENT */
    override fun visitVariable(ctx: MylaParser.VariableContext): VariableTree {
        return Identifier(ctx.text)
    }
}
