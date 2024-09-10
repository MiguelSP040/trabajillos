public class Alambre {
    String guisado = "Alambre";
    String origen = "Res";
    String tiempo = "15 minutos";
    String precio = "23.00";

    @Override
    public String toString(){
        return guisado + ":" + " elaborado con " + origen + " en " + tiempo + " por $" + precio;
    }
}
