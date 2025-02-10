package Tema;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> lista = new LinkedList<>();
        System.out.println(
                lista.size() == 0 ? "La lista está vacía" : "Qué raro"
        );

        String a = "Hola 4C";
        lista.add(a);

        lista.add("Estoy programando una lista");

        System.out.println("Tamaño de la lista: " + lista.size());

        for (int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }
    }
}
