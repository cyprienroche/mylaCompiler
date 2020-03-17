package frontend.errors

import frontend.errors.Error.Syntax
import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer

class SyntaxErrorListener(private val eventListener: EventListener<FrontendError>) : BaseErrorListener() {

    override fun syntaxError(
        recognizer: Recognizer<*, *>?,
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String?,
        e: RecognitionException?
    ) {
        val err = FrontendError(Syntax, line to charPositionInLine, msg.toString())
        eventListener.receive(err)
    }
}
