import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    // Datos de conexión configurados con mis credenciales
    private static final String URL = "jdbc:postgresql://localhost:5432/examen";
    private static final String USUARIO = "postgres";
    private static final String CONTRASINAL = "vboxuser";

    // Método para conectar provisto polo profe
    private static Connection conectar() {
        Connection con = null;
        System.out.println("Conectando á base de datos PostgreSQL...");
        try {
            con = DriverManager.getConnection(URL, USUARIO, CONTRASINAL);
        } catch (SQLException e) {
            System.out.println("Erro realizando a conexión a base de datos: " + e.getMessage());
        }
        return con;
    }

    // Creación da táboa
    private static void crearTaboa(Connection con) {
        String sql = """
             CREATE TABLE IF NOT EXISTS animal (
                 codigo_identificacion VARCHAR(20)  PRIMARY KEY,
                 raza                  VARCHAR(50)  NOT NULL,
                 sexo                  CHAR(1)      NOT NULL CHECK (sexo IN ('M', 'F')),
                 data_nacemento        DATE         NOT NULL,
                 peso_kg               NUMERIC(6,2) NOT NULL CHECK (peso_kg > 0)
             )
             """;
        try (Statement st = con.createStatement()) {
            st.execute(sql);
            System.out.println("Táboa 'animal' verificada/creada con éxito.");
        } catch (SQLException e) {
            System.out.println("Erro ao crear a táboa: " + e.getMessage());
        }
    }

    // O MÉTODO PRINCIPAL QUE COORDINA TODO O EXAME
    public static void main(String[] args) {
        System.out.println("=== INICIANDO APLICACIÓN GANDEIRÍA ===");
        
        Connection con = conectar();
        
        if (con != null) {
            try {
                crearTaboa(con);

                AnimalDAO.inserirDatosExemplo(con);
                
                con.close();
                System.out.println("Inicialización da base de datos completada con éxito.\n");

            } catch (SQLException e) {
                System.out.println("Erro crítico na inicialización: " + e.getMessage());
            }
        } else {
            System.out.println("Non se puido establecer a conexión inicial. Revisa PostgreSQL.");
            return;
        }

        // DEMOSTRACIÓN DE FUNCIONAMENTO DO ANIMALDAO
        System.out.println("=== PROBAS DE PERSISTENCIA (AnimalDAO) ===");
        
        // Proba 1: Buscar crotales anteriores ou iguais a unha data
        LocalDate dataFiltro = LocalDate.of(2022, 12, 31);
        ArrayList<String> crotales = AnimalDAO.obterCodigoIdentificacionPorData(dataFiltro);
        System.out.println("-> Crotales con data de nacemento anterior ou igual a " + dataFiltro + ":");
        System.out.println("   " + crotales);

        // Proba 2: Calcular o peso estimado en canal
        int porcentaxeRendemento = 50;
        double pesoCanal = AnimalDAO.calculoPesoCarneCanal(porcentaxeRendemento);
        System.out.println("\n-> Peso total estimado en canal (ao " + porcentaxeRendemento + "%): " + pesoCanal + " kg");
        System.out.println("=========================================\n");

        // 5. LANZAMENTO DO MENÚ INTERACTIVO (Explotacion)
        System.out.println("Lanzando o sistema de xestión por consola...");
        // Executamos o método main de Explotacion que xa corriximos antes
        Explotacion.main(args);
    }
}