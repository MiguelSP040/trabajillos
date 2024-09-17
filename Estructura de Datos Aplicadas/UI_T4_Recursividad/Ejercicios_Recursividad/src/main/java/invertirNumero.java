public class invertirNumero {
    public static String invertir(int numero) {
        String cadena = Integer.toString(numero);
        if (cadena.length() == 1) {
            return cadena;
        }
        return invertir(Integer.parseInt(cadena.substring(1))) + cadena.charAt(0);
    }

    public static void main(String[] args) {
        int entrada = 1234;
        String salidaInvertida = invertir(entrada);
        int salida = Integer.parseInt(salidaInvertida);

        System.out.println("El valor base es: " + entrada);
        System.out.println("El valor invertido es: " + salida);
    }
}
