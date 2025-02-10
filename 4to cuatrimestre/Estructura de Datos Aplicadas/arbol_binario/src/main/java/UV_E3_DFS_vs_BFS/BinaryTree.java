package UV_E3_DFS_vs_BFS;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    // Clase Nodo para representar cada nodo del árbol
    public static class Node {
        int data; // Dato del nodo
        Node left; // Referencia al hijo izquierdo
        Node right; // Referencia al hijo derecho

        // Constructor
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    // Atributos de clase del árbol
    Node root; // Nodo raíz del árbol

    public int getData() {
        return root.data;
    }

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
        // si no hay nodo actual (condición de paro)
        if (actual == null) {
            return new Node(data);
        }

        // Decidir si insertar en el izquierdo (menor) o derecho (mayor)
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

    public static boolean searchDFSIterative(Node root, int data) {
        if (root == null)
            return false;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (current.data == data) {
                return true;
            }
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return false;
    }

    public static boolean searchBFSIterative(Node root, int data) {
        if (root == null)
            return false;

        Queue<Node> queue = new Queue<>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Node> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Node node) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Node> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public boolean offer(Node node) {
                return false;
            }

            @Override
            public Node remove() {
                return null;
            }

            @Override
            public Node poll() {
                return null;
            }

            @Override
            public Node element() {
                return null;
            }

            @Override
            public Node peek() {
                return null;
            }
        };
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.data == data) {
                return true;
            }
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return false;
    }

    public static boolean searchDFSRecursive(Node root, int data) {
        if (root == null)
            return false;
        if (root.data == data)
            return true;

        // Buscar recursivamente en el subárbol izquierdo o derecho
        return searchDFSRecursive(root.left, data) || searchDFSRecursive(root.right, data);
    }

    public static boolean searchBFSRecursive(Node root, int data) {
        return bfsRecursiveHelper(new Queue<>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Node> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Node node) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Node> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public boolean offer(Node node) {
                return false;
            }

            @Override
            public Node remove() {
                return null;
            }

            @Override
            public Node poll() {
                return null;
            }

            @Override
            public Node element() {
                return null;
            }

            @Override
            public Node peek() {
                return null;
            }
        }, root, data);
    }

    private static boolean bfsRecursiveHelper(Queue<Node> queue, Node node, int data) {
        if (node == null && queue.isEmpty())
            return false;

        if (node != null) {
            if (node.data == data)
                return true;
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return bfsRecursiveHelper(queue, queue.poll(), data);
    }

    // Método para eliminar un nodo en el árbol binario
    public Node eliminarNodo(Node raiz, int valor) {
        // Caso base: el árbol está vacío
        if (raiz == null)
            return raiz;
        if (valor < raiz.data) {
            raiz.left = eliminarNodo(raiz.left, valor);
        } else if (valor > raiz.data) {
            raiz.right = eliminarNodo(raiz.right, valor);
        } else { // Caso 1: El nodo tiene un solo hijo o no tiene hijos
            if (raiz.left == null) {
                return raiz.right;
            } else if (raiz.right == null) {
                return raiz.left;
            } // Caso 2: El nodo tiene dos hijos
            raiz.data = obtenerMinimo(raiz.right); // Encontramos el sucesor en el subárbol right
            raiz.right = eliminarNodo(raiz.right, raiz.data); // Eliminar el sucesor
        }
        return raiz;
    }

    // Método para encontrar el nodo con el valor mínimo (sucesor)
    public int obtenerMinimo(Node raiz) {
        int minimo = raiz.data; while (raiz.left != null) {
            minimo = raiz.left.data; raiz = raiz.left;
        }
        return minimo;
    }

    public Node getRoot() {
        return root;
    }

    public BinaryTree setRoot(Node root) {
        this.root = root;
        return this;
    }
}