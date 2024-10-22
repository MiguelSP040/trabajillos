package Ejercicio;

public class LinkedList<E> {
    //Atributos de la lista
    Node<E> head;
    int size;

    public LinkedList(){
        this.head = null;
        this.size = 0;
    }

    //Método que controlan la lista
    //Los nombres son iguales a los arrayList

    //Método que obtiene el tamaño de la lista
    public int size(){
        return this.size;
    }

    //Agregar un elemento a la lista
    //Siempre al final de la lista
    public boolean add(E data){
        if (this.head == null){
            this.head = new Node<E>(data);
        } else {
            //Variable de ayuda
            Node<E> ayudante = head;
            //Empiezo a recorrer la lista
            while (ayudante.next != null){
                ayudante = ayudante.next;
            }
            //Ya estoy en el último nodo
            ayudante.next = new Node<E>(data);
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
            head = head.next; //Remover el primer nodo
        } else {
            Node current = head;
            //Buscar el nodo anterior al que queremos eliminar
            for (int i = 0; i < index - 1; i ++){
                current = current.next;
            }
            //Saltar el nodo a eliminar
            current.next = current.next.next;
        }
        size--;
        return true;
    }


}
