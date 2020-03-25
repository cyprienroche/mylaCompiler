package visitor

import ast.assignments.Arithmetic
import ast.assignments.ExpressionTree
import ast.assignments.Identifier
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import visitor.VisitorTestUtils.Companion.parseTree

class ExpressionTreeVisitorTest {

    private val expressionVisitor = ExpressionTreeVisitor()

    @Test
    internal fun canVisitBasicStatement() {
        val parser = parseTree("assign")

        val expressionVariable = parser.expression()
        val expectedVariable: ExpressionTree = Identifier
        assertThat(expressionVisitor.visit(expressionVariable), `is`(expectedVariable))

        val expressionLiteral = parser.expression()
        val expectedLiteral: ExpressionTree = Arithmetic
        assertThat(expressionVisitor.visit(expressionLiteral), `is`(expectedLiteral))
    }
}
