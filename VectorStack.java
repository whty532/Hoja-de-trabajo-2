import java.util.Arrays;
import java.util.EmptyStackException;

public class VectorStack<T> implements IStack<T> {

    private T[] data;
    private int top;

    public VectorStack() {
        data = (T[]) new Object[10];
        top = 0;
    }

    @Override
    public void push(T value) {
        if (top == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[top++] = value;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = data[--top];
        data[top] = null;
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public void clear() {
        top = 0;
    }
}