package mock

import com.nhaarman.mockitokotlin2.atLeastOnce
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import generateParser
import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.CharStreams

class MockParser(private val input: String) {
    private val listener = mock<ANTLRErrorListener> {}
    private val parser = generateParser(CharStreams.fromString(input), listener)

    fun parseStatement(): MockParser {
        parser.stat()
        errorIfEntireInputNotParsed()
        return this
    }

    fun parseAssignLHS(): MockParser {
        parser.variable()
        errorIfEntireInputNotParsed()
        return this
    }

    fun parseArithmeticExpression(): MockParser {
        parser.arithmeticExpr()
        errorIfEntireInputNotParsed()
        return this
    }

    fun parseLiteral(): MockParser {
        parser.literal()
        errorIfEntireInputNotParsed()
        return this
    }

    private fun errorIfEntireInputNotParsed() {
        if (parser.currentToken.text != "<EOF>") {
            listener.syntaxError(mock {}, mock {}, 0, 0, "", mock {})
        }
    }

    fun verifyValid() {
        BuildSyntaxError(
            listener,
            never().description("A syntax error occurred when parsing $input")
        ).verify()
    }

    fun verifyInvalid() {
        BuildSyntaxError(
            listener,
            atLeastOnce().description("The parser could not catch any errors in $input")
        ).verify()
    }
}
