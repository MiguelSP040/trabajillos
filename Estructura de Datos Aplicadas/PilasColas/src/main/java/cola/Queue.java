package cola;

import org.w3c.dom.Node;

public class Queue<E>{

    //Clase nodo
    private static class Node<E>{
        public E data;
        public Node<E> next;

        public Node(E data){
            this.data = data;
            this.next = null;
        }
    }

    //Atributos de clase
    private Node<E> front;
    private Node<E> rear;
    private int size;

    //Métodos de la cola
    //Offer
    public boolean offer(E data){
        Node<E> newNode = new Node<>(data);
        if (rear != null){
            rear.next = newNode;
        }

        rear = newNode;

        if(front == null){ //
            front = rear;
        }
        size++;
        return true;
    }

    //Peek
    public E peek(){
        return (front != null) ? front.data : null;
    }

    //isEmpty
    public boolean isEmpty(){
        return size == 0;
        //return front == null;
    }

    //size
    public int size(){
        return size;
    }

    //Poll
    public E poll(){
        if (isEmpty()){
            return null;
        }
        E data = front.data;
        front = front.next;
        if (front == null){
            rear = front;
        }
        size--;
        return data;
    }
}
