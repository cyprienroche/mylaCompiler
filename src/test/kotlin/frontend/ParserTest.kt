package frontend

import com.nhaarman.mockitokotlin2.atLeastOnce
import com.nhaarman.mockitokotlin2.never
import frontend.mock.MockParser
import frontend.mock.SyntaxError
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ParserTest {

    internal class LiteralTest {

        @ParameterizedTest
        @CsvSource("1", "-2", "+123")
        internal fun validInteger(input: String) {
            val mock = MockParser(input)
            mock.parseLiteral()
            SyntaxError(mock.listener, never()).verify()
        }

        @ParameterizedTest
        @CsvSource("(", "-1i", "c3p0", "++3")
        internal fun invalidInteger(input: String) {
            val mock = MockParser(input)
            mock.parseLiteral()
            SyntaxError(mock.listener, atLeastOnce()).verify()
        }
    }

    internal class ExpressionTest {

        @ParameterizedTest
        @CsvSource("1 + 1", "(2--3)", "1 * (3 + 2)", "+2-3*4/(+33+ \r - -3 + \t 10 ++5)")
        internal fun validExpression(input: String) {
            val mock = MockParser(input)
            mock.parseExpression()
            SyntaxError(mock.listener, never()).verify()
        }

        @ParameterizedTest
        @CsvSource("1 (2)", "x = 1", "--+-10", "6+*4", "0invalid")
        internal fun invalidExpression(input: String) {
            val mock = MockParser(input)
            mock.parseExpression()
            SyntaxError(mock.listener, atLeastOnce()).verify()
        }
    }

    internal class AssignTest {

        @ParameterizedTest
        @CsvSource("identifier", "Variable", "_value____0")
        internal fun validLHSAssignment(input: String) {
            val mock = MockParser(input)
            mock.parseAssignLHS()
            SyntaxError(mock.listener, never()).verify()
        }

        @ParameterizedTest
        @CsvSource("1ident", "=var", "()", "+i")
        internal fun invalidLHSAssignment(input: String) {
            val mock = MockParser(input)
            mock.parseAssignLHS()
            SyntaxError(mock.listener, atLeastOnce()).verify()
        }
    }

    internal class StatementTest {

        @ParameterizedTest
        @CsvSource("x = 2", "y = -z + \t 3", "if =  _value____0")
        internal fun validStatement(input: String) {
            val mock = MockParser(input)
            mock.parseStatement()
            SyntaxError(mock.listener, never()).verify()
        }

        @ParameterizedTest
        @CsvSource("10 = x", "+z = z", "=p = 0", "()")
        internal fun invalidStatement(input: String) {
            val mock = MockParser(input)
            mock.parseStatement()
            SyntaxError(mock.listener, atLeastOnce()).verify()
        }
    }
}
