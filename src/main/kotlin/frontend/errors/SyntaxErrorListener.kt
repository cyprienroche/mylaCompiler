package frontend.errors

import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer

class SyntaxErrorListener : BaseErrorListener() {

    val errors = mutableListOf<SyntaxError>()

    override fun syntaxError(
        recognizer: Recognizer<*, *>?,
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String?,
        e: RecognitionException?
    ) {
        val err = SyntaxError(line to charPositionInLine, msg.toString())
        errors.add(err)
    }
}
