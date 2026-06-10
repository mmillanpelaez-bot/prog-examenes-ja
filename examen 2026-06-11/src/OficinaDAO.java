import java.sql.*;
import java.util.ArrayList;

public class OficinaDAO {

    private static final String URL = "jdbc:postgresql://10.0.8.178:5432/tu_Base_datos";
    private static final String USER = "vboxuser";
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

    // 1. IMPORTAR OFICINAS POR CIF
    public static ArrayList<Oficina> importarOficinasPorCif(String cif) {
        ArrayList<Oficina> lista = new ArrayList<>();
        String sql = "SELECT nome, direccion, localidade, provincia FROM oficina WHERE cif = ?";

        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, cif);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // Creamos o obxecto Oficina co formato do construtor en memoria
                    Oficina ofi = new Oficina(
                        rs.getString("nome"),
                        rs.getString("direccion"),
                        rs.getString("localidade"),
                        rs.getString("provincia")
                    );
                    lista.add(ofi);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao importar oficinas: " + e.getMessage());
        }
        return lista;
    }

    // 2. ACTUALIZAR OFICINA (Usando o CIF como clave)
    public static void actualizarOficina(Oficina c, String cif) {
        String sql = "UPDATE oficina SET nome = ?, direccion = ?, localidade = ?, provincia = ? WHERE cif = ?";

        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, c.getNome());
            ps.setString(2, c.getDireccion());
            ps.setString(3, c.getLocalidade());
            ps.setString(4, c.getProvincia());
            ps.setString(5, cif); // O CIF utilízase no WHERE como clave de busca
            
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Oficina actualizada correctamente na BD.");
            } else {
                System.out.println("Non se atopou ningunha oficina con ese CIF para actualizar.");
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao actualizar oficina: " + e.getMessage());
        }
    }
}