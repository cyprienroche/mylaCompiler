import errors.FrontendErrorException
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (!isValidFile(args)) exitProcess(1)

    try {
        generateAst(args[0])
    } catch (e: FrontendErrorException) {
        println(e.message())
        exitProcess(e.error.code)
    }
}
