//comparativa de las listas
//arrayList vs linkedList

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;

public class pruebaListas {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        Random random = new Random();

        //Agregar elementos random a las listas
        //Medir el tiempo de ejecución
        long startTime, endTime;

        //Agregar a Arraylist;
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++){
            arrayList.add(random.nextInt());
        }
        endTime = System.nanoTime();
        System.out.println("Tiempo para agregar 100,000 elementos en arrayList: " + (endTime-startTime));

        //Agregar a linkedList;
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++){
            linkedList.add(random.nextInt());
        }
        endTime = System.nanoTime();
        System.out.println("Tiempo para agregar 100,000 elementos en linkedList: " + (endTime-startTime));

        //Comparar array
        System.out.println("Acceso a 100 elementos aleatorios");
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++){
            arrayList.get(random.nextInt(100000));
        }
        endTime = System.nanoTime();
        System.out.println("Tiempo de acceso aleatorio: " + (endTime-startTime));

        //Comparar linked
        System.out.println("Acceso a 100 elementos aleatorios");
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++){
            linkedList.get(random.nextInt(100000));
        }
        endTime = System.nanoTime();
        System.out.println("Tiempo de acceso aleatorio: " + (endTime-startTime));

        //Prueba inserciones (aleatorias/en medio)
        //ArrayList
        startTime=System.nanoTime();
        for (int i = 0; i < 100; i++){
            arrayList.add(random.nextInt(100000), random.nextInt());
        }
        endTime = System.nanoTime();
        System.out.println("Para Arraylist: " + (endTime-startTime));

        //Prueba inserciones (aleatorias/en medio)
        //LinkedList
        startTime=System.nanoTime();
        for (int i = 0; i < 100; i++){
            linkedList.add(random.nextInt(100000), random.nextInt());
        }
        endTime = System.nanoTime();
        System.out.println("Para Linkedlist: " + (endTime-startTime));

        //Eliminaciones (en medio/aleatorias
        System.out.println("------------------");
        //ArrayList
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++){
            arrayList.remove(random);
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList tardó: " + (endTime-startTime));

        //LinkedList
        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++){
            linkedList.remove(random);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList tardó: " + (endTime-startTime));

        //Termina main
    }
}
