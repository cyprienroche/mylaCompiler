package visitor

import ast.assignments.Literal
import generated.MylaParserBaseVisitor
import org.antlr.v4.runtime.tree.TerminalNode

/* literal */
class LiteralTreeVisitor : MylaParserBaseVisitor<Literal>() {

    /* ( ADD | NEG )? NAT */
    override fun visitTerminal(node: TerminalNode): Literal {
        return Literal(node.text.toInt())
    }
}
