import mock.MockParser
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ParserTest {

    internal class LiteralTest {

        @ParameterizedTest
        @ValueSource(strings = ["1", "-2", "+123"])
        fun validInteger(input: String) {
            val mock = MockParser(input)
            mock.parseLiteral().verifyValid()
        }

        @ParameterizedTest
        @ValueSource(strings = ["(", "-1i", "c3p0", "++3"])
        fun invalidInteger(input: String) {
            val mock = MockParser(input)
            mock.parseLiteral().verifyInvalid()
        }
    }

    internal class ExpressionTest {

        @ParameterizedTest
        @ValueSource(strings = ["1 + \n 1", "(2--3)", "1 * (3 + 2)", "+2-3*4/(+33+ \r - -3 + \t 10 ++5)"])
        fun validExpression(input: String) {
            val mock = MockParser(input)
            mock.parseArithmeticExpression().verifyValid()
        }

        @ParameterizedTest
        @ValueSource(strings = ["1 (2)", "x = 1", "+-10", "6+*4", "0invalid", "0 + "])
        fun invalidExpression(input: String) {
            val mock = MockParser(input)
            mock.parseArithmeticExpression().verifyInvalid()
        }
    }

    internal class AssignTest {

        @ParameterizedTest
        @ValueSource(strings = ["identifier", "Variable", "_value____0"])
        fun validLHSAssignment(input: String) {
            val mock = MockParser(input)
            mock.parseAssignLHS().verifyValid()
        }

        @ParameterizedTest
        @ValueSource(strings = ["1ident", "=var", "()", "+i"])
        fun invalidLHSAssignment(input: String) {
            val mock = MockParser(input)
            mock.parseAssignLHS().verifyInvalid()
        }
    }

    internal class StatementTest {

        @ParameterizedTest
        @ValueSource(strings = ["x = \n 2", "y = -z + \n \t 3", "if =  _value____0"])
        fun validStatement(input: String) {
            val mock = MockParser(input)
            mock.parseStatement().verifyValid()
        }

        @ParameterizedTest
        @ValueSource(strings = ["10 = x", "+z = z", "=p = 0", "()"])
        fun invalidStatement(input: String) {
            val mock = MockParser(input)
            mock.parseStatement().verifyInvalid()
        }
    }
}
