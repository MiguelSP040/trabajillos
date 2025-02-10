package Ejercicio1;

import java.util.Scanner;

public class Programita {
    public static void main(String[] args) {
        ArrayList<Contacto> arrayList = new ArrayList<>();
        String nombre, apellido, telefono;
        int idContacto;
        boolean status = false;

        while (status != true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("---#MENU DE OPCIONES#---");
            System.out.println("\n Seleccione una de las siguientes opciones \n");
            System.out.println("1. Agregar un contacto");
            System.out.println("2. Mostrar todos los contactos");
            System.out.println("3. Buscar un contacto por índice");
            System.out.println("4. Modificar el número de teléfono de un contacto");
            System.out.println("5. Eliminar un contacto");
            System.out.println("6. Mostrar el número total de contactos");
            System.out.println("7. Salir");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("REGISTRO DE CONTACTO");
                    System.out.println("Ingrese el nombre:");
                    nombre = sc.nextLine();
                    System.out.println("Ingrese el apellido:");
                    apellido = sc.nextLine();
                    System.out.println("Ingrese el número telefónico:");
                    telefono = sc.nextLine();
                    if (arrayList.add(new Contacto(nombre, apellido, telefono))) {
                        System.out.println("Contacto añadido!");
                    } else {
                        System.out.println("Ha ocurrido un error!");
                    }
                    break;
                case 2:
                    System.out.println("LISTA DE CONTACTOS:");
                    for (int i = 0; i < arrayList.size(); i++) {
                        System.out.println("CONTACTO #" +
                                i +
                                "\n" +
                                arrayList.get(i));
                    }
                    break;
                case 3:
                    System.out.println("BUSCAR CONTACTO");
                    System.out.println("Ingresa el id del contacto:");
                    idContacto = sc.nextInt();
                    System.out.println(arrayList.get(idContacto));
                    break;
                case 4:
                    System.out.println("MODIFICAR TELÉFONO DE CONTACTO");
                    System.out.println("Ingresa el id del contacto:");
                    idContacto = sc.nextInt();
                    System.out.println("Ingresa el nuevo número de teléfono:");
                    telefono = sc.nextLine();
                    arrayList.get(idContacto).telefono = telefono;
                    System.out.println("Teléfono actualizado!");
                    break;
                case 5:
                    System.out.println("ELIMINAR CONTACTO");
                    System.out.println("Ingresa el id del contacto:");
                    idContacto = sc.nextInt();
                    arrayList.remove(idContacto);
                    break;
                case 6:
                    System.out.println("CANTIDAD DE CONTACTOS");
                    System.out.println("Total: " + arrayList.size());
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
