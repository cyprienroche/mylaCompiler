package frontend.visitor

import com.nhaarman.mockitokotlin2.mock
import frontend.ParseTreeGenerator
import org.antlr.v4.runtime.ANTLRErrorListener
import org.junit.jupiter.api.Test
import visitor.ProgramTreeVisitor

class VisitorTest {

    private val listener = mock<ANTLRErrorListener> {}
    private val validProgramPath = "src/test/resources/valid"

    @Test
    internal fun canVisitBasicProgram() {
        val parseTree = ParseTreeGenerator("$validProgramPath/assign.myla", listener).parseTree()
        val programTree = parseTree.accept(ProgramTreeVisitor())
    }
}
