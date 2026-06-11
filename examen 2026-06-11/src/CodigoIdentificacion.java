public class CodigoIdentificacion {
    // Clase non instanciable (construtor privado)
    private CodigoIdentificacion() {}

    public static boolean verificarCodigoIdentificacion(String codidentificacion) {
        if (codidentificacion == null) return false;
        String[] partes = codidentificacion.trim().split(" ");
        
        if (partes.length != 5) return false;
        if (!partes[0].equals("ES")) return false;
        if (!partes[1].equals("22")) return false; // Código de bovino
        if (!partes[2].equals("11")) return false; // Código de Galicia
        if (partes[3].length() != 4 || !partes[3].matches("\\d{4}")) return false;
        if (partes[4].length() != 4 || !partes[4].matches("\\d{4}")) return false;
        
        return true;
    }
}