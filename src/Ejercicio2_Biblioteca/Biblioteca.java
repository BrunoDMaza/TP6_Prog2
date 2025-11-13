package Ejercicio2_Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    
    private String nombre; 
    private List<Libro> libros; 

    // Constructor
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        // Inicialización de la colección
        this.libros = new ArrayList<>(); 
    }

    public String getNombre() {
        return nombre;
    }
    
    public void agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        Libro nuevoLibro = new Libro(isbn, titulo, anioPublicacion, autor);
        libros.add(nuevoLibro);
        System.out.println("✅ Libro agregado: " + titulo);
    }

    
    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("La biblioteca '" + nombre + "' está vacía.");
            return;
        }
        System.out.println("\n--- LISTADO DE LIBROS EN " + nombre.toUpperCase() + " ---");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

   
    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro; 
            }
        }
        return null;
    }

        public boolean eliminarLibro(String isbn) {
        Libro libroAEliminar = buscarLibroPorIsbn(isbn);
        
        if (libroAEliminar != null) {
            libros.remove(libroAEliminar); 
            System.out.println("🗑️ Libro eliminado con ISBN: " + isbn + " (" + libroAEliminar.getTitulo() + ")");
            return true;
        }
        System.out.println("❌ Error: Libro con ISBN " + isbn + " no encontrado para eliminar.");
        return false;
    }

    
    public int obtenerCantidadLibros() {
        return libros.size();
    }

    public List<Libro> filtrarLibrosPorAnio(int anio) {
        List<Libro> filtrados = new ArrayList<>(); 
        
        for (Libro libro : libros) {
            if (libro.getAnioPublicacion() == anio) {
                filtrados.add(libro);
            }
        }
        return filtrados;
    }

    public void mostrarAutoresDisponibles() {
        System.out.println("\n--- AUTORES DISPONIBLES EN LA BIBLIOTECA (" + nombre.toUpperCase() + ") ---");
        
        List<Autor> autoresUnicos = new ArrayList<>();
        
        for (Libro libro : libros) {
            Autor autorActual = libro.getAutor();
            if (!autoresUnicos.contains(autorActual)) {
                autoresUnicos.add(autorActual);
            }
        }
        
        if (autoresUnicos.isEmpty()) {
            System.out.println("No hay autores registrados.");
            return;
        }

        for (Autor autor : autoresUnicos) {
            System.out.println(autor); 
        }
    }
}
