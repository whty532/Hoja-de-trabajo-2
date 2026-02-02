import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;

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

    @Test
    public void testIsEmptyAfterPush() {
        IStack<Integer> stack = new VectorStack<>();
        stack.push(5);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPeek() {
        IStack<Integer> stack = new VectorStack<>();
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.peek());
        assertEquals(20, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    public void testSize() {
        IStack<Integer> stack = new VectorStack<>();
        assertEquals(0, stack.size());

        stack.push(1);
        assertEquals(1, stack.size());

        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());

        stack.pop();
        assertEquals(2, stack.size());
    }

    @Test
    public void testClear() {
        IStack<Integer> stack = new VectorStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.clear();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testPopEmptyStack() {
        IStack<Integer> stack = new VectorStack<>();
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    public void testPeekEmptyStack() {
        IStack<Integer> stack = new VectorStack<>();
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }

    @Test
    public void testDynamicResize() {
        IStack<Integer> stack = new VectorStack<>();
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        assertEquals(15, stack.size());
        assertEquals(14, stack.pop());
    }
}