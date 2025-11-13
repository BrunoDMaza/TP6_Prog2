package Ejercicio2_Biblioteca;

public class Autor {
    
    private String idAutor;
    private String nombre;
    private String apellido;

    // Constructor
    public Autor(String idAutor, String nombre, String apellido) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters
    public String getIdAutor() {
        return idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    @Override
    public String toString() {
        return "Autor [ID=" + idAutor + ", Nombre=" + nombre + " " + apellido + "]";
    }
    
}
