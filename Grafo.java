import java.util.HashMap;
import java.util.Map;

public class Grafo {
    private NodoGrafo primero; // Primer nodo en el grafo
    private Map<Object, NodoGrafo> nodos; // Mapa para acceder a los nodos por su dato

    public Grafo() {
        this.primero = null;
        this.nodos = new HashMap<>();
    }

    public void agregarNodo(Object dato) {
        if (!nodos.containsKey(dato)) {
            NodoGrafo nuevoNodo = new NodoGrafo(dato);
            nodos.put(dato, nuevoNodo);
            if (primero == null) {
                primero = nuevoNodo;
            } else {
                NodoGrafo actual = primero;
                while (actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(nuevoNodo);
            }
        }
    }

    public void agregarConexion(Autor autor, Libro libro) {
        agregarNodo(autor);
        agregarNodo(libro);
        nodos.get(autor).getListaAdyacencia().agregarAdyacencia(libro);
        nodos.get(libro).getListaAdyacencia().agregarAdyacencia(autor);
    }

    public void mostrarGrafo() {
        NodoGrafo actual = primero;
        while (actual != null) {
            System.out.println("Nodo: " + actual.getDato() + " - Conexiones: " + actual.getListaAdyacencia());
            actual = actual.getSiguiente();
        }
    }
    
    public void mostrarLibrosDeAutor(Autor autor) {
        NodoGrafo nodoAutor = nodos.get(autor);
            if (nodoAutor != null) {
                System.out.println("Autor: " + autor.getNombre());
                System.out.println("Libros:");
                for (Arista arista : nodoAutor.getListaAdyacencia().getAristas()) { // Cambiado a getAristas()
                    if (arista.getDestino() instanceof Libro) {
                        System.out.println(" - " + ((Libro) arista.getDestino()).getTitulo());
                    }
                }
            } else {
                System.out.println("Autor no encontrado en el grafo.");
            }
    }
}