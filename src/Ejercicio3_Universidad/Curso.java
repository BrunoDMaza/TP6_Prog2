package Ejercicio3_Universidad;

public class Curso {
    
    private String codigo; 
    private String nombre; 
    
    private Profesor profesorAsignado; 

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesorAsignado = null; 
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Profesor getProfesorAsignado() { return profesorAsignado; }

    
    public void setProfesor(Profesor nuevoProfesor) {
        if (this.profesorAsignado != null) {
            this.profesorAsignado.quitarCurso(this); 
        }
        this.profesorAsignado = nuevoProfesor;
        if (this.profesorAsignado != null) {
            this.profesorAsignado.agregarCurso(this); 
        }
    }

    @Override
    public String toString() {
        String prof = (profesorAsignado != null) ? profesorAsignado.getNombre() : "Sin asignar";
        return "Curso [Código: " + codigo + ", Nombre: " + nombre + ", Profesor: " + prof + "]";
    }
}
