import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VideojuegoDAO {

    // TRAMPA DE EXAMEN: Cambia 'tienda_juegos' por el nombre real de tu BD de mañana
    private static final String URL = "jdbc:postgresql://localhost:5432/tienda_juegos";
    private static final String USER = "postgres"; // El usuario por defecto en pgAdmin
    private static final String PASS = "vboxuser"; // ¡Pon la contraseña de tu máquina del examen!

    /**
     * Método herramienta para abrir la conexión.
     */
    private static Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Erro na conexión con PostgreSQL: " + e.getMessage());
        }
        return con;
    }

    /**
     * MÉTODO DE INSERCIÓN (Guarda el objeto de Java en pgAdmin)
     */
    public static void insertarVideojuego(Videojuego v) {
        // Los '?' son comodines para evitar inyecciones SQL (Punto extra en seguridad)
        String sql = "INSERT INTO videojuego (codigo, titulo, genero, precio) VALUES (?, ?, ?, ?)";

        // Try-with-resources: Abre y CIERRA automáticamente los recursos
        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            // TRAMPA DE EXAMEN: Los índices empiezan en 1, nunca en 0
            ps.setString(1, v.getCodigo());
            ps.setString(2, v.getTitulo());
            ps.setString(3, v.getGenero());
            ps.setInt(4, v.getPrecio());

            // executeUpdate() se usa para INSERT, UPDATE, DELETE. Devuelve filas afectadas.
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Videojuego gardado en PostgreSQL con éxito.");
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao insertar na Base de Datos: " + e.getMessage());
        }
    }
}