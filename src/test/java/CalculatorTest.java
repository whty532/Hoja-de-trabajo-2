import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private IPostfixCalculator calc;

    @BeforeEach
    public void setUp() {
        IStack<Integer> stack = new VectorStack<>();
        calc = new PostfixCalculator(stack);
    }

    @Test
    public void testExpression1() {
        assertEquals(15, calc.evaluate("1 2 + 4 * 3 +"));
    }

    @Test
    public void testExpression2() {
        assertEquals(30, calc.evaluate("6 2 3 + *"));
    }

    @Test
    public void testSubtraction() {
        assertEquals(3, calc.evaluate("10 7 -"));
    }

    @Test
    public void testDivision() {
        assertEquals(5, calc.evaluate("20 4 /"));
    }

    @Test
    public void testModulo() {
        assertEquals(1, calc.evaluate("10 3 %"));
    }

    @Test
    public void testMultipleOperations() {
        assertEquals(14, calc.evaluate("5 1 2 + 4 * + 3 -"));
    }

    @Test
    public void testSingleNumber() {
        assertEquals(42, calc.evaluate("42"));
    }

    @Test
    public void testMultiDigitNumbers() {
        assertEquals(111, calc.evaluate("100 11 +"));
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calc.evaluate("10 0 /"));
    }

    @Test
    public void testModuloByZero() {
        assertThrows(ArithmeticException.class, () -> calc.evaluate("10 0 %"));
    }

    @Test
    public void testInvalidSymbol() {
        assertThrows(IllegalArgumentException.class, () -> calc.evaluate("1 2 @"));
    }

    @Test
    public void testInvalidCharacter() {
        assertThrows(IllegalArgumentException.class, () -> calc.evaluate("1 a +"));
    }

    @Test
    public void testInsufficientOperands() {
        assertThrows(IllegalArgumentException.class, () -> calc.evaluate("1 +"));
    }

    @Test
    public void testInsufficientOperandsSingleOperator() {
        assertThrows(IllegalArgumentException.class, () -> calc.evaluate("+"));
    }

    @Test
    public void testInvalidExpressionTooManyOperands() {
        assertThrows(IllegalArgumentException.class, () -> calc.evaluate("1 2 3 +"));
    }

    @Test
    public void testNonCommutativeSubtraction() {
        assertEquals(2, calc.evaluate("5 3 -"));
    }

    @Test
    public void testNonCommutativeDivision() {
        assertEquals(5, calc.evaluate("10 2 /"));
    }
}
