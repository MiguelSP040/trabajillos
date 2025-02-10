package juego;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bienvenido al juego");

        Pokemon charmander = new Pokemon("Charmander", 100, 20, 20, 30, Tipo.FUEGO, new Movimiento[]{Movimiento.ASCUAS, Movimiento.GIRO_FUEGO});
        Pokemon vaporeon = new Pokemon("Vaporeon", 200, 40, 40, 35, Tipo.AGUA, new Movimiento[]{Movimiento.HIDRO_CANON, Movimiento.CASCADA});
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 120, 20, 30, 18, Tipo.PLANTA, new Movimiento[]{Movimiento.DRENADORAS, Movimiento.HOJAS_NAVAJA});
        Pokemon squirtle = new Pokemon("Squirtle", 130, 25, 25, 25, Tipo.AGUA, new Movimiento[]{Movimiento.PISTOLA_AGUA, Movimiento.SURF});
        Pokemon magikarp = new Pokemon("Magikarp", 40, 5, 5, 30, Tipo.AGUA, new Movimiento[]{Movimiento.PISTOLA_AGUA});
        Pokemon chikorita = new Pokemon("Chikorita", 110, 20, 25, 25, Tipo.PLANTA, new Movimiento[]{Movimiento.DRENADORAS, Movimiento.LATIGO_CEPA});
        Pokemon charizard = new Pokemon("Charizard", 350, 80, 70, 60, Tipo.FUEGO, new Movimiento[]{Movimiento.ONDA_IGNEA, Movimiento.LANZA_LLAMAS});

        Jugador ignacio = new Jugador("Ignacio", new Pokemon[]{charmander, bulbasaur, squirtle});
        Jugador karol = new Jugador("Karol", new Pokemon[]{charizard, magikarp, vaporeon});


        //Hacer una clase que permita la batalla
        //Se compone de 2 jugadores
        //De una cola de turnos <-- dependiendo de la velocidad

        Queue<Jugador> colaTurnos = new LinkedList<>();
        colaTurnos.add(karol);
        colaTurnos.add(ignacio);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al juego");

        while (!karol.sinPokemones() && !ignacio.sinPokemones()) {
            Jugador jugadorActual = colaTurnos.poll();
            Pokemon pokemonActual = jugadorActual.getPokemonActivo();
            Jugador oponente = (jugadorActual == karol) ? ignacio : karol;

            System.out.println("Turno de " + jugadorActual.getNombre() + " con " + pokemonActual.getNombre());
            System.out.println("Movimientos disponibles:");
            Movimiento[] movimientos = pokemonActual.getMovimientos();
            for (int i = 0; i < movimientos.length; i++) {
                Movimiento movimiento = movimientos[i];
                System.out.println((i + 1) + ". " + movimiento.name() +
                        " (Potencia: " + movimiento.getPotencia() +
                        ", Precisión: " + movimiento.getPrecision() + ")");
            }


            System.out.print("Selecciona un movimiento (1-" + movimientos.length + "): ");
            int opcion = scanner.nextInt() - 1;

            if (opcion < 0 || opcion >= movimientos.length) {
                System.out.println("Movimiento inválido. Se pierde el turno.");
            } else {
                Movimiento movimientoSeleccionado = movimientos[opcion];
                Pokemon objetivo = oponente.getPokemonActivo();

                if (pokemonActual.atacar(movimientoSeleccionado, objetivo)) {
                    if (objetivo.getVida() <= 0) {
                        oponente.siguientePokemon();
                        if (oponente.sinPokemones()) {
                            System.out.println(oponente.getNombre() + " se quedó sin Pokémon. ¡" + jugadorActual.getNombre() + " gana!");
                            return;
                        }
                        System.out.println("Nuevo Pokémon de " + oponente.getNombre() + ": " +
                                oponente.getPokemonActivo().getNombre());
                    }
                }
            }

            if (!jugadorActual.sinPokemones()) {
                colaTurnos.add(jugadorActual);
            }
        }
    }
}
