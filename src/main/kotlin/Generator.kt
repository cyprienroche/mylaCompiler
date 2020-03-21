import generated.MylaLexer
import generated.MylaParser
import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree

fun generateParser(path: String, listener: ANTLRErrorListener): MylaParser {
    val stream = CharStreams.fromFileName(path)
    val lexer = MylaLexer(stream)
    val tokens = CommonTokenStream(lexer)
    val parser = MylaParser(tokens)

    lexer.removeErrorListeners()
    lexer.addErrorListener(listener)

    parser.removeErrorListeners()
    parser.addErrorListener(listener)

    return parser
}

fun generateParseTree(parser: MylaParser): ParseTree =
    parser.prog()

fun generateParseTree(path: String, listener: ANTLRErrorListener): ParseTree =
    generateParseTree(generateParser(path, listener))
