package frontend.errors

import com.nhaarman.mockitokotlin2.atLeastOnce
import com.nhaarman.mockitokotlin2.mock
import frontend.ParseTreeGenerator
import frontend.mock.HasSyntaxError
import org.antlr.v4.runtime.ANTLRErrorListener
import org.junit.jupiter.api.Test

class ParseTreeGeneratorTest {

    private val listener = mock<ANTLRErrorListener> {}

    @Test
    internal fun assignBracketAddsErrorToListener() {
        val parseTree = ParseTreeGenerator("src/test/resources/invalid/assignBracket.myla", listener)
        parseTree.parseTree()
        HasSyntaxError(listener, atLeastOnce())
            .withLine(1)
            .withCharPositionInLine(4)
            .withMessage("token recognition error at: '{'")
            .verify()
    }

    @Test
    internal fun assignBinOpAddsErrorToListener() {
        val parseTree = ParseTreeGenerator("src/test/resources/invalid/assignBinOp.myla", listener)
        parseTree.parseTree()
        HasSyntaxError(listener, atLeastOnce())
            .withLine(1)
            .withCharPositionInLine(7)
            .withMessage("no viable alternative at input 'x=5+'")
            .verify()
    }

    @Test
    internal fun integerDeclarationAddsErrorToListener() {
        val parseTree = ParseTreeGenerator("src/test/resources/invalid/integerDeclaration.myla", listener)
        parseTree.parseTree()
        HasSyntaxError(listener, atLeastOnce())
            .withLine(1)
            .withCharPositionInLine(0)
            .withMessage("mismatched input '1' expecting IDENT")
            .verify()
    }
}
