public class Categoria implements Comparable<Categoria> {
    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int compareTo(Categoria otra) {
        return this.nombre.compareTo(otra.nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
}