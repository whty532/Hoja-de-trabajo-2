import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        try {

            BufferedReader reader = new BufferedReader(
                new FileReader("datos.txt")
            );

            String line;

            // Cambiable: puedes usar otra pila sin afectar el programa
            IStack<Integer> stack = new VectorStack<>();
            IPostfixCalculator calc = new PostfixCalculator(stack);

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                try {
                    int result = calc.evaluate(line);
                    System.out.println("Expresión: " + line);
                    System.out.println("Resultado: " + result);
                    System.out.println("------------------------");

                } catch (Exception e) {
                    System.out.println("Error evaluando: " + line);
                    System.out.println(e.getMessage());
                    System.out.println("------------------------");
                }
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error leyendo archivo datos.txt");
            e.printStackTrace();
        }
    }
}