package Ejercicio2_Biblioteca;

public class Libro {
    
    private String isbn;
    private String titulo;
    private int anioPublicacion;
    private Autor autor; // Relación 1 a 1

    // Constructor
    public Libro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
    }

    // Getters
    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Libro [ISBN=" + isbn + ", Título=" + titulo + ", Año=" + anioPublicacion + 
               ", " + autor.toString() + "]"; // Llama al toString del Autor
    }
}
