public class Nodo {
    private Libro libro; // Cambiado a Libro
    private Nodo siguiente;

    public Nodo(Libro libro) {
        this.libro = libro;
        this.siguiente = null;
    }

    public Libro getLibro() {
        return this.libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setSiguiente(Nodo sig) {
        this.siguiente = sig;
    }

    public Nodo getSiguiente() {
        return this.siguiente;
    }
}