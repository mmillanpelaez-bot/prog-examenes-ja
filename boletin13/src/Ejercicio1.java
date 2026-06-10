import java.util.Arrays;

public class Ejercicio1 {
    // Método estático genérico para concatenar dos arrays
    public static <E> E[] concatenar(E[] tabla1, E[] tabla2) {
        E[] resultado = Arrays.copyOf(tabla1, tabla1.length + tabla2.length);
        System.arraycopy(tabla2, 0, resultado, tabla1.length, tabla2.length);
        return resultado;
    }
}