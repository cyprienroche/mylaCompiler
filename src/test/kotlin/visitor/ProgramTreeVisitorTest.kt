package visitor

import ast.AssignmentTree
import ast.ProgramTree
import ast.assignments.Identifier
import ast.assignments.Literal
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import visitor.VisitorTestUtils.Companion.parseTree

class ProgramTreeVisitorTest {

    private val programVisitor = ProgramTreeVisitor()

    @Test
    internal fun canVisitBasicProgram() {
        val programParseTree = parseTree("assign").prog()
        val expected = ProgramTree(listOf(AssignmentTree(Identifier, Literal)))
        assertThat(programVisitor.visit(programParseTree), `is`(expected))
    }
}
