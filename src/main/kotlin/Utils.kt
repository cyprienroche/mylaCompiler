import errors.CompilationError
import errors.CompilationException
import errors.Error.Semantic
import errors.Error.Syntax
import errors.ErrorListener
import errors.SyntaxErrorListener
import java.io.File

fun generateAst(fileName: String) {
    val syntaxListener = ErrorListener<CompilationError>()
    val tree = generateProgramParseTree(fileName, SyntaxErrorListener(syntaxListener))

    if (syntaxListener.hasErrors) throw CompilationException(Syntax, syntaxListener.errors)
    val semanticsListener = ErrorListener<CompilationError>()
    if (syntaxListener.hasErrors) throw CompilationException(Syntax, syntaxListener.errors)
    if (semanticsListener.hasErrors) throw CompilationException(
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
