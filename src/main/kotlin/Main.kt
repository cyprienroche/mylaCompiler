import errors.CompilationException
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (!isValidFile(args)) exitProcess(1)

    try {
        generateAst(args[0])
    } catch (e: CompilationException) {
        println(e.message())
        exitProcess(e.error.code)
    }
}
