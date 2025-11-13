
package Ejercicio3_Universidad;

public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("== INICIO EJERCICIO 3: UNIVERSIDAD Y BIDIRECCIONALIDAD ==");
        
        Universidad utn = new Universidad("UTN Buenos Aires");
        
        // TAREA 1: Crear al menos 3 profesores y 5 cursos.
        System.out.println("\n--- TAREA 1: CREACIÓN DE OBJETOS ---");

        Profesor p1 = new Profesor("P101", "Ana Garcia");
        Profesor p2 = new Profesor("P102", "Juan Perez");
        Profesor p3 = new Profesor("P103", "Laura Gomez");
        
        Curso c1 = new Curso("C201", "Programación II");
        Curso c2 = new Curso("C202", "Bases de Datos");
        Curso c3 = new Curso("C203", "Arquitectura de PCs");
        Curso c4 = new Curso("C204", "Inglés Técnico");
        Curso c5 = new Curso("C205", "Matemática Superior");
        Curso c6 = new Curso("C206", "Algoritmos"); 

        // TAREA 2: Agregar profesores y cursos a la universidad
        System.out.println("\n--- TAREA 2: AGREGAR A LA UNIVERSIDAD ---");
        utn.agregarProfesor(p1);
        utn.agregarProfesor(p2);
        utn.agregarProfesor(p3);
        System.out.println("-> 3 Profesores agregados.");

        utn.agregarCurso(c1);
        utn.agregarCurso(c2);
        utn.agregarCurso(c3);
        utn.agregarCurso(c4);
        utn.agregarCurso(c5);
        utn.agregarCurso(c6);
        System.out.println("-> 6 Cursos agregados.");

        // TAREA 3: Asignar profesores a cursos usando asignarProfesorACurso(...)
        System.out.println("\n--- TAREA 3: ASIGNACIÓN INICIAL ---");
        // Ana (P101) dicta 2 cursos
        utn.asignarProfesorACurso("C201", "P101"); // Prog II -> Ana
        utn.asignarProfesorACurso("C202", "P101"); // BD -> Ana
        // Juan (P102) dicta 2 cursos
        utn.asignarProfesorACurso("C203", "P102"); // Arqui -> Juan
        utn.asignarProfesorACurso("C206", "P102"); // Algoritmos -> Juan
        // Laura (P103) dicta 1 curso
        utn.asignarProfesorACurso("C204", "P103"); // Inglés -> Laura
        // Curso c5 (Matemática Superior) queda sin asignar.
        System.out.println("-> Asignaciones completadas. Lógica bidireccional activada.");

        // TAREA 4: Listar cursos con su profesor y profesores con sus cursos
        utn.listarCursos();
        utn.listarProfesores(); // Verifica la sincronización (Ana=2, Juan=2, Laura=1)

        // TAREA 5: Cambiar el profesor de un curso y verificar sincronización
        System.out.println("\n--- TAREA 5: CAMBIO DE PROFESOR Y VERIFICACIÓN ---");
        System.out.println("-> C201 (Prog II) pasa de Ana (P101) a Juan (P102).");
        utn.asignarProfesorACurso("C201", "P102"); 
        
        System.out.println("\n*** Verificación de Cursos Dictados: ***");
        System.out.println("Ana (P101) debe tener 1 curso (BD):");
        utn.buscarProfesorPorId("P101").listarCursos(); 
        System.out.println("\nJuan (P102) debe tener 3 cursos (Arqui, Algoritmos, Prog II):");
        utn.buscarProfesorPorId("P102").listarCursos(); 
        
        // TAREA 6: Remover un curso y confirmar que ya no aparece en la lista del profesor
        System.out.println("\n--- TAREA 6: REMOVER CURSO (C202) Y VERIFICAR ---");
        Profesor p1Antes = utn.buscarProfesorPorId("P101");
        System.out.println("Ana antes de eliminar C202: " + p1Antes.getCursosDictados().size() + " cursos.");
        
        utn.eliminarCurso("C202");
        
        System.out.println("\n*** Verificación de P101 (Ana) después de eliminar C202 ***");
        p1Antes.listarCursos(); 
        
        // TAREA 7: Remover un profesor y dejar profesor = null en los cursos
        System.out.println("\n--- TAREA 7: REMOVER PROFESOR (P103) Y DESVINCULAR CURSOS ---");
        utn.eliminarProfesor("P103");
        
        System.out.println("\n*** Verificación del curso C204 (Inglés Técnico) ***");
        System.out.println(utn.buscarCursoPorCodigo("C204")); 
        
        // TAREA 8: Mostrar un reporte: cantidad de cursos por profesor
        utn.reporteCursosPorProfesor();
        
        System.out.println("\n== FIN DE TAREAS ==");
    }
}