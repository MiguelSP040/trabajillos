import java.util.*;

/** Generar un arbol con la siguiente estructura y valores:
 *                 100
 *             /        \
 *           34          56
 *          /  \       /    \
 *        23   38     43     79
 *       /  \    \   /  \   /  \
 *      12  24   41 42  44 55  95
 *
 *
 * Luego desarrolla 3 algoritmos que al pasarles el árbol, lo
 * voltee dejando el siguiente:
 *
 *                   100
 *                 /      \
 *               56        34
 *              /  \      /    \
 *            79    43   38    23
 *           /  \  /  \    \   /  \
 *          95  55 44 42   41  24  12
 *
 * Observa que los valores de la derecha se pasaron a la izquierda
 *
 * El primer algoritmo debe manejar una Pila (la que hicimos en clase),
 * El segundo, una Cola (la que hicimos en clase)
 * Y finalmente el ultimo debe ser recursivo sin manejar nada más
 * que la raíz del árbol
 *
 * Rellenar: Nombres de los integrantes del equipo:
 *   1) Bertadillo Villalobos Leobardo Daniel
 *   2) Paredes Dominguez Jassiel
 *   3) Reyes Vargas Isael Alejandro
 *   4) Sánchez Martínez Danna Paola
 *   5) Sánchez Pérez Miguel Ángel
 *   6) Vargas Ledesma Piero Leonardo
 *
 **/

// Definición de la clase Nodo para los elementos del árbol binario
class Nodo {
    int valor;          // Valor almacenado en el nodo
    Nodo izquierdo, derecho;  // Referencias a los nodos izquierdo y derecho

    public Nodo(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;  // Inicialmente, ambos subárboles son null
    }
}

class UV_E4_Apellidos_Nombre {

    // Método de inversión usando una Pila (Stack)
    public static void voltearConPila(Nodo root) {
        // Si el árbol está vacío, no hay nada que voltear
        if (root == null) return;

        // Crear una pila para recorrer el árbol
        Stack<Nodo> pila = new Stack<>();
        pila.push(root);  // Empezamos con la raíz del árbol

        // Recorrer el árbol usando la pila
        while (!pila.isEmpty()) {
            Nodo nodo = pila.pop();  // Sacamos un nodo de la pila

            // Intercambiamos los subárboles izquierdo y derecho
            Nodo temp = nodo.izquierdo;
            nodo.izquierdo = nodo.derecho;
            nodo.derecho = temp;

            // Si el subárbol izquierdo existe, lo agregamos a la pila
            if (nodo.izquierdo != null) pila.push(nodo.izquierdo);
            // Si el subárbol derecho existe, lo agregamos a la pila
            if (nodo.derecho != null) pila.push(nodo.derecho);
        }
    }

    public static void voltearConCola(Nodo root) {
        // Si el árbol está vacío, no hay nada que voltear
        if (root == null) return;

        // Crear una cola para recorrer el árbol
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(root);  // Agregamos la raíz del árbol a la cola

        // Recorrer el árbol usando la cola
        while (!cola.isEmpty()) {
            Nodo nodo = cola.poll();  // Sacamos un nodo de la cola

            // Intercambiamos los subárboles izquierdo y derecho
            Nodo temp = nodo.izquierdo;
            nodo.izquierdo = nodo.derecho;
            nodo.derecho = temp;

            // Si el subárbol izquierdo existe, lo agregamos a la cola
            if (nodo.izquierdo != null) cola.add(nodo.izquierdo);

            // Si el subárbol derecho existe, lo agregamos a la cola
            if (nodo.derecho != null) cola.add(nodo.derecho);
        }
    }


    // Método recursivo para invertir el árbol
    public static void voltearRecursivo(Nodo root) {
        // Si el nodo es nulo, no hay nada que voltear
        if (root == null) return;

        // Intercambiamos los subárboles izquierdo y derecho
        Nodo temp = root.izquierdo;
        root.izquierdo = root.derecho;
        root.derecho = temp;

        // Llamamos recursivamente a los subárboles izquierdo y derecho
        voltearRecursivo(root.izquierdo);
        voltearRecursivo(root.derecho);
    }

    // Función para realizar un recorrido InOrder y mostrar los valores del árbol
    public static void inOrder(Nodo root) {
        if (root == null) return;  // Si el árbol está vacío, no hacemos nada

        // Recorrer el subárbol izquierdo
        inOrder(root.izquierdo);

        // Imprimir el valor del nodo actual
        System.out.print(root.valor + " ");

        // Recorrer el subárbol derecho
        inOrder(root.derecho);
    }

    // Función principal donde probamos los métodos (esto se puede mejorar para algo mas pequeño posible )
    public static void main(String[] args) {
        // Crear el árbol binario con los valores dados
        Nodo root = new Nodo(100);
        root.izquierdo = new Nodo(34);
        root.derecho = new Nodo(56);

        root.izquierdo.izquierdo = new Nodo(23);
        root.izquierdo.derecho = new Nodo(38);
        root.derecho.izquierdo = new Nodo(43);
        root.derecho.derecho = new Nodo(79);

        root.izquierdo.izquierdo.izquierdo = new Nodo(12);
        root.izquierdo.izquierdo.derecho = new Nodo(24);
        root.izquierdo.derecho.derecho = new Nodo(41);
        root.derecho.izquierdo.izquierdo = new Nodo(42);
        root.derecho.izquierdo.derecho = new Nodo(44);
        root.derecho.derecho.izquierdo = new Nodo(55);
        root.derecho.derecho.derecho = new Nodo(95);

        // Mostrar el árbol antes de voltear usando InOrder
        System.out.println("Árbol original (InOrder):");
        inOrder(root);
        System.out.println();

        // Voltear el árbol usando Pila
        //(si el nodo tiene un subárbol izquierdo, agrega ese subárbol a la pila.
        //Si el nodo tiene un subárbol derecho, también lo agregas a la pila.)
        voltearConPila(root);
        System.out.println(" después de voltear con Pila (InOrder):");
        inOrder(root);
        System.out.println();
        // sea que  si un nodo tiene un subárbol izquierdo y derecho, debes intercambiarlos.

        // Restaurar el árbol original (para probar el siguiente método y quede igual)
        voltearRecursivo(root);

        // Voltear el árbol usando Cola
        //igual que con pilas se intercambia sus subárboles izquierdo y derecho.
        //Luego, si el nodo tiene un subárbol izquierdo, agrega ese subárbol a la cola
        voltearConCola(root);
        System.out.println(" después de voltear con Cola (InOrder):");
        inOrder(root);
        System.out.println();

        // Restaurar el árbol original (para probar el siguiente método)
        voltearRecursivo(root);

        // Voltear el árbol usando Recursión(Sin un caso base, la función se llamaría a sí misma infinitamente)
        voltearRecursivo(root);
        System.out.println("\nÁrbol después de voltear recursivamente (InOrder):");
        inOrder(root);
        System.out.println();
    }
}
