public class PostfixCalculator implements IPostfixCalculator {

    private IStack<Integer> stack;

    public PostfixCalculator(IStack<Integer> stack) {
        this.stack = stack;
    }

    @Override
    public int evaluate(String expression) {
        stack.clear();
        String[] tokens = expression.trim().split("\\s+");

for (String token : tokens) {
    token = token.trim();
    if (token.isEmpty()) continue;

    if (token.matches("\\d+")) {
        stack.push(Integer.parseInt(token));
    } else if (token.equals("+") || token.equals("-") || token.equals("*")
            || token.equals("/") || token.equals("%")) {

        if (stack.size() < 2) {
            throw new IllegalArgumentException("Operandos insuficientes para: " + token);
        }

        int b = stack.pop();
        int a = stack.pop();

        int result;
        switch (token) {
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "*": result = a * b; break;
            case "/":
                if (b == 0) throw new ArithmeticException("Division entre cero");
                result = a / b;
                break;
            case "%":
                if (b == 0) throw new ArithmeticException("Modulo entre cero");
                result = a % b;
                break;
            default:
                throw new IllegalArgumentException("Operador invalido: " + token);
        }

        stack.push(result);

    } else {
        throw new IllegalArgumentException("Simbolo invalido -> [" + token + "]");
    }
}

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expresion invalida");
        }

        return stack.pop();
    }
}