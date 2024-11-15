package Ejercicio1;

public class ArrayList<T> {
    //Atributos que definen al Arraylist
    private T[] array;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.capacity = 10;
        this.array = (T[]) new Object[this.capacity];
        this.size = 0;
    }

    private void resize(){
        this.capacity *= 2;
        T[] newArray = (T[]) new Object[this.capacity];
        System.arraycopy(this.array, 0, newArray, 0, size);
        this.array = newArray;
    }

    public boolean add(T elemento){
        if(this.size == this.capacity){
            resize();
        }
        this.array[this.size++] = elemento;
        return true;
    }

    //Método para obtener un elemento por índice
    public T get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException(
                    "El indice está fuera de los limites"
            );
        }
        return this.array[index];
    }

    public boolean remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "El indice está fuera de los límites"
            );
        }

        for (int i = index; i < size - 1; i++){
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size --;

        return true;
    }

    //Método para obtener el tamaño del ArrayList
    public int size(){
        return this.size;
    }

    //Método para verificar si el ArrayList está vació
    public boolean isEmpty(){
        return this.size == 0;
    }

    //Método para limpair el ArrayList
    public void clear(){
        for (int i = 0; i < size; i++){
            array[i] = null;
        }
        size = 0;
    }

    //Método para buscar si un elemento está en el ArrayList
    public boolean contains(T element){
        for (int i = 0; i < size; i++){
            if (array[i].equals(element)){
                return true;
            }
        }
        return false;
    }

}
