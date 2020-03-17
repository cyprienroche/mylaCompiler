import frontend.ParseTreeGen
import frontend.errors.SyntaxErrorException
import frontend.errors.SyntaxErrorListener
import java.io.File
import kotlin.system.exitProcess

fun main() {
    val path = "src/main/resources/example.myla"

    val input = File(path)

    if (!input.isFile || input.extension != "myla") {
        println("Error: incorrect file path or file format supplied.")
        return
    }

    try {
        generateAst(path)
    } catch (e: SyntaxErrorException) {
        println(e.message())
        exitProcess(e.errorCode)
    }
}

fun generateAst(fileName: String) {
    val syntaxErrorListener = SyntaxErrorListener()
    val tree = ParseTreeGen(fileName, syntaxErrorListener).parseTree()

    if (syntaxErrorListener.errors.isNotEmpty()) {
        throw SyntaxErrorException(syntaxErrorListener.errors)
    }

    println(tree.toStringTree())
}
