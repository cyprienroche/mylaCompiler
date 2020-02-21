package frontend

import generated.MylaLexer
import generated.MylaParser
import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree

class ParseTreeGen(path: String, listener: ANTLRErrorListener) {
    private val lexer = MylaLexer(CharStreams.fromFileName(path))
    private val tokens = CommonTokenStream(lexer)
    private val parser = MylaParser(tokens)

    init {
        lexer.removeErrorListeners()
        lexer.addErrorListener(listener)

        parser.removeErrorListeners()
        parser.addErrorListener(listener)
    }

    fun parseTree(): ParseTree = parser.prog()

    fun parseTreeString(): String = parser.prog().toStringTree(parser)
}
