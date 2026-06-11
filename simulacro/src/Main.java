public class Main {
    public static void main(String[] args) {
        System.out.println("Probando o puente JDBC con PostgreSQL...");

        // Creamos un videojuego ficticio para la prueba
        Videojuego test = new Videojuego("GAME-0001", "Tetris", "Clasico", 10);

        // Llamamos al método del DAO
        VideojuegoDAO.insertarVideojuego(test);
    }
}

