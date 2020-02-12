import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class ParseTree(path: String) {
    private val lexer = MylaLexer(CharStreams.fromFileName(path))
    private val tokens = CommonTokenStream(lexer)
    private val parser = MylaParser(tokens)

    fun getTree(): ParseTree = parser.prog()

    override fun toString(): String = "hi" /*getTree().toStringTree(parser)*/
}
