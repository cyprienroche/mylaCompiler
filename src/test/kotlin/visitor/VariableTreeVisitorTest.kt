package visitor

import ast.assignments.Identifier
import ast.assignments.VariableTree
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import visitor.VisitorTestUtils.Companion.parseTree

class VariableTreeVisitorTest {

    private val variableVisitor = VariableTreeVisitor()

    @Test
    internal fun canVisitBasicStatement() {
        val expressionVariable = parseTree("assign").variable()
        val expectedVariable: VariableTree = Identifier("x")
        assertThat(variableVisitor.visit(expressionVariable), `is`(expectedVariable))
    }
}
