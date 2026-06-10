import java.util.ArrayList;

public class Editorial {
    private String nome;
    private String razonSocial;
    private String cif;
    private int anoFundacion;
    private ArrayList<Libro> libros;

    public Editorial(String nome, String cif) {
        this.nome = nome;
        this.cif = cif;
        this.libros = new ArrayList<>();
    }

    public Libro getLibro(String titulo) {
        for (Libro li : libros) {
            if (li.getTitulo().equalsIgnoreCase(titulo)) {
                return li;
            }
        }
        return null;
    }

    public boolean engadeLibro(Libro novo) {
        if (novo == null)
            return false;
        if (getLibro(novo.getTitulo()) != null) {
            return false;
        }
        return libros.add(novo);
    }

    public ArrayList<Libro> librosLocalidade(String localidade) {
        ArrayList<Libro> cestolibros = new ArrayList<>();

        for (Libro lib : libros) {
            if (lib.getLocalidade().equalsIgnoreCase(localidade)) {
                cestolibros.add(lib);
            }
        }

        return cestolibros;
    }
}