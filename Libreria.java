import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Libreria {
    private List<Libro> libros;
    private List<Autor> autores;
    private ArbolAVL<Categoria> categorias; // Asegúrate de que ArbolAVL esté parametrizado
    private List<Usuario> usuarios;
    private Grafo grafo;
    private GestorPrestamos gestorPrestamos; // Cambiado a GestorPrestamos
    private PilaObject pilaAcciones;

    public Libreria() {
        libros = new ArrayList<>();
        autores = new ArrayList<>();
        categorias = new ArbolAVL<>(); // Inicializar ArbolAVL
        usuarios = new ArrayList<>();
        grafo = new Grafo();
        gestorPrestamos = new GestorPrestamos(); // Inicializar GestorPrestamos
        pilaAcciones = new PilaObject(100);
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public List<Categoria> getCategorias() {
        return categorias.obtenerCategorias(); // Método que devuelve la lista de categorías
    }
    
    public void agregarLibro(Libro libro) {
        // Agregar el libro a la lista de libros
        libros.add(libro);
        
        // Agregar el libro al grafo
        grafo.agregarNodo(libro);
        
        // Agregar el autor al grafo (si no está ya presente)
        if (!autores.contains(libro.getAutor())) {
            autores.add(libro.getAutor());
            grafo.agregarNodo(libro.getAutor());
        }
        
        // Establecer la conexión entre el libro y el autor
        grafo.agregarConexion(libro.getAutor(), libro);
        
        System.out.println("Libro agregado exitosamente: " + libro.getTitulo());
    }

    public void agregarAutor(Autor autor) {
        if (!autores.contains(autor)) {
            autores.add(autor);
            grafo.agregarNodo(autor);
        }
    }

    public void agregarCategoria(Categoria categoria) {
        categorias.insertar(categoria);
    }

    public void mostrarLibrosDeAutor(Autor autor) {
        System.out.println("Libros de " + autor.getNombre() + ":");
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                System.out.println(" - " + libro.getTitulo());
            }
        }
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void prestarLibro(Libro libro, Usuario usuario) {
        Date fechaPrestamo = new Date();
        Prestamo prestamo = new Prestamo(libro, usuario, fechaPrestamo);
        gestorPrestamos.agregarPrestamo(prestamo); // Usar GestorPrestamos
        pilaAcciones.push(prestamo); // Guardar la acción en la pila
    }

    public void devolverLibro(Libro libro, Usuario usuario) {
        // Buscar el préstamo correspondiente usando GestorPrestamos
        Prestamo prestamo = gestorPrestamos.buscarPrestamo(libro, usuario);
        if (prestamo != null) {
            prestamo.marcarComoDevuelto(); // Marcar el préstamo como devuelto
            System.out.println("Devolución registrada para el libro: " + libro.getTitulo() + " por el usuario: " + usuario.getNombre());
        } else {
            System.out.println("No se encontró un préstamo activo para el libro: " + libro.getTitulo() + " por el usuario: " + usuario.getNombre());
        }
    }

    public void mostrarLibros() {
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public void mostrarUsuarios() {
        for (Usuario usuario : usuarios){
            System.out.println(usuario);
        }
    }

    public void mostrarCategorias() {
        System.out.println("--- Lista de Categorías ---");
        for (Categoria categoria : getCategorias()) {
            System.out.println(categoria);
        }
    }

    public void mostrarGrafo() {
        grafo.mostrarGrafo();
    }

    public void deshacerUltimaAccion() throws Exception {
        if (!pilaAcciones.estavacia()) {
            Prestamo prestamo = (Prestamo) pilaAcciones.pop();
            
            // Eliminar el préstamo del GestorPrestamos
            boolean eliminado = gestorPrestamos.eliminarPrestamo(prestamo);
            
            if (eliminado) {
                System.out.println("Última acción deshecha: " + prestamo);
                System.out.println("Préstamo eliminado exitosamente.");
            } else {
                System.out.println("No se pudo eliminar el préstamo: " + prestamo);
            }
        } else {
            System.out.println("No hay acciones para deshacer.");
        }
    }

    public void mostrarPrestamos() {
        if (gestorPrestamos.getPrestamos().isEmpty()) {
            System.out.println("No hay préstamos registrados.");
            return;
        }
        System.out.println("--- Lista de Préstamos ---");
        gestorPrestamos.mostrarPrestamos(); // Usar GestorPrestamos para mostrar préstamos
    }
    
    public void ordenarLibrosPorTitulo() {
        // Extraer los títulos en un arreglo
        String[] titulos = new String[libros.size()];
        for (int i = 0; i < libros.size(); i++) {
            titulos[i] = libros.get(i).getTitulo();
        }
    
        // Crear un arreglo de índices
        int[] indices = new int[libros.size()];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
    
        // Crear una instancia de QuickSort
        QuickSort quickSort = new QuickSort();
        // Ordenar los índices basados en los títulos
        quickSort.sort(indices);
    
        // Crear una nueva lista de libros ordenados
        List<Libro> librosOrdenados = new ArrayList<>();
        for (int index : indices) {
            librosOrdenados.add(libros.get(index));
        }
    
        // Reemplazar la lista original de libros con la lista ordenada
        libros = librosOrdenados;
    
        System.out.println("Libros ordenados por título:");
        mostrarLibros();
    }   

    private int[] convertirTitulosAIndices(String[] titulos) {
        int[] indices = new int[titulos.length];
        for (int i = 0; i < titulos.length; i++) {
            indices[i] = i;
        }
        return indices;
    }

    public void agregarRelacion(Autor autor, Libro libro) {
        grafo.agregarConexion(autor, libro);
    }
}