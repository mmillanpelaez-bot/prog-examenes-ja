public class Videojuego {
    private String codigo;
    private String titulo;
    private String genero;
    private int precio;

    public Videojuego(String codigo, String titulo, String genero, int precio) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.precio = precio;
    }

    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public int getPrecio() { return precio; }
}