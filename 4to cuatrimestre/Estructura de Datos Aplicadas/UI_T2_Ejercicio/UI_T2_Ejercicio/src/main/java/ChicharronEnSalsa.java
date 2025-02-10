public class ChicharronEnSalsa {
    String guisado = "Chicharron en salsa";
    String origen = "Cerdo";
    String tiempo = "30 minutos";
    String precio = "27.00";

    @Override
    public String toString(){
        return guisado + ":" + " elaborado con " + origen + " en " + tiempo + " por $" + precio;
    }
}
