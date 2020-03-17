package frontend.mock

import com.nhaarman.mockitokotlin2.atLeastOnce
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import generated.MylaLexer
import generated.MylaParser
import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class MockParser(private val input: String) {
    private val listener = mock<ANTLRErrorListener> {}
    private val parser: MylaParser

    init {
        val stream = CharStreams.fromString(input)
        val lexer = MylaLexer(stream)
        val tokens = CommonTokenStream(lexer)
        parser = MylaParser(tokens)

        lexer.removeErrorListeners()
        lexer.addErrorListener(listener)

        parser.removeErrorListeners()
        parser.addErrorListener(listener)
    }

    fun parseStatement(): MockParser {
        parser.stat()
        errorIfEntireInputNotParsed()
        return this
    }

    fun parseAssignLHS(): MockParser {
        parser.assignLHS()
        errorIfEntireInputNotParsed()
        return this
    }

    fun parseExpression(): MockParser {
        parser.expr()
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
        SyntaxError(listener, never().description("A syntax error occurred when parsing $input")).verify()
    }

    fun verifyInvalid() {
        SyntaxError(listener, atLeastOnce().description("The parser could not catch any errors in $input")).verify()
    }
}
