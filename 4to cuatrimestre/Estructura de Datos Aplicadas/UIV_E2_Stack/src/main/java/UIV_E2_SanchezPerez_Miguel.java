import java.util.Stack;

public class UIV_E2_SanchezPerez_Miguel {

    public static Integer evaluateRPN(String[] sections) {
        Stack<Integer> stack = new Stack<>();

        for (String section : sections) {
            switch (section) {
                case "+":
                    if (stack.size() < 2) throw new IllegalArgumentException("Procedimiento inválido");
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    if (stack.size() < 2) throw new IllegalArgumentException("Procedimiento inválido");
                    Integer subtrahend = stack.pop();
                    stack.push(stack.pop() - subtrahend);
                    break;
                case "*":
                    if (stack.size() < 2) throw new IllegalArgumentException("Procedimiento inválido");
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    if (stack.size() < 2) throw new IllegalArgumentException("Procedimiento inválido");
                    Integer divisor = stack.pop();
                    if (divisor == 0) throw new ArithmeticException("División por cero");
                    stack.push(stack.pop() / divisor);
                    break;
                default:
                    stack.push(Integer.parseInt(section));
                    break;
            }
        }

        if (stack.size() != 1) throw new IllegalArgumentException("El tamaño no permite proceder con el procedimiento RPN");
        return stack.pop();
    }

    public static void main(String[] args) {
        //String[] arreglito = {"2", "1","+", "3", "*"};
        //String[] arreglito = {"4", "13","5", "/", "+"};
        String[] arreglito = {"10", "6","9", "3", "+", "-11", "*","/", "*", "17", "+", "5","+"};
        System.out.print("Arreglo original: ");
        for (String section : arreglito) {
            System.out.print(section + " ");
        }
        System.out.println();

        try {
            Integer result = evaluateRPN(arreglito);
            System.out.println("Resultado: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
