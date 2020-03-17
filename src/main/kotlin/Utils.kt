import frontend.ParseTreeGenerator
import frontend.errors.Error.Semantic
import frontend.errors.Error.Syntax
import frontend.errors.ErrorListener
import frontend.errors.FrontendError
import frontend.errors.FrontendErrorException
import frontend.errors.SyntaxErrorListener
import java.io.File

fun generateAst(fileName: String) {
    val syntaxListener = ErrorListener<FrontendError>()
    val tree = ParseTreeGenerator(fileName, SyntaxErrorListener(syntaxListener))
    println(tree.parseTreeString())

    if (syntaxListener.hasErrors) throw FrontendErrorException(Syntax, syntaxListener.errors)
    val semanticsListener = ErrorListener<FrontendError>()
    if (syntaxListener.hasErrors) throw FrontendErrorException(Syntax, syntaxListener.errors)
    if (semanticsListener.hasErrors) throw FrontendErrorException(Semantic, semanticsListener.errors)

    // println(tree.toStringTree())
}

fun isValidFile(fileName: String): Boolean {
    val input = File(fileName)

    if (!input.isFile || input.extension != "myla") {
        println("Error: the file ${input.name} is not a valid .myla file.")
        return false
    }

    return true
}
