import java.util.ArrayList;
import java.util.List;

public class Lista {
    private Arista primero; // Primer arista en la lista
    private Arista ultimo; // Última arista en la lista

    public Lista() {
        this.primero = null;
        this.ultimo = null;
    }

    public boolean estaVacia() {
        return this.primero == null && this.ultimo == null;
    }

    public void agregarAdyacencia(Object destino) {
        if (!existe(destino)) {
            Arista nodo = new Arista(destino);
            inserta(nodo);
        }
    }

    public void agregarAdyacencia(Object destino, float peso) {
        if (!existe(destino)) {
            Arista nodo = new Arista(destino, peso);
            inserta(nodo);
        }
    }

    private boolean inserta(Arista nodo) {
        if (estaVacia()) {
            this.primero = nodo;
            this.ultimo = nodo;
            return true;
        }
        this.ultimo.setSiguiente(nodo);
        this.ultimo = nodo;
        return true;
    }

    private boolean existe(Object destino) {
        Arista actual = primero;
        while (actual != null) {
            if (destino.toString().equals(actual.getDestino().toString()))
                return true;
            actual = actual.getSiguiente();
        }
        return false;
    }

    public List<Arista> getAristas() {
        List<Arista> aristas = new ArrayList<>();
        Arista actual = primero;
        while (actual != null) {
            aristas.add(actual);
            actual = actual .getSiguiente();
        }
        return aristas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arista actual = primero;
        while (actual != null) {
            sb.append(actual.getDestino().toString()).append(" -> ");
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }
}