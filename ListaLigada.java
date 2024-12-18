public class ListaLigada {
    private Nodo primero;
    private Nodo ultimo;

    public ListaLigada() {
        this.primero = null;
        this.ultimo = null;
    }

    public boolean estaVacia() {
        return primero == null && ultimo == null;
    }

    public boolean agregarAlInicio(Libro libro) {
        Nodo nN = new Nodo(libro);
        if (estaVacia()) {
            this.primero = nN;
            this.ultimo = nN;
            return true;
        }
        nN.setSiguiente(primero);
        primero = nN;
        return true;
    }

    public boolean agregarAlFinal(Libro libro) {
        Nodo nN = new Nodo(libro);
        if (estaVacia()) {
            this.primero = nN;
            this.ultimo = nN;
            return true;
        }
        this.ultimo.setSiguiente(nN);
        this.ultimo = nN;
        return true;
    }

    public Libro eliminarAlInicio() throws Exception {
        if (estaVacia())
            throw new Exception("Lista vacía");
        Libro libroAux = primero.getLibro();
        primero = primero .getSiguiente();
        return libroAux;
    }

    public Libro eliminarAlFinal() throws Exception {
        if (estaVacia())
            throw new Exception("Lista vacía");
        Nodo nodoAux = primero;
        while (nodoAux.getSiguiente() != null && nodoAux.getSiguiente().getSiguiente() != null) {
            nodoAux = nodoAux.getSiguiente();
        }
        Libro libroAux = ultimo.getLibro();
        ultimo = nodoAux;
        ultimo.setSiguiente(null);
        return libroAux;
    }

    public Nodo getPrimero() {
        return primero; // Método para obtener el primer nodo
    }
}