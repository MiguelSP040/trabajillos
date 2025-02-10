import java.lang.reflect.Array;

public class ArrayUtils {
    public static <T> void print2(T[] A){
        for (int i = 0; i < A.length; i++){
            System.out.print(A[i] + ", ");
        }
        System.out.println("\n");
    }

    public static <T> void print(T[] A){
        System.out.println("Desglose del arreglo: ");
        for (int i = 0; i < A.length; i++){
            System.out.println(A[i]);
        }
    }

    public static <T> void delete(T[] A, int index){
        //Checar que el indice a partir este dentro de A
        if (index < 0 || index > (A.length-1)){
            throw new IllegalArgumentException("El indice no está dentro de A");
        }
        A[index] = null;
        print2(A);
    }

    public static <T> void update(T[] A, int index, T data){
        //Checar que el indice a partir este dentro de A
        if (index < 0 || index > (A.length-1)){
            throw new IllegalArgumentException("El indice no está dentro de A");
        }
        A[index] = data;
        print2(A);
    }

    @SuppressWarnings("unchecked")
    public static  <T> T[] delete2(T[] A, int index){
        Class<?> tipoDato  = A.getClass().getComponentType();
        T[] B = (T[]) Array.newInstance(tipoDato, A.length-1);

        //Copiar los elementos desde 0 hasta index
        int contador = 0;
        for (int i = 0; i < index; i ++){
            B[i] = A[i];
            contador++;
        }

        System.out.println("Mi contador es: " + contador);
        int contador2 = 0;

        //Copiar los elementos restantes
        for (int i = index; i < A.length; i++){
            B[i] = A[i];
            contador2++;
        }

        System.out.println("Mi contador dos es: " + contador);
        return B;
    }

    @SuppressWarnings("unchecked")
    public static  <T> T[] add2(T[] A, int index, T data){
        Class<?> tipoDato  = A.getClass().getComponentType();
        T[] B = (T[]) Array.newInstance(tipoDato, A.length +1);

        //Copiar los elementos desde 0 hasta index
        for (int i = 0; i < index; i ++){
            B[i] = A[i];
        }
        //Agregar el nuevo elemento
        B[index] = data;
        //Copiar los elementos restantes
        for (int i = index; i < A.length; i++){
            B[i+1] = A[i];
        }

        return B;
    }

    public static <T> void add(T[] A, int index, T data){
        //Checar que el indice a partir este dentro de A
        if (index < 0 || index > (A.length-1)){
            throw new IllegalArgumentException("El indice no está dentro de A");
        }

        A[index] = data;
    }

    public static <T> void split(T[] A, int index, T[] B, T[] C){
        //Checar que mis arreglos sean del mismo tipo
        if (!A.getClass().equals(B.getClass()) &&
            !A.getClass().equals(C.getClass())){
            throw new IllegalArgumentException("Los arreglos no son compatibles");
        }
        //Checar que el indice a partir este dentro de A
        if (index < 0 || index > A.length){
            throw new IllegalArgumentException("El indice no está dentro de A");
        }

        for (int i = 0; i < index; i++){
            B[i] = A[i];
        }

        for (int i = index; i < A.length; i++){
            C[i - index] = A[i];
        }
    }

    public static <T> void merge(T[] A, T[] B, T[] C){
        //Verifica si ambos arreglos son del mismo tipo
        if (!A.getClass().equals(B.getClass())){
            throw new IllegalArgumentException("Los arreglos no son del mismo tipo");
        }
        //Copiar elementos del arreglo A a C
        for (int i = 0; i < A.length; i++){
            C[i] = A[i];
        }
        //Copiar elementos del arreglo B a C
        for (int i = A.length; i < A.length + B.length; i++){
            C[i] = B[i - A.length];
        }
    }



    public static void main(String[] args) {
        //Apartado merge
        Integer[] A = {1, 2, 3};
        Integer[] B = {9, 10, 11, 13};
        Integer[] C = new Integer[5];
/*
        merge(A,B,C);

        for (Integer elemento : C){
            System.out.println(elemento);
        }

        //Apartado split
        System.out.println("APARTADO SPLIT");
        Integer[] D = new Integer[1];
        Integer[] E = new Integer[4];

        split(C, 1, D, E);

        System.out.println("\n" + D[0]);

        //Apartado add
        System.out.println("APARTADO ADD");
        System.out.println("Agregar un nuevo dato");
        System.out.println(E[3]);

        add(E, 3, 120);

        System.out.println(E[3]);

        //Apartado add 2
        System.out.println("APARTADO ADD2");
        A = add2(A, 3,99);
        for (Integer n : A){
            System.out.println(n + "");
        }
        //Apartado print
        System.out.println("APARTADO PRINT");
        print(A);

        //Apartado delete
        System.out.println("APARTADO DELETE");
        delete(A, 2);
        */
        //Apartado delete2
        System.out.println("APARTADO DELETE2");
        System.out.println("Arreglo antes: ");
        print2(B);
        delete2(B,1);
        System.out.println("Arreglo despues: ");
        print2(B);
        /*
        //Apartado update
        System.out.println("APARTADO UPDATE");
        Integer[] D = {3, 5, 8};
        System.out.println("Arreglo antes: ");
        print2(D);
        System.out.println("Arreglo después");
        update(D, 2, 1000);*/
    }
}
