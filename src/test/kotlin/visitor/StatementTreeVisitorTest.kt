package visitor

import ast.AssignmentTree
import ast.StatementTree
import ast.assignments.Identifier
import ast.assignments.Literal
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import visitor.VisitorTestUtils.Companion.parseTree

class StatementTreeVisitorTest {

    private val statementVisitor = StatementTreeVisitor()

    @Test
    internal fun canVisitBasicStatement() {
        val statementParseTree = parseTree("assign").stat()
        val expected = listOf<StatementTree>(AssignmentTree(Identifier("x"), Literal))
        assertThat(statementVisitor.visit(statementParseTree), `is`(expected))
    }
}
