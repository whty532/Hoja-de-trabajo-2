public class PostfixCalculator implements IPostfixCalculator {

    private IStack<Integer> stack;

    public PostfixCalculator(IStack<Integer> stack) {
        this.stack = stack;
    }

    @Override
    public int evaluate(String expression) {
        stacj.clear();
        String[] tokens = expresion.split("");
        for(String token : tokens) {
            if(token.matches("\\d+")) {
                stack.push(Integer.parseInt(token));
            }

            else if("+-*/%".contains(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Insuficientes operandos para operar");
                }
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;

                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        if (b == 0)
                            throw new ArithmeticException("División entre cero");
                        result = a / b;
                        break;
                    case "%":
                        if (b == 0)
                            throw new ArithmeticException("Módulo entre cero");
                        result = a % b;
                        break;
                }
                stack.push(result);
            }
            else {
                throw new IllegalArgumentException("Error: símbolo inválido -> " + token);
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Error: expresión inválida, sobran operandos");
        }
        return stack.pop();
    }
}