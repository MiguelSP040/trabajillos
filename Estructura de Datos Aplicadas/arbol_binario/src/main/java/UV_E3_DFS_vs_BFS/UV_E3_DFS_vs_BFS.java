package UV_E3_DFS_vs_BFS;

import java.util.Stack;

/** Generar algoritmos DFS y BFS
 *
 * Rellenar: Nombres de los integrantes del equipo:
 *   1)
 *   2)
 *   3)
 *   4)
 *   5)
 *   6)
 *
 **/

public class UV_E3_DFS_vs_BFS {
    public static void main (String[] args){
        // Primero llenamos el árbol

        // TODO Prueba tus métodos en una función main con el conjunto de datos y
        // los siguientes valores: 42 y 33, tu programa debe reportar en consola
        // si existe o no el número y que tipo de búsqueda se utilizo.
        // Salida:  "42 se encuentra en el árbol, se uso DFS iterativo”

    }

    //Para este método usa una Stack personalizada  (Ejemplo)
    public boolean searchDFSIterative(BinaryTree.Node node,
                                      int data) {
        if (node == null) { return false; }
        Stack<BinaryTree.Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            BinaryTree.Node actual = stack.pop();
            if (actual.data == data) { return true; }
            if (actual.right != null) { stack.push(actual.right); }
            if (actual.left != null) { stack.push(actual.left); }
        }
        return false;
    }

    //Para este método usa una Queue personalizada
    public boolean searchBFSIterative(int data) {
        //TODO
        throw new UnsupportedOperationException("Aun no se implemnta este método, borra est throw cuando lo completes");
    }

    public boolean searchDFS(int data) {
        return searchDFSRecursive(data);
    }

    public boolean searchDFSRecursive(int data) {
        //TODO
        throw new UnsupportedOperationException("Aun no se implemnta este método, borra est throw cuando lo completes");
    }

    public boolean searchBFS(int data) {
        return searchBFSRecursive(data);
    }

    public boolean searchBFSRecursive(int data) {
        //TODO
        throw new UnsupportedOperationException("Aun no se implemnta este método, borra est throw cuando lo completes");
    }
}
