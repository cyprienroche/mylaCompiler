package visitor

import ast.assignments.Identifier
import ast.assignments.VariableTree
import com.nhaarman.mockitokotlin2.mock
import generateParser
import generated.MylaParser
import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.CharStreams
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

class VariableTreeVisitorTest {

    private val listener = mock<ANTLRErrorListener> {}
    private val validProgramPath = "src/test/resources/valid"
    private val variableVisitor = VariableTreeVisitor()

    private fun parseTree(fileName: String): MylaParser =
        generateParser(CharStreams.fromFileName("$validProgramPath/$fileName.myla"), listener)

    @Test
    internal fun canVisitBasicStatement() {
        val parser = parseTree("assign")

        val expressionVariable = parser.variable()
        val expectedVariable: VariableTree = Identifier
        assertThat(variableVisitor.visit(expressionVariable), `is`(expectedVariable))
    }
}
