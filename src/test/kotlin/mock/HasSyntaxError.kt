package mock

import com.nhaarman.mockitokotlin2.anyOrNull
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.mockito.verification.VerificationMode

class HasSyntaxError(mock: ANTLRErrorListener, mode: VerificationMode) {

    private val listener: ANTLRErrorListener = verify(mock, mode)
    private var recognizer: Recognizer<*, *>? = null
    private var offendingSymbol: Any? = null
    private var line: Int? = null
    private var charPosInLine: Int? = null
    private var msg: String? = null
    private var e: RecognitionException? = null

    fun withRecognizer(recognizer: Recognizer<*, *>): HasSyntaxError {
        this.recognizer = recognizer
        return this
    }

    fun withOffendingSymbol(offendingSymbol: Any): HasSyntaxError {
        this.offendingSymbol = offendingSymbol
        return this
    }

    fun withLine(line: Int): HasSyntaxError {
        this.line = line
        return this
    }

    fun withCharPositionInLine(charPosInLine: Int): HasSyntaxError {
        this.charPosInLine = charPosInLine
        return this
    }

    fun withMessage(msg: String): HasSyntaxError {
        this.msg = msg
        return this
    }

    fun withRecognitionException(e: RecognitionException): HasSyntaxError {
        this.e = e
        return this
    }

    fun verify() = listener.syntaxError(
        recognizerMatcher(),
        offendingMatcher(),
        lineMatcher(),
        charPosMatcher(),
        msgMatcher(),
        eMatcher()
    )

    private fun recognizerMatcher() = if (recognizer == null) anyOrNull() else eq(recognizer)

    private fun offendingMatcher() = if (offendingSymbol == null) anyOrNull() else eq(offendingSymbol)

    private fun lineMatcher() = if (line == null) anyOrNull() else eq(line) ?: anyOrNull()

    private fun charPosMatcher() = if (charPosInLine == null) anyOrNull() else eq(charPosInLine) ?: anyOrNull()

    private fun msgMatcher() = if (msg == null) anyOrNull() else eq(msg)

    private fun eMatcher() = if (e == null) anyOrNull() else eq(e)
}
