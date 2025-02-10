package UV_E2_SanchezPerez_Miguel;

public class UV_E2_SanchezPerez_Miguel {
    public static void main(String[] args) {
        BinaryTree arbolito = new BinaryTree();
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int valor : valores) {
            arbolito.insert(valor);
        }

        if (arbolito.isBST()) {
            System.out.println("El árbol es un Árbol Binario de Búsqueda (BST).");
        } else {
            System.out.println("El árbol NO es un Árbol Binario de Búsqueda (BST).");
        }
    }
}
