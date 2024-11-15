package cola;

public class UIV_E5_SanchezPerez_Miguel {
    private static class Cliente{
        private String nombre;
        private int tiempo;
        private Queue<Producto> carrito;

        //Constructor
        public Cliente(String nombre, int tiempo, Queue<Producto> carrito) {
            this.nombre = nombre;
            this.tiempo = tiempo;
            this.carrito = carrito;
        }

        //Gets
        public String getNombre() {
            return nombre;
        }

        public int getTiempo() {
            return tiempo;
        }

        public Queue<Producto> getCarrito() {
            return carrito;
        }
    }

    private static class Producto{
        private String nombre;
        private double precio;

        //Constructor
        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        //Getters

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }
    }

    public static void main(String[] args) {
        //Ejercicio
        Queue<Producto> carrito = new Queue<>();
        carrito.offer(new Producto("Café", 18.00));
        carrito.offer(new Producto("Dona", 10.00));
        carrito.offer(new Producto("Chilaquiles", 35.00));

        Cliente miguel = new Cliente("Miguel", 10, carrito);

        Queue<Producto> carrito2 = new Queue<>();
        carrito2.offer(new Producto("Monster", 23.00));
        carrito2.offer(new Producto("Donitos", 25.00));

        Cliente isael = new Cliente("Isael", 5, carrito2);

        //Formar a los clientes
        Queue<Cliente> fila = new Queue<>();
        fila.offer(miguel);
        fila.offer(isael);

        for (int i = 0; i<2; i++){
            System.out.println("Atendiendo a: " + fila.peek().getNombre());
            try {
                Thread.sleep(fila.peek().getTiempo() * 1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            //Poner el procesamiento de nuestros productos
            //----------------------------------
            double total = 0.0;
            int z = fila.peek().getCarrito().size();
            for (int j = 0; j<z ; j++){
                total += fila.peek().getCarrito().poll().getPrecio();
            }
            System.out.println("Se cobró: " + total);
            //----------------------------------
            System.out.println("Ya se atendió a: " + fila.poll().getNombre());
        }
    }
}
