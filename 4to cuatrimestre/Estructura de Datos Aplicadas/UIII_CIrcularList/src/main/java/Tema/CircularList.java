package Tema;

public class CircularList<E> {

    //Atributos
    Node<E> head;
    Node<E> tail;
    int size;

    public CircularList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //Métodos para controlar nodos
    //Son los mismos que linkedList (incluyengo el Tail)
    public int size(){
        return this.size;
    }

    //Agregar un elemento a la lista
    //Siempre al final de la lista
    public boolean add(E data){
        if (this.head == null){
            this.head = new Node<E>(data);
            this.tail = this.head;
        } else {
            //Variable de ayuda
            Node<E> ayudante = tail;
            ayudante.next = new Node<E>(data);
            tail = ayudante.next;
            tail.next = this.head;
        }
        size++;
        return true;
    }

    //Método para obtener información
    public E get(int index){
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException(
                    "El índice supera los límites d ela lista"
            );
        }
        //Iterar la lista con un for (según el index)
        Node<E> ayudante = head;
        //Recorrer hasta el índice deseado
        for (int i = 0; i < index; i++){
            ayudante = ayudante.next;
        }
        return ayudante.data;
    }

    //Método para remover
    public boolean remove(int index){
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException(
                    "El índice supera los límites d ela lista"
            );
        }

        if (index == 0){
            if (size == 1) {
                //Si solo hay un nodo, eliminarlo y reiniciarlo
                head = null;
                tail = null;
            }else {
                head = head.next; //Mover la cabeza al siguiente
                tail.next = head; //Mantener la circularidad
            }
        } else {
            Node<E> current = head;
            //Buscar el nodo anterior al que queremos eliminar
            for (int i = 0; i < index - 1; i++){
                current = current.next;
            }
            //Saltar el nodo a eliminar
            current.next = current.next.next;

            //Si el nodo a eliminar es el último, actualiza
            if (index == size - 1){
                tail = current;
            }
        }
        size--;
        return true;
    }
}
