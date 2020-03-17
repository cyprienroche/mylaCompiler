import frontend.errors.FrontendErrorException
import kotlin.system.exitProcess

fun main() {
    val path = "src/main/resources/example.myla"
    if (!isValidFile(path)) return

    try {
        generateAst(path)
    } catch (e: FrontendErrorException) {
        println(e.message())
        exitProcess(e.error.code)
    }
}
