import java.util.*;

// Clase de Gestión de la Academia
public class MainAcademia {

    // Método estático de inserción con control de validación
    public static boolean nuevoAcademico(Map<Character, Academico> academia, Academico novo, Character letra) {
        // Validación de caracteres alfabéticos (evita números ou símbolos alleos ao abecedario) 
        if (!Character.isLetter(letra)) {
            System.out.println("Inserción denegada: O sillón '" + letra + "' non pertence ao abecedario.");
            return false;
        }
        // Validación adicional para evitar colisións de sillóns xa asignados
        if (academia.containsKey(letra)) {
            System.out.println("Inserción denegada: O sillón '" + letra + "' xa está ocupado.");
            return false;
        }
        
        academia.put(letra, novo);
        return true;
    }

    public static void main(String[] args) {
        // Usamos TreeMap para manter a ordenación por clave automática (Orde Unicode) 
        Map<Character, Academico> academia = new TreeMap<>();

        // Inserción de cinco obxectos de proba 
        nuevoAcademico(academia, new Academico("Arturo Pérez-Reverte", 2003), 'T');
        nuevoAcademico(academia, new Academico("Manuel Seco", 1993), 'A');
        nuevoAcademico(academia, new Academico("Soledad Puértolas", 2010), 'g');
        nuevoAcademico(academia, new Academico("Mario Vargas Llosa", 1996), 'L');
        nuevoAcademico(academia, new Academico("Elena Quiroga", 1984), 'a');

        // =====================================================================
        // LISTADOS SEN LETRA
        // =====================================================================
        List<Academico> listaAcademicos = new ArrayList<>(academia.values());

        // 1. Sen letra, por orde de nome (Orde natural)
        Collections.sort(listaAcademicos); // Aplica compareTo da clase Academico
        System.out.println("--- ACADÉMICOS SEN LETRA (POR ORDE NATURAL DE NOME) ---");
        listaAcademicos.forEach(System.out::println);

        // 2. Sen letra, por ano de ingreso
        listaAcademicos.sort(Comparator.comparingInt(Academico::getAnoIngreso));
        System.out.println("\n--- ACADÉMICOS SEN LETRA (POR ANO DE INGRESO) ---");
        listaAcademicos.forEach(System.out::println);

        // =====================================================================
        // LISTADOS CON LETRA
        // =====================================================================
        
        // 3. Con letra, por orde de letra (Clave do TreeMap)
        System.out.println("\n--- ACADÉMICOS CON LETRA (POR ORDE DE SILLÓN - CLAVE) ---");
        academia.forEach((letra, academico) -> 
            System.out.println("Sillón [" + letra + "] -> " + academico));

        // 4. Con letra, por orde de nome de académico
        System.out.println("\n--- ACADÉMICOS CON LETRA (POR ORDE ALFABÉTICA DE NOME) ---");
        List<Map.Entry<Character, Academico>> entradasPorNome = new ArrayList<>(academia.entrySet());
        entradasPorNome.sort(Map.Entry.comparingByValue()); // Compara usando o compareTo do valor
        entradasPorNome.forEach(e -> 
            System.out.println("Sillón [" + e.getKey() + "] -> " + e.getValue()));

        // 5. Con letra, por orde de data de ingreso
        System.out.println("\n--- ACADÉMICOS CON LETRA (POR DATA DE INGRESO) ---");
        List<Map.Entry<Character, Academico>> entradasPorData = new ArrayList<>(academia.entrySet());
        entradasPorData.sort(Map.Entry.comparingByValue(Comparator.comparingInt(Academico::getAnoIngreso)));
        entradasPorData.forEach(e -> 
            System.out.println("Sillón [" + e.getKey() + "] -> " + e.getValue()));
    }
}