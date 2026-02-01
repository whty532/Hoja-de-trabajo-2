import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testExpression1() {
        IStack<Integer> stack = new VectorStack<>();
        IPostfixCalculator calc = new PostfixCalculator(stack);

        assertEquals(15, calc.evaluate("1 2 + 4 * 3 +"));
    }

    @Test
    public void testExpression2() {
        IStack<Integer> stack = new VectorStack<>();
        IPostfixCalculator calc = new PostfixCalculator(stack);

        assertEquals(30, calc.evaluate("6 2 3 + *"));
    }
}
