public class sumaDigitosPotencia {
    public static int sumarDigitos(int numero) {
        if (numero == 0) {
            return 0;
        }
        return (numero % 10) + sumarDigitos(numero / 10);
    }

    public static int sumaDigitosPotencia(int base, int potencia) {
        int resultado = (int) Math.pow(base, potencia);
        return sumarDigitos(resultado);
    }

    public static void main(String[] args) {
        int base = 2;
        int potencia = 10;
        int sumaDigitos = sumaDigitosPotencia(base, potencia);
        System.out.println("La suma de los dígitos de " + base + "^" + potencia + " es: " + sumaDigitos);
    }
}
