package Tema;

public class Node<E> {
    E data;
    Node next;

    //Constructor
    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    //No ponemos getters y setters, debido a que en el constructor los setters están implicitos en el constructor
    //Los getters podemos sustituirlos al acceder directamente al dato de la clase, tal como: Tema.Node.data
}
