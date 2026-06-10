import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class Ejercicios2y3 {
    public static void main(String[] args) {
        Collection<Integer> coleccion = new ArrayList<>();
        Random rand = new Random();

        // Inserción de 100 números aleatorios entre 1 y 10
        for (int i = 0; i < 100; i++) {
            coleccion.add(rand.nextInt(10) + 1);
        }

        System.out.println("Colección antes da eliminación:\n" + coleccion + "\n");

        // Ejercicio 3: Uso de un iterador para eliminar elementos con valor 5 y 7
        Iterator<Integer> it = coleccion.iterator();
        while (it.hasNext()) {
            int num = it.next();
            if (num == 5 || num == 7) {
                it.remove(); // Eliminación segura a través del iterador
            }
        }

        System.out.println("Colección despois da eliminación (sen 5 nin 7):\n" + coleccion);
    }
}