package errors

import com.nhaarman.mockitokotlin2.atLeastOnce
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import generateProgramParseTree
import mock.BuildSyntaxError
import org.antlr.v4.runtime.ANTLRErrorListener
import org.junit.jupiter.api.Test

class GeneratorTest {

    private val listener = mock<ANTLRErrorListener> {}

    private fun parseTree(dir: String, fileName: String) =
        generateProgramParseTree("src/test/resources/$dir/$fileName.myla", listener)

    @Test
    internal fun validAssignmentAddsNoError() {
        parseTree("valid", "assign")
        BuildSyntaxError(listener, never()).verify()
    }

    @Test
    internal fun validDeclarationAddsNoError() {
        parseTree("valid", "assignExpr")
        BuildSyntaxError(listener, never()).verify()
    }

    @Test
    internal fun assignBracketAddsErrorToListener() {
        parseTree("invalid", "assignBracket")
        BuildSyntaxError(listener, atLeastOnce())
            .withLine(1)
            .withCharPositionInLine(4)
            .withMessage("token recognition error at: '{'")
            .verify()
    }

    @Test
    internal fun assignBinOpAddsErrorToListener() {
        parseTree("invalid", "assignBinOp")
        BuildSyntaxError(listener, atLeastOnce())
            .withLine(1)
            .withCharPositionInLine(7)
            .withMessage("mismatched input '<EOF>' expecting {NAT, '-', IDENT, '+', '('}")
            .verify()
    }

    @Test
    internal fun integerDeclarationAddsErrorToListener() {
        parseTree("invalid", "integerDeclaration")
        BuildSyntaxError(listener, atLeastOnce())
            .withLine(1)
            .withCharPositionInLine(0)
            .withMessage("mismatched input '1' expecting IDENT")
            .verify()
    }
}
