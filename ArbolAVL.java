import java.util.ArrayList;
import java.util.List;

public class ArbolAVL<T extends Comparable<T>> {
    private NodoAVL<T> raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public void insertar(T dato) {
        this.raiz = insertarRecursivo(dato, raiz);
    }

    private NodoAVL<T> insertarRecursivo(T dato, NodoAVL<T> nodo) {
        if (nodo == null) {
            return new NodoAVL<>(dato);
        }

        if (dato.compareTo(nodo.getDato()) < 0) {
            nodo.setIzq(insertarRecursivo(dato, nodo.getIzq()));
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setDer(insertarRecursivo(dato, nodo.getDer()));
        } else {
            return nodo; // Si el dato ya existe, no hacemos nada
        }

        // Actualizar la altura del nodo
        nodo.setAltura(1 + Math.max(determinarAltura(nodo.getIzq()), determinarAltura(nodo.getDer())));

        // Balancear el árbol
        return balancear(nodo);
    }

    private int determinarAltura(NodoAVL<T> nodo) {
        return nodo == null ? 0 : nodo.getAltura();
    }

    private NodoAVL<T> balancear(NodoAVL<T> nodo) {
        int balance = determinarAltura(nodo.getDer()) - determinarAltura(nodo.getIzq());

        // Rotaciones para balancear el árbol
        if (balance >= 2) {
            if (determinarAltura(nodo.getDer().getIzq()) > determinarAltura(nodo.getDer().getDer())) {
                nodo.setDer(rotacionDer(nodo.getDer()));
            }
            nodo = rotacionIzq(nodo);
        } else if (balance <= -2) {
            if (determinarAltura(nodo.getIzq().getDer()) > determinarAltura(nodo.getIzq().getIzq())) {
                nodo.setIzq(rotacionIzq(nodo.getIzq()));
            }
            nodo = rotacionDer(nodo);
        }

        return nodo;
    }

    public NodoAVL<T> rotacionIzq(NodoAVL<T> x) {
        NodoAVL<T> y = x.getDer();
        x.setDer(y.getIzq());
        y.setIzq(x);
        x.setAltura(1 + Math.max(determinarAltura(x.getIzq()), determinarAltura(x.getDer())));
        y.setAltura(1 + Math.max(determinarAltura(y.getIzq()), determinarAltura(y.getDer())));
        return y;
    }

    public NodoAVL<T> rotacionDer(NodoAVL<T> y) {
        NodoAVL<T> x = y.getIzq();
        y.setIzq(x.getDer());
        x.setDer(y);
        y.setAltura(1 + Math.max(determinarAltura(y.getIzq()), determinarAltura(y.getDer())));
        x.setAltura(1 + Math.max(determinarAltura(x.getIzq()), determinarAltura(x.getDer())));
        return x;
    }

    public List<T> obtenerCategorias() {
        List<T> categorias = new ArrayList<>();
        obtenerCategoriasRecursivo(raiz, categorias);
        return categorias;
    }

    private void obtenerCategoriasRecursivo(NodoAVL<T> nodo, List<T> categorias) {
        if (nodo != null) {
            obtenerCategoriasRecursivo(nodo.getIzq(), categorias);
            categorias.add(nodo.getDato());
            obtenerCategoriasRecursivo(nodo.getDer(), categorias);
        }
    }

    public void mostrarCategorias() {
        mostrarCategoriasRecursivo(raiz);
    }

    private void mostrarCategoriasRecursivo(NodoAVL<T> nodo) {
        if (nodo != null) {
            mostrarCategoriasRecursivo(nodo.getIzq());
            System.out.println(nodo.getDato());
            mostrarCategoriasRecursivo(nodo.getDer());
        }
    }
}