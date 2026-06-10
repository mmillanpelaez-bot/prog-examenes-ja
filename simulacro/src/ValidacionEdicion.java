public class ValidacionEdicion {

    public static boolean comprobarFormatoEdicion(String cadea) {
        if (cadea == null) return false;
        String regex = "^(Galaxia|Xerais|Cumio) – Ano: (\\d{4})\\sEdicion: (\\d+)\\sReimpresion: (\\d+)$";
        return cadea.matches(regex);
    }
}
