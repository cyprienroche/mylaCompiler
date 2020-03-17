package frontend.mock

import com.nhaarman.mockitokotlin2.mock
import generated.MylaLexer
import generated.MylaParser
import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class MockParser(input: String) {
    val listener = mock<ANTLRErrorListener> {}
    private val parser: MylaParser

    init {
        val stream = CharStreams.fromString(input)
        val lexer = MylaLexer(stream)

        lexer.removeErrorListeners()
        lexer.addErrorListener(listener)

        val tokens = CommonTokenStream(lexer)
        val parser = MylaParser(tokens)

        parser.removeErrorListeners()
        parser.addErrorListener(listener)

        this.parser = parser
    }

    fun parseExpression() {
        parser.expr()
        errorIfEntireInputNotParsed()
    }

    private fun errorIfEntireInputNotParsed() {
        if (parser.currentToken.text != "<EOF>") {
            listener.syntaxError(mock {}, mock {}, 0, 0, "", mock {})
        }
    }
}
