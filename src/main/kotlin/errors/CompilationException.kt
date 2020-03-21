package errors

import java.lang.Exception

class CompilationException(val error: Error, private val errors: List<CompilationError>) : Exception() {
    fun message(): String = "Errors detected during compilation. Exit ${error.code}.\n" + errors.joinToString("\n") { it.message }
}
