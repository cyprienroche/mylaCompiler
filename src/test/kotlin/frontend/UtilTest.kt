package frontend

import frontend.errors.Error.Syntax
import frontend.errors.FrontendErrorException
import generateAst
import isValidFile
import main
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UtilTest {

    private val validProgram = "src/test/resources/valid/assign.myla"
    private val invalidProgram = "src/test/resources/invalid/assignBracket.myla"
    private val invalidFile = "src/test/resources/invalid"

    @Test
    internal fun passValidProgramCompiles() {
        main(arrayOf(validProgram))
    }

    @Test
    internal fun canTellIfFileIsValid() {
        assertTrue(isValidFile(arrayOf(validProgram)))
        assertTrue(isValidFile(arrayOf(invalidProgram)))
        assertFalse(isValidFile(arrayOf(invalidFile)))
        assertFalse(isValidFile(arrayOf()))
    }

    @Test
    internal fun generateAstForValidProgram() {
        generateAst(validProgram)
    }

    @Test
    internal fun generateAstForInvalidProgramThrowsException() {
        assertThrows<FrontendErrorException> { generateAst(invalidProgram) }
    }

    @Test
    internal fun generateAstGivesCorrectErrorAndExitCode() {
        try {
            generateAst(invalidProgram)
        } catch (e: FrontendErrorException) {
            assertThat(e.error, `is`(Syntax))
            assertThat(e.error.code, `is`(100))
            assertTrue(e.message().contains("${e.error.code}"))
        }
    }
}
