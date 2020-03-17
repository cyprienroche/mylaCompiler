import frontend.ParseTreeGen
import frontend.errors.ErrorListener
import frontend.errors.SemanticError
import frontend.errors.SemanticErrorException
import frontend.errors.SyntaxError
import frontend.errors.SyntaxErrorException
import frontend.errors.SyntaxErrorListener
import java.io.File

fun generateAst(fileName: String) {
    val syntaxListener = ErrorListener<SyntaxError>()
    val tree = ParseTreeGen(fileName, SyntaxErrorListener(syntaxListener)).parseTree()

    if (syntaxListener.hasErrors) throw SyntaxErrorException(syntaxListener.errors)
    val semanticsListener = ErrorListener<SemanticError>()
    if (syntaxListener.hasErrors) throw SyntaxErrorException(syntaxListener.errors)
    if (semanticsListener.hasErrors) throw SemanticErrorException(semanticsListener.errors)

    println(tree.toStringTree())
}

fun isValidFile(fileName: String): Boolean {
    val input = File(fileName)

    if (!input.isFile || input.extension != "myla") {
        println("Error: the file ${input.name} is not a valid .myla file.")
        return false
    }

    return true
}
