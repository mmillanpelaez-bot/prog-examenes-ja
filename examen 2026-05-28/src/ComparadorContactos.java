import java.util.Comparator;

public class ComparadorContactos implements Comparator<Contacto> {

    @Override
    public int compare(Contacto c1, Contacto c2) {
        // Devuelve negativo si c1 va antes, positivo si va después, 0 si son iguales
        return c1.getNome().compareToIgnoreCase(c2.getNome());
    }
}