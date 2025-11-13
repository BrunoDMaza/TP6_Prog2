package Ejercicio3_Universidad;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    
    private String nombre; 
    private List<Profesor> profesores; 
    private List<Curso> cursos; 

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    
    public String getNombre() { return nombre; }
    public void agregarProfesor(Profesor p) { profesores.add(p); } 
    public void agregarCurso(Curso c) { cursos.add(c); } 

    public Profesor buscarProfesorPorId(String id) { 
        for (Profesor p : profesores) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public Curso buscarCursoPorCodigo(String codigo) { 
        for (Curso c : cursos) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }
    
   
    public boolean asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        Profesor profesor = buscarProfesorPorId(idProfesor);

        if (curso == null) {
            System.out.println("ERROR: Curso " + codigoCurso + " no encontrado.");
            return false;
        }        
        if (profesor == null && idProfesor != null) { 
            System.out.println("ADVERTENCIA: Profesor " + idProfesor + " no encontrado. Se desvincula el curso.");
        }        
        curso.setProfesor(profesor);
        return true;
    }
    
    public boolean eliminarCurso(String codigo) {
        Curso curso = buscarCursoPorCodigo(codigo);
        
        if (curso != null) {
            curso.setProfesor(null); 
            cursos.remove(curso);
            System.out.println("Curso " + curso.getNombre() + " eliminado exitosamente.");
            return true;
        }
        System.out.println("ERROR: Curso con código " + codigo + " no encontrado para eliminar.");
        return false;
    }

    public boolean eliminarProfesor(String id) {
        Profesor profesor = buscarProfesorPorId(id);
        
        if (profesor != null) {
            
            List<Curso> cursosADesvincular = new ArrayList<>(profesor.getCursosDictados()); 
            for (Curso curso : cursosADesvincular) {
                curso.setProfesor(null);
            }
            profesores.remove(profesor);
            System.out.println("   -> Profesor " + profesor.getNombre() + " eliminado exitosamente.");
            return true;
        }
        System.out.println("   -> ERROR: Profesor con ID " + id + " no encontrado para eliminar.");
        return false;
    }

    public void listarProfesores() {
        System.out.println("\n--- LISTADO DE PROFESORES Y SUS CURSOS ---");
        for (Profesor p : profesores) {
            System.out.println(p);
            p.listarCursos();
        }
    }

    public void listarCursos() {
        System.out.println("\n--- LISTADO DE CURSOS Y SU PROFESOR ---");
        for (Curso c : cursos) {
            System.out.println(c);
        }
    }
    
    public void reporteCursosPorProfesor() {
        System.out.println("\n--- TAREA 8: REPORTE DE CANTIDAD DE CURSOS POR PROFESOR ---");
        for (Profesor p : profesores) {
            int cantidad = p.getCursosDictados().size();
            System.out.println("Profesor " + p.getNombre() + " (ID: " + p.getId() + "): " + cantidad + " curso(s).");
        }
    }
}
