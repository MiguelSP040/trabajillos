public class Taco<O> {
    private O taquito;

    public Taco(O taquito) {
        this.taquito = taquito;
    }

    public void tipoTortilla(String tortilla){
        System.out.println("El taco es con tortilla de " + tortilla);
    }

    public void elaborarTaco(){
        System.out.println("Elaborando taco de " + taquito.toString() + "...");
    }

    public void getTiempo(O taquito){
        this.taquito = taquito;
    }

    public void empacarTaco(){
        System.out.println("Empacando taco...");
    }

    public static void main(String[] args) {
        try {
            System.out.println("### RESÚMEN DE ORDEN ### \n");

            System.out.println("Orden #1: \n");
            Alambre alambre = new Alambre();
            Taco<Alambre> tacoDeAlambre = new Taco<>(alambre);
            tacoDeAlambre.tipoTortilla("harina");
            tacoDeAlambre.elaborarTaco();
            tacoDeAlambre.getTiempo(alambre);
            tacoDeAlambre.empacarTaco();
            System.out.println();

            System.out.println("Orden #2: \n");
            ChicharronEnSalsa chicharronEnSalsa = new ChicharronEnSalsa();
            Taco<ChicharronEnSalsa> tacoDeChicharron = new Taco<>(chicharronEnSalsa);
            tacoDeChicharron.tipoTortilla("maíz");
            tacoDeChicharron.elaborarTaco();
            tacoDeChicharron.getTiempo(chicharronEnSalsa);
            tacoDeChicharron.empacarTaco();
            System.out.println();

            Taco<String> taco = new Taco<>("quesillo");
            taco.tipoTortilla("harina");
            taco.elaborarTaco();
            taco.empacarTaco();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
