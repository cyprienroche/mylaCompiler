package errors

import java.lang.Exception

class FrontendErrorException(val error: Error, private val errors: List<FrontendError>) : Exception() {
    fun message(): String = "Errors detected during compilation. Exit ${error.code}.\n" + errors.joinToString("\n") { it.message }
}
