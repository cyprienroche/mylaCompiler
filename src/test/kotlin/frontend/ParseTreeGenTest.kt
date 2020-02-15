package frontend

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.antlr.v4.runtime.ANTLRErrorListener
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class ParseTreeGenTest {

    private val listener = mock<ANTLRErrorListener> {}

    @Test
    fun getCorrectParseTreeForIntegerLiteral() {
        val parseTree = ParseTreeGen("src/test/resources/int.myla", listener)
        assertThat(parseTree.parseTreeString(), `is`("(prog (stat (expr (literal 1))) <EOF>)"))
    }

    @Test
    fun getCorrectParseTreeForIntegerAssignment() {
        val parseTree = ParseTreeGen("src/test/resources/assign.myla", listener)
        assertThat(parseTree.parseTreeString(), `is`("(prog (stat (identifier x) = (expr (literal 73))) <EOF>)"))
    }

    @Test
    fun wrong() {
        val parseTree = ParseTreeGen(
            "src/test/resources/invlid.myla", listener
        )
        parseTree.parseTreeString()
        verify(listener).syntaxError(
            any(),
            any(),
            eq(1),
            eq(5),
            eq("mismatched input '<EOF>' expecting {NAT, '-', '+', '('}"),
            any()
        )
    }
}
