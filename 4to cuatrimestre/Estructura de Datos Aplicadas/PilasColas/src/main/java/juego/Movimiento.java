package juego;

public enum Movimiento {
    // Movimientos de tipo FUEGO
    LANZA_LLAMAS(Tipo.FUEGO, 80, 90),
    ASCUAS(Tipo.FUEGO, 40, 100),
    GIRO_FUEGO(Tipo.FUEGO, 35, 85),
    ONDA_IGNEA(Tipo.FUEGO, 90, 85),

    // Movimientos de tipo AGUA
    HIDRO_CANON(Tipo.AGUA, 80, 90),
    PISTOLA_AGUA(Tipo.AGUA, 40, 100),
    SURF(Tipo.AGUA, 90, 100),
    CASCADA(Tipo.AGUA, 80, 90),

    // Movimientos de tipo PLANTA
    HOJAS_NAVAJA(Tipo.PLANTA, 60, 100),
    LATIGO_CEPA(Tipo.PLANTA, 45, 100),
    RAYO_SOLAR(Tipo.PLANTA, 120, 75),
    DRENADORAS(Tipo.PLANTA, 20, 90);

    private final Tipo tipo;
    private final int potencia;
    private final int precision;

    Movimiento(Tipo tipo, int potencia, int precision) {
        this.tipo = tipo;
        this.potencia = potencia;
        this.precision = precision;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getPrecision() {
        return precision;
    }
}

