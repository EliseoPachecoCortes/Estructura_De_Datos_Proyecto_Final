public class Libro {
    private String titulo;
    private Autor autor; // Asegúrate de que este campo esté presente
    private Categoria categoria;

    public Libro(String titulo, Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        autor.agregarLibro(this); // Agregar el libro a la lista del autor
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor=" + autor.getNombre() + // Solo mostrar el nombre del autor
                ", categoria=" + categoria +
                '}';
    }
}