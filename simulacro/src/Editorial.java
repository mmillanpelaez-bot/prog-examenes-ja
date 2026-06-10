import java.util.ArrayList;

public class Editorial {
    private String nome;
    private String cif;
    private ArrayList<Libro> libros; // SIN static

    public Editorial(String nome, String cif) {
        this.nome = nome;
        this.cif = cif;
        this.libros = new ArrayList<>();
    }

    public Libro getLibro(String titulo) {
        for (Libro li : this.libros) {
            if (li.getTitulo().equalsIgnoreCase(titulo)) {
                return li;
            }
        }
        return null;
    }

    public boolean engadeLibro(Libro novo) {
        if (novo == null) return false;
        if (getLibro(novo.getTitulo()) != null) {
            return false;
        }
        return this.libros.add(novo);
    }

    // Getter para poder obtener la lista desde el Main y ordenarla
    public ArrayList<Libro> getLibros() {
        return this.libros;
    }
}