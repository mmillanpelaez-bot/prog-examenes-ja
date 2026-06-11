public class Main {
    public static void main(String[] args) {
        System.out.println("=== Iniciando Proba do Puente JDBC ===");

        // 1. Creamos un objeto Videojuego en la memoria de Java
        Videojuego juegoPrueba = new Videojuego("GAME-9999", "Elden Ring", "Rol", 60);

        // 2. Intentamos enviarlo a través del puente hacia pgAdmin
        System.out.println("Enviando datos a PostgreSQL...");
        VideojuegoDAO.insertarVideojuego(juegoPrueba);

        System.out.println("=== Fin da proba ===");
    }
}