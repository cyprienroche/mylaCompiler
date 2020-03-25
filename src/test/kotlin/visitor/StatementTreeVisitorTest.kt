package visitor

import ast.AssignmentTree
import ast.StatementTree
import ast.assignments.Arithmetic
import ast.assignments.Identifier
import com.nhaarman.mockitokotlin2.mock
import generateParser
import generated.MylaParser
import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.CharStreams
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

class StatementTreeVisitorTest {

    private val listener = mock<ANTLRErrorListener> {}
    private val validProgramPath = "src/test/resources/valid"
    private val statementVisitor = StatementTreeVisitor()

    private fun parseTree(fileName: String): MylaParser.StatContext {
        val parser = generateParser(CharStreams.fromString("$validProgramPath/$fileName.myla"), listener)
        return parser.stat()
    }

    @Test
    internal fun canVisitBasicStatement() {
        val statementParseTree = parseTree("assign")
        val expected = listOf<StatementTree>(AssignmentTree(Identifier, Arithmetic))
        assertThat(statementVisitor.visit(statementParseTree), `is`(expected))
    }
}
