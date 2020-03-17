package frontend.errors

import java.lang.Exception

sealed class ProgramErrorException(private val errors: List<ProgramError>, val errorCode: Int) : Exception() {
    fun message(): String =
        "Errors detected during compilation. Exit $errorCode.\n" +
            errors.joinToString("\n")
}

class SyntaxErrorException(errors: List<SyntaxError>) : ProgramErrorException(errors, 100)

class SemanticErrorException(errors: List<SemanticError>) : ProgramErrorException(errors, 200)
