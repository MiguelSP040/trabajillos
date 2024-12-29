package UV_E1_SanchezPerez_Miguel;

public class UV_E1_SanchezPerez_Miguel {
    public static void main(String[] args) {
        BinaryTree arbolito = new BinaryTree();
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int valor : valores) {
            arbolito.insert(valor);
        }

        System.out.print("Recorrido In-Order: ");
        arbolito.inOrder();
        System.out.print("Recorrido Pre-Order: ");
        arbolito.preOrder();

        System.out.print("Recorrido Post-Order: ");
        arbolito.postOrder();
    }
}
