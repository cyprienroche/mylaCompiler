package src.test.kotlin

import ParseTree
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class ParseTreeTest {

    @Test
    fun getCorrectParseTreeForIntegerLiteralOnly() {
        val parseTree = ParseTree("src/test/resources/int.myla")
        assertThat(parseTree.toString(), `is`("(prog (stat (expr (literal 1))) <EOF>)"))
    }

    @Test
    fun getCorrectParseTreeForIntegerAssignment() {
        val parseTree = ParseTree("src/test/resources/assign.myla")
        assertThat(parseTree.toString(), `is`("(prog (stat (identifier x) = (expr (literal 73))) <EOF>)"))
    }
}
