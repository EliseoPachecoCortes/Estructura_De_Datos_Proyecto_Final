import java.util.ArrayList;
import java.util.List;

public class ColaDinamica {
    private Nodo2 primero;
    private Nodo2 ultimo;

    public ColaDinamica() {
        this.primero = null;
        this.ultimo = null;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public boolean agregar(Prestamo prestamo) {
        Nodo2 n = new Nodo2(prestamo);
        if (estaVacia()) {
            this.primero = n;
            this.ultimo = n;
            return true;
        }
        this.ultimo.setSiguiente(n);
        this.ultimo = n;
        return true;
    }

    public Prestamo eliminar() throws Exception {
        if (estaVacia())
            throw new Exception("Cola Vacia");
        Prestamo auxPrestamo = primero.getPrestamo();
        this.primero = this.primero.getSiguiente();
        return auxPrestamo;
    }

    public Prestamo verPrimero() throws Exception {
        if (estaVacia())
            throw new Exception("Cola Vacia");
        return primero.getPrestamo();
    }

    // Nuevo método para obtener todos los préstamos
    public List<Prestamo> obtenerPrestamos() {
        List<Prestamo> listaPrestamos = new ArrayList<>();
        Nodo2 actual = primero;
        while (actual != null) {
            listaPrestamos.add(actual.getPrestamo());
            actual = actual.getSiguiente();
        }
        return listaPrestamos;
    }
}
