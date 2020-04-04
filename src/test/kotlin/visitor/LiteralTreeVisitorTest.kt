package visitor

import ast.assignments.Literal
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import visitor.VisitorTestUtils.Companion.parseTree

class LiteralTreeVisitorTest {

    private val literalVisitor = LiteralTreeVisitor()

    @Test
    internal fun canVisitBasicStatement() {
        val parser = parseTree("assign")

        val literalParseTree = parser.literal()
        val expectedLiteral = Literal(73)
        assertThat(literalVisitor.visit(literalParseTree), `is`(expectedLiteral))
    }
}
