package frontend

import generated.MylaLexer
import generated.MylaParser
import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree

class ParseTree(path: String, lexerListener: BaseErrorListener, parserListener: BaseErrorListener) {
    private val lexer = MylaLexer(CharStreams.fromFileName(path))
    private val tokens = CommonTokenStream(lexer)
    private val parser = MylaParser(tokens)

    init {
        lexer.removeErrorListeners()
        lexer.addErrorListener(lexerListener)

        parser.removeErrorListeners()
        parser.addErrorListener(parserListener)
    }

    fun getParseTree(): ParseTree = parser.prog()

    override fun toString(): String = getParseTree().toStringTree(parser)
}
