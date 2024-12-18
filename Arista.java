
public class Arista {
    private Object destino; // El destino de la arista (puede ser un libro o un autor)
    private float peso; // Peso de la arista
    private Arista siguiente; // Siguiente arista en la lista

    // Constructor para arista sin peso
    public Arista(Object destino) {
        this(destino, 1.0f); // Asignar un peso por defecto de 1.0
    }

    // Constructor para arista con peso
    public Arista(Object destino, float peso) {
        this.destino = destino;
        this.peso = peso;
        this.siguiente = null;
    }

    public Object getDestino() {
        return destino;
    }

    public void setDestino(Object destino) {
        this.destino = destino;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Arista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Arista siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Arista{" +
                "destino=" + destino +
                ", peso=" + peso +
                '}';
    }
}