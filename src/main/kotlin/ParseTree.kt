
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree

class ParseTree(path: String) {
    private val lexer  = MylaLexer(CharStreams.fromFileName(path))
    private val tokens = CommonTokenStream(lexer)
    private val parser = MylaParser(tokens)

    fun getTree(): ParseTree = parser.prog()
}