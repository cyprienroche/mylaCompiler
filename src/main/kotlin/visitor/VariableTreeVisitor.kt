package visitor

import ast.assignments.Identifier
import ast.assignments.VariableTree
import generated.MylaParser
import generated.MylaParserBaseVisitor

/* identifier */
class VariableTreeVisitor : MylaParserBaseVisitor<VariableTree>() {
    override fun visitVariable(ctx: MylaParser.VariableContext): VariableTree {
        return Identifier
    }
}
