import java.util.ArrayList;
import java.util.List;

public class posiblesCombinaciones {
    public static void generarCombinaciones(String cadena, int index, StringBuilder actual, List<String> combinaciones) {
        if (index == cadena.length()) {
            combinaciones.add(actual.toString());
            return;
        }

        actual.append(Character.toLowerCase(cadena.charAt(index)));
        generarCombinaciones(cadena, index + 1, actual, combinaciones);
        actual.deleteCharAt(actual.length() - 1);

        actual.append(Character.toUpperCase(cadena.charAt(index)));
        generarCombinaciones(cadena, index + 1, actual, combinaciones);
        actual.deleteCharAt(actual.length() - 1); 
    }

    public static List<String> obtenerCombinaciones(String cadena) {
        List<String> combinaciones = new ArrayList<>();
        generarCombinaciones(cadena, 0, new StringBuilder(), combinaciones);
        return combinaciones;
    }

    public static void main(String[] args) {
        String cadena = "abc";
        List<String> combinaciones = obtenerCombinaciones(cadena);
        for (String combinacion : combinaciones) {
            System.out.println(combinacion);
        }
    }
}
