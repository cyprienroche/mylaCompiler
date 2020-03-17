import frontend.errors.SyntaxErrorException
import kotlin.system.exitProcess

fun main() {
    val path = "src/main/resources/example.myla"
    if (!isValidFile(path)) return

    try {
        generateAst(path)
    } catch (e: SyntaxErrorException) {
        println(e.message())
        exitProcess(e.errorCode)
    }
}
