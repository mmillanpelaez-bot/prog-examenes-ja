import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VideojuegoDAO {

    // Cambia 'tienda_videojuegos' por el nombre de tu base de datos actual en pgAdmin
    private static final String URL = "jdbc:postgresql://localhost:5432/tienda_videojuegos";
    private static final String USER = "postgres";
    private static final String PASS = "vboxuser"; // La contraseña que cambiamos en el Paso 1

    private static Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("❌ ERROR de Conexión: " + e.getMessage());
        }
        return con;
    }

    public static void insertarVideojuego(Videojuego v) {
        String sql = "INSERT INTO videojuego (codigo, titulo, genero, precio) VALUES (?, ?, ?, ?)";

        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, v.getCodigo());
            ps.setString(2, v.getTitulo());
            ps.setString(3, v.getGenero());
            ps.setInt(4, v.getPrecio());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ ¡ÉXITO! El videojuego '" + v.getTitulo() + "' se ha guardado en PostgreSQL.");
            }

        } catch (SQLException e) {
            System.out.println("❌ ERROR al insertar en la BD: " + e.getMessage());
        }
    }
}