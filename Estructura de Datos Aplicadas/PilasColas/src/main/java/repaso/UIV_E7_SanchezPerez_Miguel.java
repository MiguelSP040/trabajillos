package repaso;


import cola.Queue;

import java.util.Stack;

public class UIV_E7_SanchezPerez_Miguel {
    //Necesitamos hacer una pila de documentos
    //Meterlas en una cola
    //Imprimir los documentos en consola
    //Simulación de cola de impresión

    public static void main(String[] args) {
        //Vamos a simular que los departamentos tienen documentos
        //Los docuemtnos van en pilar
        Stack<String> dept1 = new Stack<>();
        Stack<String> dept2 = new Stack<>();
        Stack<String> dept3 = new Stack<>();

        //Agregar los archivos a imprimir
        dept1.push("Contrataciones Noviembre");
        dept1.push("Despidos de Octubre");
        dept1.push("Nóminas de Octubre");

        dept2.push("Inventario de equipos");
        dept2.push("Entradas y salidas de Noviembre");

        dept3.push("Itinerario de ponencias");
        dept3.push("Talleres de IA");
        dept3.push("Auditorias");

        //Debemos meter esas pilas a una cola
        //Donde el primero que llegue es la primera pila en imprimir
        Queue<Stack<String>> colaImpresion = new Queue<>();

        colaImpresion.offer(dept3);
        colaImpresion.offer(dept1);
        colaImpresion.offer(dept2);

        int size = colaImpresion.size();
        for (int i = 0; i<size; i++){
            //Iterar el stack
            int stackSize = colaImpresion.peek().size();
            System.out.println("Imprimiendo los documentos del departamento: ");
            for (int j = 0; j<stackSize; j++){
                System.out.println("Imprimiendo: " + colaImpresion.peek().pop());
            }
            colaImpresion.poll();
            System.out.println("Se han impreso todos los documentos del departamento");
        }
        System.out.println("Programa terminado");
    }
}
