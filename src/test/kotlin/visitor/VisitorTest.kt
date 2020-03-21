package frontend.visitor

import ast.ProgramTree
import com.nhaarman.mockitokotlin2.mock
import generateParseTree
import org.antlr.v4.runtime.ANTLRErrorListener
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import visitor.ProgramTreeVisitor
import visitor.StatementTreeVisitor

class VisitorTest {

    private val listener = mock<ANTLRErrorListener> {}
    private val validProgramPath = "src/test/resources/valid"

    @Test
    internal fun canVisitBasicProgram() {
        val parseTree = generateParseTree("$validProgramPath/assign.myla", listener)
        val visitor: ProgramTreeVisitor = ProgramTreeVisitor()
        val expectedTree = ProgramTree(emptyList())
        assertThat(visitor.visit(parseTree), `is`(expectedTree))
    }

    @Test
    internal fun canVisitBasicStatement() {
        val parseTree = generateParseTree("$validProgramPath/assign.myla", listener)
        assertThat(parseTree.accept(StatementTreeVisitor()), `is`(emptyList()))
    }
}
