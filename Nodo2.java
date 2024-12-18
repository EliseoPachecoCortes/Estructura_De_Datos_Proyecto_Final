public class Nodo2 {
    private Prestamo prestamo;
    private Nodo2 siguiente;

    public Nodo2(Prestamo prestamo) {
        this.prestamo = prestamo;
        this.siguiente = null;
    }

    public Prestamo getPrestamo() {
        return this.prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public void setSiguiente(Nodo2 sig) {
        this.siguiente = sig;
    }

    public Nodo2 getSiguiente() {
        return this.siguiente;
    }
}