import com.nhaarman.mockitokotlin2.atLeastOnce
import com.nhaarman.mockitokotlin2.mock
import mock.HasSyntaxError
import org.antlr.v4.runtime.ANTLRErrorListener
import org.junit.jupiter.api.Test

class GeneratorTest {

    private val listener = mock<ANTLRErrorListener> {}

    @Test
    internal fun assignBracketAddsErrorToListener() {
        generateParseTree("src/test/resources/invalid/assignBracket.myla", listener)
        HasSyntaxError(listener, atLeastOnce())
            .withLine(1)
            .withCharPositionInLine(4)
            .withMessage("token recognition error at: '{'")
            .verify()
    }

    @Test
    internal fun assignBinOpAddsErrorToListener() {
        generateParseTree("src/test/resources/invalid/assignBinOp.myla", listener)
        HasSyntaxError(listener, atLeastOnce())
            .withLine(1)
            .withCharPositionInLine(7)
            .withMessage("mismatched input '<EOF>' expecting {NAT, '-', IDENT, '+', '('}")
            .verify()
    }

    @Test
    internal fun integerDeclarationAddsErrorToListener() {
        generateParseTree("src/test/resources/invalid/integerDeclaration.myla", listener)
        HasSyntaxError(listener, atLeastOnce())
            .withLine(1)
            .withCharPositionInLine(0)
            .withMessage("mismatched input '1' expecting IDENT")
            .verify()
    }
}
