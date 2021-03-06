
import errors.Error.Syntax
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.itsallcode.junit.sysextensions.AssertExit.assertExitWithStatus
import org.itsallcode.junit.sysextensions.ExitGuard
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(ExitGuard::class)
class MainTest {

    private val outContent = ByteArrayOutputStream()
    private val originalOut = System.out

    @BeforeEach
    fun setupStreams() {
        System.setOut(PrintStream(outContent))
    }

    @AfterEach
    fun restoreStreams() {
        System.setOut(originalOut)
    }

    private val validProgram = "src/test/resources/valid/assign.myla"
    private val invalidSyntaxProgram = "src/test/resources/invalid/assignBracket.myla"
    private val invalidFile = "src/test/resources/invalid"

    @Test
    internal fun validProgramCompiles() {
        main(arrayOf(validProgram))
    }

    @Test
    internal fun invalidSyntaxCauseExitAndPrintMessage() {
        assertExitWithStatus(Syntax.code) { main(arrayOf(invalidSyntaxProgram)) }
        val output = outContent.toString()
        assertTrue(output.contains("Exit"))
        assertTrue(output.contains("Syntax Error"))
    }

    @Test
    internal fun invalidFileCauseExitAndPrintMessage() {
        assertExitWithStatus(1) { main(arrayOf(invalidFile)) }
    }

    @Test
    internal fun canTellIfFileIsValid() {
        assertTrue(isValidFile(arrayOf(validProgram)))
        assertTrue(isValidFile(arrayOf(invalidSyntaxProgram)))
        assertFalse(isValidFile(arrayOf(invalidFile)))
        assertFalse(isValidFile(arrayOf()))
    }
}
