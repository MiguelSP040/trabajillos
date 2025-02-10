package UV_E1_SanchezPerez_Miguel;

public class BinaryTree{

    // Clase Nodo para representar cada nodo del árbol
    private static class Node {
        int data;         // Dato del nodo
        Node left;    // Referencia al hijo izquierdo
        Node right;      // Referencia al hijo derecho

        // Constructor
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //Atributos de clase del árbol
    Node root; // Nodo raíz del árbol

    // Constructor
    public BinaryTree() {
        this.root = null;
    }

    // Método para insertar un valor en el árbol
    public void insert(int data) {
        this.root = recursiveInsert(this.root, data);
    }

    // Inserción recursiva
    private Node recursiveInsert(Node actual, int data) {
        //si no hay nodo actual (condición de paro)
        if (actual == null) {
            return new Node(data);
        }

        //Decidir si insertar en el izquierdo (menor) o derecho (mayor)
        if (data < actual.data) {
            actual.left = recursiveInsert(actual.left, data);
        } else if (data > actual.data) {
            actual.right = recursiveInsert(actual.right, data);
        }

        return actual; // Retornar el nodo actual
    }

    // Recorrido in-order (izquierda, raíz, derecha)
    public void inOrder() {
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(Node node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.data + " ");
            inOrderRecursive(node.right);
        }
    }

    // Recorrido pre-order (raíz, izquierda, derecha)
    public void preOrder() {
        preOrderRecursive(root);
        System.out.println();
    }

    private void preOrderRecursive(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }
    // Recorrido post-order (izquierda, derecha, raíz)
    public void postOrder() {
        postOrderRecursive(root);
        System.out.println();
    }

    private void postOrderRecursive(Node node) {
        if (node != null) {
            postOrderRecursive(node.left);
            postOrderRecursive(node.right);
            System.out.print(node.data + " ");
        }
    }

}