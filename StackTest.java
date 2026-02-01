import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StackTest {

    @Test
    public void testPushPop() {
        IStack<Integer> stack = new VectorStack<>();

        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    public void testIsEmpty() {
        IStack<Integer> stack = new VectorStack<>();
        assertTrue(stack.isEmpty());
    }
}
