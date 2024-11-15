import junit.framework.TestCase;

public class OperacionesTest extends TestCase {
    Operaciones instancia = new Operaciones();

    //Configurado para pasar
    public void testSumarNumeros(){
        System.out.println("Test 1: Suma de números");
        int a = 5;
        int b = 3;
        int R_Esperado = 8;
        int R_Actual = instancia.sumaNumero(a,b);
        assertEquals(R_Actual, R_Esperado);
    }

    //Configurado para pasar
    public void testRestarNumeros(){
        System.out.println("Test 2: Resta de números");
        int a = 10;
        int b = 5;
        int resultadoEsperado = 2;
        int resultadoActual = instancia.restaNumero(a, b);
        assertEquals(resultadoActual, resultadoEsperado);
    }

    //Configurado para fallar
    public void testMultiplicarNumeros(){
        System.out.println("Test 3: Multiplicación de números");
        int a = 8;
        int b = 4;
        int resultadoEsperado = 32;
        int resultadoActual = instancia.multiplicacionNumero(a, b);
        assertEquals(resultadoActual, resultadoEsperado);
    }

    //Configurado para fallar
    public void testDividirNumeros(){
        System.out.println("Test 4: División de números");
        int a = 20;
        int b = 2;
        int resultadoEsperado = 20;
        int resultadoActual = instancia.dividirNumero(a, b);
        assertEquals(resultadoActual, resultadoEsperado);
    }
}