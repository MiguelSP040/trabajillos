package Ejercicio2;

public class Tarea {
    private String nombre, descripcion, fecha;
    private Boolean pendiente;

    public Tarea() {
    }

    public Tarea(String nombre, String descripcion, String fecha, Boolean pendiente) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.pendiente = pendiente;
    }

    public String getNombre() {
        return nombre;
    }

    public Tarea setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Tarea setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public String getFecha() {
        return fecha;
    }

    public Tarea setFecha(String fecha) {
        this.fecha = fecha;
        return this;
    }

    public Boolean isPendiente() {
        return pendiente;
    }

    public Tarea setPendiente(Boolean pendiente) {
        this.pendiente = pendiente;
        return this;
    }

    @Override
    public String toString(){
        String estado = pendiente ? "Pendiente" : "Hecho/a";
        return "Nombre: " + this.nombre + "\n" +
                "Descripción: " + this.descripcion + "\n" +
                "Fecha: " + this.fecha+ "\n" +
                "Estado: " + estado;
    }
}
