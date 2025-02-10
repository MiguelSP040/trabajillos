package juego;

import java.util.Random;

public class Pokemon {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int velocidad;
    private Tipo tipo;
    private Movimiento[] movimientos;

    public Pokemon(String nombre, int vida, int ataque, int defensa, int velocidad, Tipo tipo, Movimiento[] movimientos) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.tipo = tipo;
        this.movimientos = movimientos;
    }

    public String getNombre() {
        return nombre;
    }

    public Pokemon setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public int getVida() {
        return vida;
    }

    public Pokemon setVida(int vida) {
        this.vida = vida;
        return this;
    }

    public int getAtaque() {
        return ataque;
    }

    public Pokemon setAtaque(int ataque) {
        this.ataque = ataque;
        return this;
    }

    public int getDefensa() {
        return defensa;
    }

    public Pokemon setDefensa(int defensa) {
        this.defensa = defensa;
        return this;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public Pokemon setVelocidad(int velocidad) {
        this.velocidad = velocidad;
        return this;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Pokemon setTipo(Tipo tipo) {
        this.tipo = tipo;
        return this;
    }

    public Movimiento[] getMovimientos() {
        return movimientos;
    }

    public Pokemon setMovimientos(Movimiento[] movimientos) {
        this.movimientos = movimientos;
        return this;
    }

    //Métodos de ataque
    public boolean atacar(Movimiento ataque, Pokemon enemigo) {
        Random r = new Random();
        if (r.nextInt(101) <= ataque.getPrecision()) {
            return enemigo.recibirDanio(ataque);
        } else {
            System.out.println(this.nombre + " falló el ataque " + ataque);
            return false;
        }
    }


    //Métodos para recibir daño
    public boolean recibirDanio(Movimiento ataque) {
        double modificador = tipo.ventajaTipo(ataque.getTipo(), this.tipo);
        int danioTotal = (int) ((ataque.getPotencia() * modificador) - this.defensa);

        danioTotal = Math.max(danioTotal, 1);

        this.vida -= danioTotal;

        System.out.println(this.nombre + " recibió " + danioTotal + " de daño. Vida restante: " + this.vida);

        if (this.vida <= 0) {
            System.out.println("El pokemon " + this.nombre + " se ha debilitado.");
            return true;
        }
        return false;
    }

}
