package juego;

public enum Tipo {
    FUEGO, AGUA, PLANTA;

    //Método de ventajas en combate
    public double ventajaTipo(Tipo atacante, Tipo defensor){
        switch (atacante){
            case FUEGO:
                if (defensor == AGUA){
                    return 0.5; //Reduzca el daño
                } else if (defensor == PLANTA) {
                        return 2.0; //Superefectivo
                } else {
                    return 1.0;
                }
            case AGUA:
                if (defensor == PLANTA){
                    return 0.5; //Reduzca el daño
                } else if (defensor == FUEGO) {
                    return 2.0; //Superefectivo
                } else {
                    return 1.0;
                }
            case PLANTA:
                if (defensor == FUEGO){
                    return 0.5; //Reduzca el daño
                } else if (defensor == AGUA) {
                    return 2.0; //Superefectivo
                } else {
                    return 1.0;
                }
        }
        return 0;
    }
}
