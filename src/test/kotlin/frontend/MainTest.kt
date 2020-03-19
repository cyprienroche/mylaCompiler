package frontend

import frontend.errors.Error
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import main
import org.itsallcode.junit.sysextensions.AssertExit.assertExitWithStatus
import org.itsallcode.junit.sysextensions.ExitGuard
import org.junit.jupiter.api.AfterEach
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
    fun validProgramCompiles() {
        main(arrayOf(validProgram))
    }

    @Test
    fun invalidSyntaxCauseExitAndPrintMessage() {
        assertExitWithStatus(Error.Syntax.code) { main(arrayOf(invalidSyntaxProgram)) }
        val output = outContent.toString()
        assertTrue(output.contains("Exit"))
        assertTrue(output.contains("Syntax Error"))
    }

    @Test
    fun invalidFileCauseExitAndPrintMessage() {
        assertExitWithStatus(1) { main(arrayOf(invalidFile)) }
    }
}
