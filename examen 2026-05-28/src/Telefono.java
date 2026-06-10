public class Telefono {

    public static boolean verificarFormatoTelefono(String telefono) {
        if (telefono == null) return false;

        // EXPRESIÓN REGULAR:
        // ^     -> Empieza aquí
        // [6-9] -> El primer carácter debe ser un 6, 7, 8 o 9
        // \\d{8}-> Seguido de exactamente 8 dígitos numéricos (0-9)
        // $     -> Termina aquí (no se admiten más caracteres)
        String regex = "^[6-9]\\d{8}$";

        return telefono.matches(regex);
    }
}