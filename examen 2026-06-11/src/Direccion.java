public class Direccion {

    // Método estático de verificación de formato
    public static boolean comprobarDireccion(String direccion) {
        if (direccion == null) return false;

        // EXPLICACIÓN DA EXPRESIÓN REGULAR (RegEx):
        // ^(Praza|Calle|Baixada|Parroquia) -> Debe empezar por un destes 4 tipos de vía.
        //  .+ –                      -> Seguido dun espazo, calquera texto (nome da rúa) e rematado por " – "
        //  Num:\\s\\d+               -> Seguido de "Num: ", un espazo e un ou máis números.
        // \\sPortal:\\s[a-zA-Z0-9]+  -> Seguido dun espazo, "Portal: ", un espazo e letras ou números.
        // \\sPlanta:\\s\\d+$         -> Seguido dun espazo, "Planta: ", un espazo e números. Remata aí ($).
        
        String regex = "^(Praza|Calle|Baixada|Parroquia) .+ – Num:\\s\\d+\\sPortal:\\s[a-zA-Z0-9]+\\sPlanta:\\s\\d+$";

        return direccion.matches(regex);
    }
}