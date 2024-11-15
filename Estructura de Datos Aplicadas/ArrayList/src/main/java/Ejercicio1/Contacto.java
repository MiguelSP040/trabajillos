package Ejercicio1;

public class Contacto {
    public String nombre;
    public String apellido;
    public String telefono;

    public Contacto() {
    }

    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public Contacto setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public Contacto setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public String getTelefono() {
        return telefono;
    }

    public Contacto setTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + '\n' +
                "Apellido: " + apellido + '\n' +
                "Telefono: " + telefono + '\n';
    }
}
