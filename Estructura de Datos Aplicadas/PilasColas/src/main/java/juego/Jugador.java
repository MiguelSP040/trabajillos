package juego;

public class Jugador {
    private String nombre;
    private Pokemon[] equipo;

    public Jugador(String nombre, Pokemon[] equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public Jugador setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Pokemon[] getEquipo() {
        return equipo;
    }

    public Jugador setEquipo(Pokemon[] equipo) {
        this.equipo = equipo;
        return this;
    }
}
