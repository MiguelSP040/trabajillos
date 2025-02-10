import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class UIV_E3_SanchezPerez_Miguel {

    public static void main(String[] args) {
        System.out.println("Prueba de lectura: ");

        // Especifica la ruta de tu archivo aquí
        String ruta = "ecuaciones.txt";
        ArrayList<String> expresiones = obtenerLineas(ruta);

        for (String expresion : expresiones) {
            System.out.println(expresion);
            validarExpresion(expresion);
        }
    }

    public static void validarExpresion(String expresion) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expresion.length(); i++) {
            char ch = expresion.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    System.out.println("Error: Hay un símbolo de cierre sin un correspondiente símbolo de apertura en la posición " + i);
                    return;
                }
                char top = stack.pop();
                if (!esPar(top, ch)) {
                    System.out.println("Error: Los símbolos no coinciden en la posición " + i);
                    return;
                }
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("Error: Faltan cerrar símbolos en la expresión.");
        } else {
            System.out.println("La expresión está balanceada.");
        }
    }

    private static boolean esPar(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
                (apertura == '[' && cierre == ']') ||
                (apertura == '{' && cierre == '}');
    }

    public static ArrayList<String> obtenerLineas(String ruta) {
        ArrayList<String> contenido = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido;
    }
}
