import java.util.HashSet;
import java.util.Set;

public class OperacionesConjuntos {

    // Ejercicio 7: Unión de dous conxuntos
    public static <E> Set<E> union(Set<E> conxunto1, Set<E> conxunto2) {
        Set<E> resultado = new HashSet<>(conxunto1);
        resultado.addAll(conxunto2); // Engade os elementos do segundo sen duplicar
        return resultado;
    }

    // Ejercicio 8: Intersección de dous conxuntos
    public static <E> Set<E> interseccion(Set<E> conxunto1, Set<E> conxunto2) {
        Set<E> resultado = new HashSet<>(conxunto1);
        resultado.retainAll(conxunto2); // Mantén unicamente os elementos comúns 
        return resultado;
    }
}