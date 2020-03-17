package frontend.mock

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.mockito.verification.VerificationMode

class SyntaxError(mock: ANTLRErrorListener, mode: VerificationMode) {

    private val listener: ANTLRErrorListener = verify(mock, mode)
    private var recognizer: Recognizer<*, *> = any()
    private var offendingSymbol: Any = any()
    private var line: Int = any()
    private var charPositionInLine: Int = any()
    private var msg: String = any()
    private var e: RecognitionException = any()

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
