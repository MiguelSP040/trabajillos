package Ejercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaProductos {
    static List<Producto> productosList = new ArrayList<>();

    public void agregarElemento(String nombre, float precio) {
        productosList.add(new Producto(nombre, precio));
    }

    public boolean verificarProducto(String nombre) {
        for (Producto producto : productosList) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public Producto obtenerProducto(int index) {
        if (index >= 0 && index < productosList.size()) {
            return productosList.get(index);
        }
        return null;
    }

    public void eliminarProducto(String nombre) {
        Producto productoAEliminar = null;
        for (Producto producto : productosList) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                productoAEliminar = producto;
                break;
            }
        }

        if (productoAEliminar != null) {
            productosList.remove(productoAEliminar);
            System.out.println("Producto eliminado: " + productoAEliminar.getNombre());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }


    public static void main(String[] args) {
        ListaProductos productos = new ListaProductos();
        boolean status = false;

        while (status != true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("---#MENU DE OPCIONES#---");
            System.out.println("\n Seleccione una de las siguientes opciones \n");
            System.out.println("1. Agregar elemento");
            System.out.println("2. Verificar si el elemento está en la lista");
            System.out.println("3. Obtener un elemento específico");
            System.out.println("4. Eliminar elemento");
            System.out.println("5. Imprimir la lista");
            System.out.println("6. Limpiar la lista");
            System.out.println("7. Salir");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del producto:");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese el precio del producto:");
                    float precio = sc.nextFloat();
                    productos.agregarElemento(nombre, precio);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del producto a verificar");
                    nombre = sc.nextLine();
                    boolean foundOr = productos.verificarProducto(nombre);
                    System.out.println("¿El producto está en la lista? " + foundOr);
                    break;
                case 3:
                    System.out.println("Indice del producto a obtener: ");
                    int index = sc.nextInt();
                    Producto producto = productos.obtenerProducto(index);
                    if (producto != null) {
                        System.out.println("Producto con el índice " + (index) +
                                ": " + producto.getNombre() + " Precio: $" + producto.getPrecio());
                    } else {
                        System.out.println("No existe el producto en ese índice");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del producto a eliminar");
                    nombre = sc.nextLine();
                    productos.eliminarProducto(nombre);
                    break;
                case 5:
                    if (productosList.isEmpty()) {
                        System.out.println("La lista de compras está vacía");
                    } else {
                        System.out.println("Lista de compras:");
                        for (Producto producto1 : productosList) {
                            System.out.println(producto1.toString());
                        }
                    }
                    break;
                case 6:
                    productosList.clear();
                    System.out.println("La lista de compras ha sido vaciada.");
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
