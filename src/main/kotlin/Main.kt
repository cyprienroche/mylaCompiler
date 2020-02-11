import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File

fun main() {
    buildAST("src/main/resources/MylaCode.myla")
}

fun buildAST(path: String) {
    val input = fileToString(path)
    val stream = CharStreams.fromString(input)
    val lexer = MylaLexer(stream)
    val tokens = CommonTokenStream(lexer)
    val parser = MylaParser(tokens)
    val tree = parser.prog()
    println(tree.toStringTree(parser))
}

fun fileToString(fileName: String): String = File(fileName).readText(Charsets.UTF_8)