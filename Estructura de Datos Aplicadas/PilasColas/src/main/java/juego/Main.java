package juego;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static class Batalla {
        private Jugador jugador1;
        private Jugador jugador2;
        private Queue<Pokemon> colaJugador1;
        private Queue<Pokemon> colaJugador2;
        private Scanner scanner;
        private boolean turnoAlternante;

        public Batalla(Jugador jugador1, Jugador jugador2) {
            this.jugador1 = jugador1;
            this.jugador2 = jugador2;
            this.colaJugador1 = ordenarPorVelocidad(jugador1.getEquipo());
            this.colaJugador2 = ordenarPorVelocidad(jugador2.getEquipo());
            this.scanner = new Scanner(System.in);
            this.turnoAlternante = true;
        }

        private Queue<Pokemon> ordenarPorVelocidad(Pokemon[] equipo) {
            Queue<Pokemon> cola = new LinkedList<>();
            for (int i = 0; i < equipo.length; i++) {
                int maxIndex = i;
                for (int j = i + 1; j < equipo.length; j++) {
                    if (equipo[j].getVelocidad() > equipo[maxIndex].getVelocidad()) {
                        maxIndex = j;
                    }
                }
                Pokemon temp = equipo[i];
                equipo[i] = equipo[maxIndex];
                equipo[maxIndex] = temp;
                cola.offer(equipo[i]);
            }
            return cola;
        }

        public void iniciarBatalla() {
            System.out.println("¡Comienza la batalla entre " + jugador1.getNombre() + " y " + jugador2.getNombre() + "!");

            boolean turnoJugador1 = true; // Indica de quién es el turno

            while (!colaJugador1.isEmpty() && !colaJugador2.isEmpty()) {
                Pokemon pokemon1 = colaJugador1.peek();
                Pokemon pokemon2 = colaJugador2.peek();

                if (turnoJugador1) {
                    ejecutarTurno(jugador1, pokemon1, pokemon2, colaJugador1, colaJugador2);
                } else {
                    ejecutarTurno(jugador2, pokemon2, pokemon1, colaJugador2, colaJugador1);
                }

                if (colaJugador1.isEmpty()) {
                    System.out.println(jugador2.getNombre() + " ha ganado la batalla!");
                    break;
                } else if (colaJugador2.isEmpty()) {
                    System.out.println(jugador1.getNombre() + " ha ganado la batalla!");
                    break;
                }

                turnoJugador1 = !turnoJugador1;
            }
        }


        private void ejecutarTurno(Jugador jugador, Pokemon atacante, Pokemon defensor, Queue<Pokemon> colaAtacante, Queue<Pokemon> colaDefensor) {
            Movimiento movimiento = seleccionarMovimiento(jugador, atacante);
            System.out.println(jugador.getNombre() + " elige el movimiento " + movimiento + " para " + atacante.getNombre());

            boolean defensorDerrotado = atacante.atacar(movimiento, defensor);

            if (defensorDerrotado) {
                System.out.println(defensor.getNombre() + " ha sido derrotado.");
                colaDefensor.poll();
            }
        }


        private Movimiento seleccionarMovimiento(Jugador jugador, Pokemon atacante) {
            System.out.println("Turno de " + jugador.getNombre() + " con " + atacante.getNombre());
            System.out.println("Movimientos disponibles:");

            Movimiento[] movimientos = atacante.getMovimientos();
            for (int i = 0; i < movimientos.length; i++) {
                System.out.println(i + 1 + ". " + movimientos[i] + " (Potencia: " + movimientos[i].getPotencia() + ", Precisión: " + movimientos[i].getPrecision() + ")");
            }

            System.out.print("Seleccione un movimiento (1-" + movimientos.length + "): ");
            int opcion = scanner.nextInt();

            while (opcion < 1 || opcion > movimientos.length) {
                System.out.print("Opción inválida. Intente nuevamente: ");
                opcion = scanner.nextInt();
            }

            return movimientos[opcion - 1];
        }
    }


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

        Batalla batalla = new Batalla(ignacio,karol);
        batalla.iniciarBatalla();

    }
}
