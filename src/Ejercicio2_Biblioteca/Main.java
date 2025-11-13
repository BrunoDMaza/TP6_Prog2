
package Ejercicio2_Biblioteca;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        // TAREA 1: Creación de la instancia de Biblioteca
        
        System.out.println("== GESTIÓN DE BIBLIOTECA UTN ==");
        Biblioteca bibliotecaUTN = new Biblioteca("Biblioteca Central UTN");
        System.out.println("✅ TAREA 1: Biblioteca '" + bibliotecaUTN.getNombre() + "' creada.");

        // TAREA 2: Creación de al menos 3 autores
        
        System.out.println("\n--- TAREA 2: CREACIÓN DE AUTORES ---");
        Autor autor1 = new Autor("A101", "Gabriel", "García Márquez");
        Autor autor2 = new Autor("A102", "Jane", "Austen");
        Autor autor3 = new Autor("A103", "Jorge Luis", "Borges");
        Autor autor4 = new Autor("A104", "Jane", "Austen"); // Mismo nombre/apellido, diferente ID (Ejemplo)

        System.out.println(autor1);
        System.out.println(autor2);
        System.out.println(autor3);

        // TAREA 3: Agregar al menos 5 libros a la biblioteca
        
        System.out.println("\n--- TAREA 3: AGREGAR LIBROS ---");
        // Libros de García Márquez (1967, 1985)
        bibliotecaUTN.agregarLibro("978-0307474728", "Cien años de soledad", 1967, autor1);
        bibliotecaUTN.agregarLibro("978-0307474735", "El amor en los tiempos del cólera", 1985, autor1);

        // Libros de Jane Austen (1813, 1813)
        bibliotecaUTN.agregarLibro("978-0141439518", "Orgullo y Prejuicio", 1813, autor2);
        bibliotecaUTN.agregarLibro("978-0140430154", "Sentido y Sensibilidad", 1813, autor2);
        
        // Libros de Borges (1944)
        bibliotecaUTN.agregarLibro("978-8420633116", "Ficciones", 1944, autor3);
        
        // TAREA 4: Listar todos los libros en la biblioteca

        System.out.println("\n--- TAREA 4: LISTADO COMPLETO ---");
        bibliotecaUTN.listarLibros();
        
        // TAREA 5: Búsqueda de un libro por ISBN
        
        System.out.println("\n--- TAREA 5: BÚSQUEDA POR ISBN ---");
        String isbnBuscado = "978-0141439518"; // Orgullo y Prejuicio
        Libro libroEncontrado = bibliotecaUTN.buscarLibroPorIsbn(isbnBuscado);
        
        if (libroEncontrado != null) {
            System.out.println("✅ Libro encontrado: " + libroEncontrado.getTitulo());
            System.out.println("   Detalle: " + libroEncontrado);
        } else {
            System.out.println("❌ Libro con ISBN " + isbnBuscado + " no encontrado.");
        }

        // TAREA 6: Filtrar y mostrar libros por año de publicación (Ej: 1813)

        System.out.println("\n--- TAREA 6: FILTRAR LIBROS POR AÑO (1813) ---");
        int anioFiltro = 1813;
        List<Libro> librosFiltrados = bibliotecaUTN.filtrarLibrosPorAnio(anioFiltro);
        
        if (librosFiltrados.isEmpty()) {
            System.out.println("No se encontraron libros publicados en el año " + anioFiltro + ".");
        } else {
            System.out.println("Encontrados " + librosFiltrados.size() + " libros de " + anioFiltro + ":");
            for (Libro libro : librosFiltrados) {
                System.out.println("   -> " + libro.getTitulo() + " (Autor: " + libro.getAutor().getApellido() + ")");
            }
        }
        
        // TAREA 7: Eliminar un libro por ISBN

        System.out.println("\n--- TAREA 7: ELIMINAR LIBRO (Ficciones) ---");
        String isbnAEliminar = "978-8420633116"; // Ficciones
        bibliotecaUTN.eliminarLibro(isbnAEliminar);
        
        // Verificación (opcional)
        System.out.println("\n   -> Cantidad actual de libros: " + bibliotecaUTN.obtenerCantidadLibros());
        
        // TAREA 8: Mostrar la lista de autores (únicos) de los libros en la biblioteca

        bibliotecaUTN.mostrarAutoresDisponibles();
        
        // TAREA 9: Mostrar el stock total de la biblioteca
        
        System.out.println("\n--- TAREA 9: REPORTE DE STOCK TOTAL ---");
        System.out.println("📚 La biblioteca '" + bibliotecaUTN.getNombre() + "' tiene un total de " + bibliotecaUTN.obtenerCantidadLibros() + " libros en stock.");
        
        System.out.println("\n== FIN DE TAREAS ==");
    }
    }

