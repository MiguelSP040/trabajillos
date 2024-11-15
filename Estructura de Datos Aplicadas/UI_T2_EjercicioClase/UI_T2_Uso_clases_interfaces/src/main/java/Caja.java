public class Caja<T> {
    private T cosa;
    private boolean estado = true;

    public Caja(T cosa) {
        this.cosa = cosa;
    }

    public T unboxing(){
        this.estado = true;
        return this.cosa;
    }
    public void enviar(){
        System.out.println("Se envía: " + this.cosa);
    }

    public void cerrar(){
        System.out.println("Se cierra la caja");
        this.estado = false;
    }

    public boolean isCerrada(){
        return !this.estado;
    }

    public String verCosas(){
        if(this.estado){
            return this.cosa.toString();
        }else{
            return "La caja está cerrada, no puedes ver lo que tiene :(";
        }
    }

    public static void main(String[] args) {
        Coche BMW = new Coche();
        Caja<Coche> caja1 = new Caja<Coche>(BMW);

        caja1.unboxing();
        System.out.println(caja1.isCerrada());
        System.out.println(caja1.verCosas());

        Caja<String> caja2 = new Caja<String>("Cartita");
        caja2.unboxing();
        System.out.println(caja2.isCerrada());
        System.out.println(caja2.verCosas());

        caja1.enviar();
        caja2.enviar();
    }
}
