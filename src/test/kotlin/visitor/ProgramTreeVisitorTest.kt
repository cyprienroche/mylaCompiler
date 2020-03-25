package visitor

import ast.AssignmentTree
import ast.ProgramTree
import ast.assignments.Arithmetic
import ast.assignments.Identifier
import com.nhaarman.mockitokotlin2.mock
import generateProgramParseTree
import org.antlr.v4.runtime.ANTLRErrorListener
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

class ProgramTreeVisitorTest {

    private val listener = mock<ANTLRErrorListener> {}
    private val validProgramPath = "src/test/resources/valid"
    private val programVisitor = ProgramTreeVisitor()

    private fun parseTree(fileName: String) = generateProgramParseTree("$validProgramPath/$fileName.myla", listener)

    @Test
    internal fun canVisitBasicProgram() {
        val programParseTree = parseTree("assign")
        val expected = ProgramTree(listOf(AssignmentTree(Identifier, Arithmetic)))
        assertThat(programVisitor.visit(programParseTree), `is`(expected))
    }
}
