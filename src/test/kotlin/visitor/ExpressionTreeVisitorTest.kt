package visitor

import ast.assignments.Arithmetic
import ast.assignments.ExpressionTree
import ast.assignments.Identifier
import com.nhaarman.mockitokotlin2.mock
import generateParser
import generated.MylaParser
import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.CharStreams
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

class ExpressionTreeVisitorTest {

    private val listener = mock<ANTLRErrorListener> {}
    private val validProgramPath = "src/test/resources/valid"
    private val expressionVisitor = ExpressionTreeVisitor()

    private fun parseTree(fileName: String): MylaParser =
        generateParser(CharStreams.fromFileName("$validProgramPath/$fileName.myla"), listener)

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
