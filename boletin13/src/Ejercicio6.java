import java.util.*;

public class Ejercicio6 {
    public static void main(String[] args) {
        // Lista de exemplo con elementos entre 1 e 10 
        List<Integer> listaOriginal = Arrays.asList(1, 2, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10);
        System.out.println("Lista orixinal: " + listaOriginal);

        // 1. Conxunto cos elementos da lista sen repetir
        Set<Integer> senRepetir = new HashSet<>(listaOriginal);

        // Estructura auxiliar para contar frecuencias e discriminar repetidos de únicos
        Map<Integer, Integer> frecuencias = new HashMap<>();
        for (int num : listaOriginal) {
            frecuencias.put(num, frecuencias.getOrDefault(num, 0) + 1);
        }

        Set<Integer> repetidos = new HashSet<>();
        Set<Integer> unicos = new HashSet<>();

        for (Map.Entry<Integer, Integer> entry : frecuencias.entrySet()) {
            if (entry.getValue() > 1) {
                repetidos.add(entry.getKey()); // Elementos que se repiten
            } else {
                unicos.add(entry.getKey());    // Elementos que aparecen só unha vez
            }
        }

        System.out.println("Sen repetir (todos os presentes): " + senRepetir);
        System.out.println("Repetidos: " + repetidos);
        System.out.println("Únicos (aparecen exactamente unha vez): " + unicos);
    }
}