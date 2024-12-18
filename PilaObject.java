
public class PilaObject {
    private int tam;
    private int tope;
    private Object[] arreglo;

    public PilaObject(int tam) {
        this.tam = tam;
        this.tope = -1;
        arreglo = new Object[this.tam];
    }

    public boolean estallena() {
        return tope == tam - 1;
    }

    public boolean estavacia() {
        return tope == -1;
    }

    public boolean push(Object valor) {
        if (estallena())
            return false;
        this.tope++;
        this.arreglo[this.tope] = valor;
        return true;
    }

    public Object pop() throws Exception {
        if (estavacia())
            throw new Exception("Pila-vacia");
        Object valor = this.arreglo[this.tope];
        this.tope--;
        return valor;
    }

    public Object vertope() throws Exception {
        if (estavacia())
            throw new Exception("Pila-vacia");
        return this.arreglo[this.tope];
    }
}