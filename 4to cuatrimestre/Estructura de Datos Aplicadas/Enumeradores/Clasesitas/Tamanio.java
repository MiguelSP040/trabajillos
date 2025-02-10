public enum Tamanio{
    CHICO(355,"papel"),
    MEDIANO(600,"papel"),
    GRANDE(800,"plastico"),
    JUMBO(1000,"plastico");

    private final int capacidad;
    private final String material;

    Tamanio(int capacidad, String material){
        this.capacidad = capacidad;
        this.material = material;
    }

    public int getCapacidad(){
        return capacidad;
    }
}