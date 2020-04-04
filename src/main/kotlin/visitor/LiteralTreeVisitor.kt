package visitor

import ast.assignments.Literal
import generated.MylaParser
import generated.MylaParserBaseVisitor

/* literal */
class LiteralTreeVisitor : MylaParserBaseVisitor<Literal>() {

    /* ( ADD | NEG )? NAT */
    override fun visitIntLiteral(ctx: MylaParser.IntLiteralContext): Literal {
        return Literal(ctx.toInt())
    }

    /* ( ADD | NEG )? NAT */
    private fun MylaParser.IntLiteralContext.toInt(): Int {
        val value = this.NAT().text.toInt()
        val sign = if (this.NEG() == null) 1 else -1
        return sign * value
    }
}
