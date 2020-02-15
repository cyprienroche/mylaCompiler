import frontend.ParseTree
import frontend.errors.MylaErrorListener

fun main() {
    val path = "src/main/resources/Example.myla"
    val lexerListener = MylaErrorListener()
    val parserListener = MylaErrorListener()

    val parseTree = ParseTree(path, lexerListener, parserListener)
    val tree = parseTree.getParseTree()

    if (lexerListener.errors.isNotEmpty() || parserListener.errors.isNotEmpty()) {
        lexerListener.errors.forEach { println(it) }
        parserListener.errors.forEach { println(it) }
        println("${parserListener.errors.size} parser error(s) detected, no further compilation attempted.")
        return
    }
    println(parseTree.toString())
}
