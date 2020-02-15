import frontend.ParseTreeGen
import frontend.errors.MylaErrorListener

fun main() {
    val path = "src/main/resources/Example.myla"
    val errorListener = MylaErrorListener()

    val tree = ParseTreeGen(path, errorListener).parseTree()

    if (errorListener.errors.isNotEmpty()) {
        print(errorListener)
        println("${errorListener.errors.size} parser error(s) detected, no further compilation attempted.")
        return
    }
    println(tree.toStringTree())
}
