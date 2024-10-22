package Ejercicio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<Libro> linkedList = new LinkedList<>();
        String titulo, autor;
        int anioPublicacion;
        boolean status = false;

        while (status != true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("---#MENU DE OPCIONES#---");
            System.out.println("Seleccione una de las siguientes opciones");
            System.out.println("1. Agregar un libro");
            System.out.println("2. Buscar libros por autor");
            System.out.println("3. Filtrar libros publicados antes de un año específico");
            System.out.println("4. Modificar la información");
            System.out.println("5. Eliminar un libro por título");
            System.out.println("6. Mostrar todos los libros en la biblioteca");
            System.out.println("7. Salir");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("AGREGAR LIBRO");
                    System.out.println("Ingresa el título del libro:");
                    titulo = sc.nextLine();
                    System.out.println("Ingresa el nombre del autor:");
                    autor = sc.nextLine();
                    System.out.println("Ingresa el año de publicación:");
                    anioPublicacion = sc.nextInt();
                    if (linkedList.add(new Libro(titulo, autor, anioPublicacion))) {
                        System.out.println("Libro guardado");
                    } else {
                        System.out.println("Ha ocurrido un error");
                    }
                    break;
                case 2:
                    System.out.println("BUSCAR LIBROS");
                    System.out.println("Ingrese el nombre del autor:");
                    autor = sc.nextLine();
                    for (int i = 0; i < linkedList.size(); i++){
                        if (autor.equals(linkedList.get(i).autor)){
                            System.out.println(
                                    "LIBRO #" +
                                            i +
                                            "\n" +
                                            linkedList.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.println("FILTRAR LIBRO POR AÑO DE PUBLICACIÓN");
                    System.out.println("Ingrese el año de publicación:");
                    anioPublicacion = sc.nextInt();
                    for (int i = 0; i < linkedList.size(); i++){
                        if ((linkedList.get(i).anioPublicacion) < anioPublicacion){
                            System.out.println(
                                    "LIBRO #" +
                                            i +
                                            "\n" +
                                            linkedList.get(i));
                        }
                    }
                    break;
                case 4:
                    System.out.println("MODIFICAR LIBRO");
                    System.out.println("Ingrese el nombre del autor:");
                    autor = sc.nextLine();
                    for (int i = 0; i < linkedList.size(); i++){
                        if (autor.equals(linkedList.get(i).autor)){
                            System.out.println("LIBRO" + linkedList.get(i).titulo);
                            System.out.println("Ingrese el nuevo título:");
                            titulo = sc.nextLine();
                            linkedList.get(i).titulo = titulo;
                            System.out.println("Ingrese el nuevo autor:");
                            autor = sc.nextLine();
                            linkedList.get(i).autor = autor;
                            System.out.println("Ingrese el nuevo año de publicación:");
                            anioPublicacion = sc.nextInt();
                            linkedList.get(i).anioPublicacion = anioPublicacion;
                        }
                    }
                    break;
                case 5:
                    System.out.println("ELIMINAR LIBRO");
                    System.out.println("Ingrese el titulo del libro:");
                    titulo = sc.nextLine();
                    for (int i = 0; i < linkedList.size(); i++){
                        if (titulo.equals(linkedList.get(i).titulo)){
                            linkedList.remove(i);
                            System.out.println("El libro ha sido eliminado");
                        }
                    }
                    break;
                case 6:
                    System.out.println("LISTADO DE LIBROS");
                    if (linkedList.size() != 0){
                        for (int i = 0; i < linkedList.size(); i++) {
                            System.out.println(
                                    "LIBRO #" +
                                            i +
                                            "\n" +
                                            linkedList.get(i));
                        }
                    } else {
                        System.out.println("La lista está vacía");
                    }
                    break;
                case 7:
                    status = true;
                    break;
                default:
                    System.out.println("¡ERROR! Opcion no valida");
                    break;
            }
        }
    }
}
