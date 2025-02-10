package juego;

import java.util.LinkedList;
import java.util.Queue;

public class Jugador {
    private String nombre;
    private Queue<Pokemon> pokemones;

    public Jugador(String nombre, Pokemon[] pokemones) {
        this.nombre = nombre;
        this.pokemones = new LinkedList<>();
        for (Pokemon p : pokemones) {
            this.pokemones.add(p);
        }
    }

    // Obtener el nombre del jugador
    public String getNombre() {
        return nombre;
    }

    // Obtener los Pokémon activos
    public Queue<Pokemon> getPokemonesActivos() {
        return pokemones;
    }

    // Obtener el Pokémon que está actualmente en combate
    public Pokemon getPokemonActivo() {
        return pokemones.peek(); // Retorna el primer Pokémon en la cola sin eliminarlo
    }

    // Pasar al siguiente Pokémon en la fila
    public void siguientePokemon() {
        pokemones.poll(); // Remueve el Pokémon debilitado
    }

    // Verificar si el jugador se quedó sin Pokémon
    public boolean sinPokemones() {
        return pokemones.isEmpty();
    }
}
