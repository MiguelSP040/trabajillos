package Ejercicio2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class ListaTareas {
    private static List<Tarea> listaTareas = new LinkedList<>();

    //1. Método par agregar tarea
    public void agregarTarea(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Descripción: ");
        String descripcion = sc.nextLine();
        System.out.println("Fecha: ");
        String fecha = sc.nextLine();
        System.out.println("¿La tarea está pendiente?");
        System.out.println("1. NO / 2. SI");
        int estado = sc.nextInt();
        boolean pendiente = true;
        if (estado == 1){
            pendiente = false;
        } if (estado == 2){
            pendiente = true;
        }else {
            System.out.println("¡ERROR! Opcion inexistente");
        }
        listaTareas.add(new Tarea(nombre, descripcion, fecha, pendiente));
    }

    //2. Verificar si una tarea esta en la lista y si esta pendiente
    public boolean ifExistIfPending(String nombre){
        for (Tarea tarea : listaTareas) {
            if (tarea.getNombre().equalsIgnoreCase(nombre)
                && tarea.isPendiente()) {
                return true;
            }
        }
        return false;
    }

    //3. Consultar el número de tareas pendientes
    public int tareasPendiente(){
        int contador = 0;
        for (Tarea tarea : listaTareas) {
            if (tarea.isPendiente()) {
                contador++;
            }
        }
        return contador;
    }

    //4. Eliminar una tarea
    public void eliminarTarea(String nombre){
        Tarea tareaEliminar = null;
        for (Tarea tarea : listaTareas) {
            if (tarea.getNombre().equalsIgnoreCase(nombre)) {
                tareaEliminar = tarea;
                break;
            }
        }

        if (tareaEliminar != null) {
            listaTareas.remove(tareaEliminar);
            System.out.println("Tarea eliminada: " + tareaEliminar.getNombre());
        } else {
            System.out.println("Tarea no encontrada");
        }
    }

    //5. Imprimir la lista de tareas
    public void imprimirTareas(){
        for (Tarea tarea : listaTareas){
            if (tarea.isPendiente()){
                System.out.println(tarea);
            }
        }
    }

    //6. Limpiar la lista
    public void limpiarLista(){
        System.out.println("/LIMPIANDO LA LISTA...");
        listaTareas.clear();
    }

    //7. Cambiar el estado de una tarea
    public void cambiarEstado(String nombre, boolean pendiente){
        for (Tarea tarea : listaTareas) {
            if (tarea.getNombre().equalsIgnoreCase(nombre)) {
                tarea.setPendiente(pendiente);
            }
        }
    }

    //8. Método para transformar a archivo
    public void toArchivo(){
        try (
                BufferedWriter escritor = new BufferedWriter(
                        new FileWriter("Tareas.txt", true)
                )
        ) {
            //Código
            for (Tarea tarea : listaTareas){
                escritor.write(tarea.toString());
                escritor.newLine();
                escritor.newLine();
            }
            System.out.println("Archivo generado con éxito");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ha ocurrido un error al generar el archivo .txt");
        }
    }


    public static void main(String[] args) {
        ListaTareas tareas = new ListaTareas();
        boolean status = false;
        while (!status) {
            Scanner sc = new Scanner(System.in);
            System.out.println("---#MENU DE OPCIONES#---");
            System.out.println("Seleccione una de las siguientes opciones \n");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Verificar si la tarea está en la lista y si está pendiente");
            System.out.println("3. Obtener la cantidad de tareas pendientes");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Imprimir la lista de tareas pendientes");
            System.out.println("6. Limpiar la lista");
            System.out.println("7. Cambiar el estado de una tarea");
            System.out.println("8. Convertir la lista de tareas a un archivo de texto");
            System.out.println("9. Salir");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    tareas.agregarTarea();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la tarea a verificar:");
                    String nombreVerificar = sc.nextLine();
                    if (tareas.ifExistIfPending(nombreVerificar)) {
                        System.out.println("La tarea está pendiente.");
                    } else {
                        System.out.println("La tarea no está pendiente o no existe.");
                    }
                    break;
                case 3:
                    System.out.println("Número de tareas pendientes: " + tareas.tareasPendiente());
                    break;
                case 4:
                    System.out.println("Ingrese el nombre de la tarea a eliminar:");
                    String nombreEliminar = sc.nextLine();
                    tareas.eliminarTarea(nombreEliminar);
                    break;
                case 5:
                    System.out.println("Tareas pendientes:");
                    tareas.imprimirTareas();
                    break;
                case 6:
                    tareas.limpiarLista();
                    System.out.println("Lista de tareas limpiada.");
                    break;
                case 7:
                    System.out.println("Ingrese el nombre de la tarea a cambiar estado:");
                    String nombreEstado = sc.nextLine();
                    System.out.println("¿Marcar como pendiente? (true/false):");
                    boolean nuevoEstado = sc.nextBoolean();
                    sc.nextLine();
                    tareas.cambiarEstado(nombreEstado, nuevoEstado);
                    break;
                case 8:
                    tareas.toArchivo();
                    break;
                case 9:
                    System.out.println("/SALIENDO DEL MENÚ...");
                    status = true;
                    break;
                default:
                    System.out.println("¡ERROR! Opcion no valida");
                    break;
            }
        }
    }
}
