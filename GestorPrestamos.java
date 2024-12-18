import java.util.ArrayList;
import java.util.List;

public class GestorPrestamos {
    private List<Prestamo> prestamos;

    public GestorPrestamos() {
        prestamos = new ArrayList<>();
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public boolean eliminarPrestamo(Prestamo prestamo) {
        return prestamos.remove(prestamo); // Devuelve true si se eliminó, false si no estaba
    }

    public Prestamo buscarPrestamo(Libro libro, Usuario usuario) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibro().equals(libro) && prestamo.getUsuario().equals(usuario)) {
                return prestamo;
            }
        }
        return null;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void mostrarPrestamos() {
        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo);
        }
    }
}