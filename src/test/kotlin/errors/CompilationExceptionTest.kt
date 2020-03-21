package errors

import errors.Error.Syntax
import generateAst
import java.io.File
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CompilationExceptionTest {

    private fun getAllFilesIn(directory: String): List<String> =
        File(directory).listFiles()?.filter { it.extension == "myla" }?.map { it.absolutePath } ?: emptyList()

    @Test
    internal fun acceptValidProgram() {
        val validPrograms = "src/test/resources/valid"
        getAllFilesIn(validPrograms).forEach { generateAst(it) }
    }

    @Test
    internal fun throwErrorInvalidProgram() {
        val invalidPrograms = "src/test/resources/invalid"
        getAllFilesIn(invalidPrograms).forEach {
            assertThrows<CompilationException> { generateAst(it) }
        }
    }

    @Test
    internal fun throwCorrectErrorInvalidProgram() {
        val invalidPrograms = "src/test/resources/invalid"
        getAllFilesIn(invalidPrograms).forEach {
            try {
                generateAst(it)
            } catch (e: CompilationException) {
                assertThat(e.error, `is`(Syntax))
                assertThat(e.error.code, `is`(100))
                assertTrue(e.message().contains("${e.error.code}"))
            }
        }
    }
}
