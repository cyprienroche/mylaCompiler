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

    fun withRecognizer(recognizer: Recognizer<*, *>) {
        this.recognizer = recognizer
    }

    fun withOffendingSymbol(offendingSymbol: Any) {
        this.offendingSymbol = offendingSymbol
    }

    fun withLine(line: Int) {
        this.line = line
    }

    fun withCharPositionInLine(charPositionInLine: Int) {
        this.charPositionInLine = charPositionInLine
    }

    fun withMessage(msg: String) {
        this.msg = msg
    }

    fun withRecognitionException(e: RecognitionException) {
        this.e = e
    }

    fun verify() = listener.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e)
}
