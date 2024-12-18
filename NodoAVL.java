public class NodoAVL<T> {
    private T dato;
    private NodoAVL<T> izq;
    private NodoAVL<T> der;
    private int altura;

    public NodoAVL(T dato) {
        this.dato = dato;
        this.altura = 1; // Altura inicial del nodo
        this.izq = null;
        this.der = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoAVL<T> getIzq() {
        return izq;
    }

    public void setIzq(NodoAVL<T> izq) {
        this.izq = izq;
    }

    public NodoAVL<T> getDer() {
        return der;
    }

    public void setDer(NodoAVL<T> der) {
        this.der = der;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}