import errors.Error.Semantic
import errors.Error.Syntax
import errors.ErrorListener
import errors.FrontendError
import errors.FrontendErrorException
import errors.SyntaxErrorListener
import java.io.File

fun generateAst(fileName: String) {
    val syntaxListener = ErrorListener<FrontendError>()
    val tree = generateParseTree(fileName, SyntaxErrorListener(syntaxListener))

    if (syntaxListener.hasErrors) throw FrontendErrorException(Syntax, syntaxListener.errors)
    val semanticsListener = ErrorListener<FrontendError>()
    if (syntaxListener.hasErrors) throw FrontendErrorException(Syntax, syntaxListener.errors)
    if (semanticsListener.hasErrors) throw FrontendErrorException(
        Semantic,
        semanticsListener.errors
    )
}

fun isValidFile(args: Array<String>): Boolean {
    if (args.isEmpty()) {
        println("No arguments provided. Please provide the path to a .myla file. Aborting compilation")
        return false
    }

    val input = File(args[0])

    if (!input.isFile || input.extension != "myla") {
        println("The file ${input.name} is not a valid .myla file. Aborting compilation")
        return false
    }

    return true
}
