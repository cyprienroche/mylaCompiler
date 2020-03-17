package frontend.mock

import com.nhaarman.mockitokotlin2.anyOrNull
import com.nhaarman.mockitokotlin2.verify
import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.mockito.verification.VerificationMode

class SyntaxError(mock: ANTLRErrorListener, mode: VerificationMode) {

    private val listener: ANTLRErrorListener = verify(mock, mode)
    private var recognizer: Recognizer<*, *> = anyOrNull()
    private var offendingSymbol: Any = anyOrNull()
    private var line: Int = anyOrNull()
    private var charPositionInLine: Int = anyOrNull()
    private var msg: String = anyOrNull()
    private var e: RecognitionException = anyOrNull()

    fun withRecognizer(recognizer: Recognizer<*, *>): SyntaxError {
        this.recognizer = recognizer
        return this
    }

    fun withOffendingSymbol(offendingSymbol: Any): SyntaxError {
        this.offendingSymbol = offendingSymbol
        return this
    }

    fun withLine(line: Int): SyntaxError {
        this.line = line
        return this
    }

    fun withCharPositionInLine(charPositionInLine: Int): SyntaxError {
        this.charPositionInLine = charPositionInLine
        return this
    }

    fun withMessage(msg: String): SyntaxError {
        this.msg = msg
        return this
    }

    fun withRecognitionException(e: RecognitionException): SyntaxError {
        this.e = e
        return this
    }

    fun verify() = listener.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e)
}
