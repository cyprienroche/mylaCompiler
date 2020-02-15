package frontend.errors

import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer

class MylaErrorListener : BaseErrorListener() {

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

    override fun toString(): String = errors.fold("", { acc, item -> acc + item + '\n' })
}

data class SyntaxError(val position: Pair<Int, Int>, val msg: String) {
    override fun toString(): String = "Syntactic Error at ${position.first}:${position.second} -- $msg"
}
