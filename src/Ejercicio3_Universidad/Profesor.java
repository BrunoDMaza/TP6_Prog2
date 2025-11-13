package Ejercicio3_Universidad;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    
    private String id;
    private String nombre; 
   
    private List<Curso> cursosDictados; 

    public Profesor(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.cursosDictados = new ArrayList<>();
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public List<Curso> getCursosDictados() { return cursosDictados; }

    
    public void agregarCurso(Curso c) {
        if (!cursosDictados.contains(c)) {
            cursosDictados.add(c);
        }
    }
    
   
    public void quitarCurso(Curso c) {
        cursosDictados.remove(c);
    }
    
    
    
    public void listarCursos() {
        if (cursosDictados.isEmpty()) {
            System.out.println("   -> No dicta cursos asignados.");
            return;
        }
        for (Curso curso : cursosDictados) {
            System.out.println("   -> " + curso.getNombre() + " (" + curso.getCodigo() + ")");
        }
    }

    @Override
    public String toString() {
        return "Profesor [ID: " + id + ", Nombre: " + nombre + ", Cursos: " + cursosDictados.size() + "]";
    }
}