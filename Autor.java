import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String nombre;
    private List<Libro> libros; // Lista de libros escritos por el autor

    public Autor(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public List<Libro> getLibros() {
        return libros;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Autor{nombre='").append(nombre).append("', libros=[");
        for (int i = 0; i < libros.size(); i++) {
            sb.append(libros.get(i).getTitulo());
            if (i < libros.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }
}
