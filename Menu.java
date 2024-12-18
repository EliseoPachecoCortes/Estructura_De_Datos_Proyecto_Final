import java.util.Scanner;

public class Menu {
    private Libreria libreria;
    private Scanner scanner;

    public Menu(Libreria libreria) {
        this.libreria = libreria;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de la Librería ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Agregar autor");
            System.out.println("3. Agregar categoría");
            System.out.println("4. Agregar usuario");
            System.out.println("5. Prestar libro");
            System.out.println("6. Devolver libro");
            System.out.println("7. Mostrar libros");
            System.out.println("8. Mostrar usuarios");
            System.out.println("9. Mostrar categorías");
            System.out.println("10. Mostrar préstamos");
            System.out.println("11. Mostrar libros por autores");
            System.out.println("12. Ordenar libros por título");
            System.out.println("13. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    agregarAutor();
                    break;
                case 3:
                    agregarCategoria();
                    break;
                case 4:
                    agregarUsuario();
                    break;
                case 5:
                    prestarLibro();
                    break;
                case 6:
                    devolverLibro();
                    break;
                case 7:
                    libreria.mostrarLibros();
                    break;
                case 8:
                    libreria.mostrarUsuarios();
                    break;
                case 9:
                    libreria.mostrarCategorias();
                    break;
                case 10:
                    libreria.mostrarPrestamos(); // Asegúrate de que este método esté implementado en Libreria
                    break;
                case 11:
                    mostrarLibrosPorAutores();
                    break;
                case 12:
                    libreria.ordenarLibrosPorTitulo();
                    System.out.println("Libros ordenados por título.");
                    break;
                case 13:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 13);
        scanner.close();
    }

    private void agregarLibro() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el nombre del autor: ");
        String nombreAutor = scanner.nextLine();
        System.out.print("Ingrese el nombre de la categoría: ");
        String nombreCategoria = scanner.nextLine();

        Autor autor = new Autor(nombreAutor);
        Categoria categoria = new Categoria(nombreCategoria);
        Libro libro = new Libro(titulo, autor, categoria);

        libreria.agregarLibro(libro);
        libreria.agregarAutor(autor);
        libreria.agregarCategoria(categoria);
        System.out.println("Libro agregado exitosamente.");
    }

    private void agregarAutor() {
        System.out.print("Ingrese el nombre del autor: ");
        String nombreAutor = scanner.nextLine();
        Autor autor = new Autor(nombreAutor);
        libreria.agregarAutor(autor);
        System.out.println("Autor agregado exitosamente.");
    }

    private void agregarCategoria() {
        System.out.print("Ingrese el nombre de la categoría: ");
        String nombreCategoria = scanner.nextLine();
        Categoria categoria = new Categoria(nombreCategoria);
        libreria.agregarCategoria(categoria);
        System.out.println("Categoría agregada exitosamente.");
    }

    private void agregarUsuario() {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombreUsuario = scanner.nextLine();
        Usuario usuario = new Usuario(nombreUsuario);
        libreria.agregarUsuario(usuario);
        System.out.println("Usuario agregado exitosamente.");
    }

    private void prestarLibro() {
        System.out.print("Ingrese el título del libro a prestar: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el nombre del usuario: ");
        String nombreUsuario = scanner.nextLine();

        Libro libro = buscarLibro(titulo);
        Usuario usuario = buscarUsuario(nombreUsuario);

        if (libro != null && usuario != null) {
            libreria.prestarLibro(libro, usuario);
            System.out.println("Libro prestado exitosamente.");
        } else {
            System.out.println("Libro o usuario no encontrado.");
        }
    }

    private void devolverLibro() {
        System.out.print("Ingrese el título del libro a devolver: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el nombre del usuario: ");
        String nombreUsuario = scanner.nextLine();

        Libro libro = buscarLibro(titulo);
        Usuario usuario = buscarUsuario(nombreUsuario);

        if (libro != null && usuario != null) {
            libreria.devolverLibro(libro, usuario);
            System.out.println("Libro devuelto exitosamente.");
        } else {
            System.out.println("Libro o usuario no encontrado.");
        }
    }

    private Libro buscarLibro(String titulo) {
        for (Libro libro : libreria.getLibros()) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    private Usuario buscarUsuario(String nombre) {
        for (Usuario usuario : libreria.getUsuarios()) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                return usuario;
            }
        }
        return null;
    }
    
    private void mostrarLibrosPorAutores() {
        for (Autor autor : libreria.getAutores()) {
            libreria.mostrarLibrosDeAutor(autor);
        }
    }
}