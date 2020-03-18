package frontend.errors

import generateAst
import java.io.File
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class FrontendErrorTest {

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
            assertThrows<FrontendErrorException> { generateAst(it) }
        }
    }
}
