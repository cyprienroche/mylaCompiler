package frontend

import com.nhaarman.mockitokotlin2.atLeastOnce
import com.nhaarman.mockitokotlin2.never
import frontend.mock.MockParser
import frontend.mock.SyntaxError
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("Parsing valid and invalid programs")
class ParseTreeGenTest {

    @DisplayName("Parsing valid and invalid expressions")
    internal class ExpressionParsingTest {

        @ParameterizedTest
        @CsvSource("1", "2", "-1", "+123", "--3")
        internal fun validInteger(input: String) {
            val mock = MockParser(input)
            mock.parseExpression()
            SyntaxError(mock.listener, never()).verify()
        }

        @ParameterizedTest
        @CsvSource("(", "x", "-1i", "c3p0")
        internal fun invalidInteger(input: String) {
            val mock = MockParser(input)
            mock.parseExpression()
            SyntaxError(mock.listener, atLeastOnce()).verify()
        }
    }
}
