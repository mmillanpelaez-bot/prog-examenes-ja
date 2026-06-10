import java.util.Comparator;

public class Libro {
    private String titulo;
    private String autor;
    private String localidade;
    private int anoEdicion;

    public Libro(String titulo, String autor, String localidade, int anoEdicion) {
        this.titulo = titulo;
        this.autor = autor;
        this.localidade = localidade;
        this.anoEdicion = anoEdicion;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getLocalidade() { return localidade; }
    public int getAnoEdicion() { return anoEdicion; }

    public static class ComparadorDeLibros implements Comparator<Libro> {
        @Override
        public int compare(Libro l1, Libro l2) {
            int res = l1.getTitulo().compareToIgnoreCase(l2.getTitulo());
            if (res != 0) return res;

            res = l1.getAutor().compareToIgnoreCase(l2.getAutor());
            if (res != 0) return res;

            return Integer.compare(l1.getAnoEdicion(), l2.getAnoEdicion());
        }
    }
}