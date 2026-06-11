import java.sql.*;
import java.util.ArrayList;

public class LibroDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/examen";
    private static final String USER = "postgres";
    private static final String PASS = "vboxuser";

    private static Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Erro na conexión: " + e.getMessage());
        }
        return con;
    }

    public static ArrayList<Libro> importarLibrosPorAutor(String autor) {
        ArrayList<Libro> lista = new ArrayList<>();
        String sql = "SELECT titulo, autor, localidade, anoEdicion FROM libro WHERE autor = ?";

        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, autor);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Libro lib = new Libro(
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("localidade"),
                        rs.getInt("anoEdicion")
                    );
                    lista.add(lib);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao importar libros: " + e.getMessage());
        }
        return lista;
    }

    public static void actualizarLibro(Libro l, String tituloOrixinal) {
        String sql = "UPDATE libro SET titulo = ?, autor = ?, localidade = ?, anoEdicion = ? WHERE tituloOrixinal = ?";

        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setString(3, l.getLocalidade());
            ps.setInt(4, l.getAnoEdicion());
            ps.setString(5, tituloOrixinal);
            
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Libro actualizado correctamente na BD.");
            } else {
                System.out.println("Non se atopou ningun libro con ese titulo para actualizar.");
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao actualizar o libro: " + e.getMessage());
        }
    }
}