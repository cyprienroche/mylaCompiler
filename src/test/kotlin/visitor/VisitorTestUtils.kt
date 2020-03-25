package visitor

import com.nhaarman.mockitokotlin2.mock
import generateParser
import generated.MylaParser
import org.antlr.v4.runtime.ANTLRErrorListener
import org.antlr.v4.runtime.CharStreams

class VisitorTestUtils {
    companion object {
        private val listener = mock<ANTLRErrorListener> {}
        private val validProgramPath = "src/test/resources/valid"

        fun parseTree(fileName: String): MylaParser =
            generateParser(CharStreams.fromFileName("$validProgramPath/$fileName.myla"), listener)
    }
}
