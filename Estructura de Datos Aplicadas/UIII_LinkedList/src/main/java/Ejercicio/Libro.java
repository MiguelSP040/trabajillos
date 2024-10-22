package Ejercicio;

public class Libro {
    public String titulo;
    public String autor;
    public int anioPublicacion;

    public Libro() {
    }

    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + '\n' +
                "Autor: " + autor + '\n' +
                "Año de publicación: " + anioPublicacion +
                '\n';
    }

    public String getTitulo() {
        return titulo;
    }

    public Libro setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getAutor() {
        return autor;
    }

    public Libro setAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public Libro setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
        return this;
    }
}
