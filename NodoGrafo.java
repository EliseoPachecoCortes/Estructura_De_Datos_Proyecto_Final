
public class NodoGrafo {
    private Object dato; // Puede ser un autor o un libro
    private Lista listaAdyacencia; // Lista de adyacencia para las conexiones
    private NodoGrafo siguiente; // Siguiente nodo en la lista

    public NodoGrafo(Object dato) {
        this.dato = dato;
        this.listaAdyacencia = new Lista();
        this.siguiente = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Lista getListaAdyacencia() {
        return listaAdyacencia;
    }

    public void setListaAdyacencia(Lista listaAdyacencia) {
        this.listaAdyacencia = listaAdyacencia;
    }

    public NodoGrafo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoGrafo siguiente) {
        this.siguiente = siguiente;
    }
}
