
package Ejercicio1_Producto;


public class Main {
   public static void main(String[] args) {
        Inventario inventario = new Inventario();
        
        System.out.println("========================================");
        System.out.println("   SISTEMA DE GESTIÓN DE STOCK");
        System.out.println("========================================\n");
        
        // 1. Crear y agregar productos
        System.out.println("1. CREANDO Y AGREGANDO PRODUCTOS...\n");
        inventario.agregarProducto(new Producto("P001", "Arroz Integral", 1200.0, 50, CategoriaProducto.ALIMENTOS));
        inventario.agregarProducto(new Producto("P002", "Laptop Lenovo", 85000.0, 15, CategoriaProducto.ELECTRONICA));
        inventario.agregarProducto(new Producto("P003", "Remera Deportiva", 2500.0, 30, CategoriaProducto.ROPA));
        inventario.agregarProducto(new Producto("P004", "Sartén Antiadherente", 4500.0, 20, CategoriaProducto.HOGAR));
        inventario.agregarProducto(new Producto("P005", "Smartphone Samsung", 120000.0, 8, CategoriaProducto.ELECTRONICA));
        
        // 2. Listar todos los productos
        System.out.println("\n2. LISTANDO TODOS LOS PRODUCTOS...");
        inventario.listarProductos();
        
        // 3. Buscar producto por ID
        System.out.println("\n3. BUSCANDO PRODUCTO POR ID (P002)...");
        Producto buscado = inventario.buscarProductoPorId("P002");
        if (buscado != null) {
            System.out.println("Producto encontrado:");
            buscado.mostrarInfo();
        }
        
        // 4. Filtrar por categoría
        System.out.println("\n4. FILTRANDO POR CATEGORÍA ELECTRÓNICA...");
        inventario.filtrarPorCategoria(CategoriaProducto.ELECTRONICA);
        
        // 5. Eliminar producto
        System.out.println("\n5. ELIMINANDO PRODUCTO (P003)...");
        inventario.eliminarProducto("P003");
        inventario.listarProductos();
        
        // 6. Actualizar stock
        System.out.println("\n6. ACTUALIZANDO STOCK DEL PRODUCTO P001...");
        inventario.actualizarStock("P001", 75);
        
        // 7. Mostrar total de stock
        System.out.println("\n7. TOTAL DE STOCK DISPONIBLE...");
        System.out.println("Total de unidades en stock: " + inventario.obtenerTotalStock());
        
        // 8. Producto con mayor stock
        System.out.println("\n8. PRODUCTO CON MAYOR STOCK...");
        Producto mayorStock = inventario.obtenerProductoConMayorStock();
        if (mayorStock != null) {
            System.out.println("Producto con mayor stock:");
            mayorStock.mostrarInfo();
        }
        
        // 9. Filtrar por precio
        System.out.println("\n9. FILTRANDO PRODUCTOS ENTRE $1000 Y $3000...");
        inventario.filtrarProductosPorPrecio(1000, 3000);
        
        // 10. Mostrar categorías disponibles
        System.out.println("\n10. CATEGORÍAS DISPONIBLES...");
        inventario.mostrarCategoriasDisponibles();
        
        System.out.println("\n========================================");
        System.out.println("   FIN DEL PROGRAMA");
        System.out.println("========================================");
    }
       
}


