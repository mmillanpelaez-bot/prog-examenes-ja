import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AnimalDAO {

    // Método para obter a conexión cos datos actualizados
    private static Connection obterConexion() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/examen";
        String usuario = "postgres";
        String contrasinal = "vboxuser";
        return DriverManager.getConnection(url, usuario, contrasinal);
    }

    // Consulta de crotales filtrados por data de nacemento
    public static ArrayList<String> obterCodigoIdentificacionPorData(LocalDate data) {
        ArrayList<String> resultado = new ArrayList<>();
        String sql = "SELECT codigo_identificacion FROM animal WHERE data_nacemento <= ?";

        try (Connection con = obterConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setObject(1, data);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    resultado.add(rs.getString("codigo_identificacion"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro en AnimalDAO.obterCodigoIdentificacionPorData: " + e.getMessage());
        }
        return resultado;
    }

    // Cálculo do peso aproximado en canal aplicando a fórmula do exame
    public static double calculoPesoCarneCanal(int porcentaxe) {
        double pesoTotal = 0.0;
        String sql = "SELECT SUM(peso_kg) AS total_peso FROM animal";

        try (Connection con = obterConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                pesoTotal = rs.getDouble("total_peso");
            }
        } catch (SQLException e) {
            System.out.println("Erro en AnimalDAO.calculoPesoCarneCanal: " + e.getMessage());
        }

        return (pesoTotal * porcentaxe) / 100.0;
    }

    // Inserción á base de datos
    public static void inserirDatosExemplo(Connection con) {
        String sql = "INSERT INTO animal (codigo_identificacion, raza, sexo, data_nacemento, peso_kg) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            
            // Animal 1
            ps.setString(1, "ES341000000001");
            ps.setString(2, "Rubia Galega");
            ps.setString(3, "F");
            ps.setDate(4, Date.valueOf(LocalDate.of(2022, 3, 15)));
            ps.setDouble(5, 420.5);
            ps.executeUpdate(); //

            // Animal 2
            ps.setString(1, "ES341000000002");
            ps.setString(2, "Rubia Galega");
            ps.setString(3, "M");
            ps.setDate(4, Date.valueOf(LocalDate.of(2021, 7, 2)));
            ps.setDouble(5, 680.0);
            ps.executeUpdate();

            // Animal 3
            ps.setString(1, "ES341000000003");
            ps.setString(2, "Frisona");
            ps.setString(3, "F");
            ps.setDate(4, Date.valueOf(LocalDate.of(2023, 1, 20)));
            ps.setDouble(5, 310.0);
            ps.executeUpdate();

            // Animal 4
            ps.setString(1, "ES341000000004");
            ps.setString(2, "Cachena");
            ps.setString(3, "F");
            ps.setDate(4, Date.valueOf(LocalDate.of(2020, 9, 10)));
            ps.setDouble(5, 195.5);
            ps.executeUpdate();

            // Animal 5
            ps.setString(1, "ES341000000006");
            ps.setString(2, "Limousin");
            ps.setString(3, "F");
            ps.setDate(4, Date.valueOf(LocalDate.of(2022, 11, 8)));
            ps.setDouble(5, 390.0);
            ps.executeUpdate();

            System.out.println("Datos de exemplo insertados con éxito.");

        } catch (SQLException e) {
            System.out.println("Erro ao insertar os datos de exemplo: " + e.getMessage());
        }
        
    }
}