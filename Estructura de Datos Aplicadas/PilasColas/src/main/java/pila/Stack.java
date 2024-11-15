package pila;

import java.util.EmptyStackException;

public class Stack<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    // Atributos
    private Node<E> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    // Métodos
    public void push(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public E peek() {
        if (size != 0) {
            return top.data;
        }
        throw new IllegalStateException("La pila está vacía");
    }

    public E pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        E data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        top = null;
        size = 0;
    }
}
