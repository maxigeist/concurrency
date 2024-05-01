import java.util.function.Supplier;

public class MathThread<T> extends Thread {
    private final Supplier<T> expression;
    private T result;

    public MathThread(Supplier<T> expression) {
        this.expression = expression;
    }

    public void run() { result = expression.get(); }

    public T getValue() { return result; }
}