import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        String archivoCSV = "C:/Users/EXANIME DE CANCER/Documents/Libreria.csv";

        // Cargar libros desde el archivo CSV
        cargarLibrosDesdeCSV(libreria, archivoCSV);

        // Crear el menú y pasar la librería
        Menu menu = new Menu(libreria);
        menu.mostrarMenu();
    }

    private static void cargarLibrosDesdeCSV(Libreria libreria, String archivoCSV) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            // Leer la primera línea (cabecera)
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); // Suponiendo que el separador es una coma
                if (datos.length == 3) {
                    String titulo = datos[0].trim();
                    String autorNombre = datos[1].trim();
                    String categoriaNombre = datos[2].trim();

                    // Crear o buscar el autor
                    Autor autor = buscarAutor(libreria, autorNombre);
                    if (autor == null) {
                        autor = new Autor(autorNombre);
                        libreria.agregarAutor(autor);
                    }

                    // Crear o buscar la categoría
                    Categoria categoria = buscarCategoria(libreria, categoriaNombre);
                    if (categoria == null) {
                        categoria = new Categoria(categoriaNombre);
                        libreria.agregarCategoria(categoria);
                    }

                    // Crear el libro y agregarlo a la librería
                    Libro nuevoLibro = new Libro(titulo, autor, categoria);
                    libreria.agregarLibro(nuevoLibro);
                } else {
                    System.out.println("Formato de línea incorrecto: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static Autor buscarAutor(Libreria libreria, String nombreAutor) {
        for (Autor autor : libreria.getAutores()) {
            if (autor.getNombre().equalsIgnoreCase(nombreAutor)) {
                return autor;
            }
        }
        return null; // Si no se encuentra el autor, devolver null
    }

    private static Categoria buscarCategoria(Libreria libreria, String nombreCategoria) {
    for (Categoria categoria : libreria.getCategorias()) {
        if (categoria.getNombre().equalsIgnoreCase(nombreCategoria)) {
            return categoria;
        }
    }
    return null; // Si no se encuentra la categoría, devolver null
}
}