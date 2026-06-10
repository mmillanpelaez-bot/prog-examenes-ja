import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Ejercicio 10: Gestión de Existencias (Estructura de Mapas)
public class XestionTendaRepostos {
    private static final String FICHEIRO_DAT = "existencias.dat";

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Map<String, Integer> produtos = new HashMap<>();
        File f = new File(FICHEIRO_DAT);

        // Carga inicial do ficheiro de existencias se existe 
        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                produtos = (Map<String, Integer>) ois.readObject();
            } catch (Exception e) {
                System.out.println("Creando novo historial de existencias (non se puido ler o anterior).");
            }
        }

        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n--- ALMACÉN DE REPOSTOS ---");
            System.out.println("a. Dar de alta produto");
            System.out.println("b. Dar de baixa produto");
            System.out.println("c. Actualizar cantidade de produto");
            System.out.println("d. Visualizar produtos e stock");
            System.out.println("e. Saír e gardar");
            System.out.print("Opción: ");
            opcion = sc.nextLine().toLowerCase();

            switch (opcion) {
                case "a":
                    System.out.print("Introduce o código alfanumérico do produto: ");
                    String codAlta = sc.nextLine();
                    if (produtos.containsKey(codAlta)) {
                        System.out.println("O produto xa se encontra rexistrado.");
                    } else {
                        System.out.print("Introduce o número de unidades: ");
                        int cant = Integer.parseInt(sc.nextLine());
                        produtos.put(codAlta, cant);
                        System.out.println("Produto engadido ao almacén.");
                    }
                    break;

                case "b":
                    System.out.print("Introduce o código do produto a eliminar: ");
                    String codBaixa = sc.nextLine();
                    if (produtos.remove(codBaixa) != null) {
                        System.out.println("Produto dado de baixa correctamente.");
                    } else {
                        System.out.println("O código do produto especificado non existe.");
                    }
                    break;

                case "c":
                    System.out.print("Introduce o código do produto: ");
                    String codAct = sc.nextLine();
                    if (produtos.containsKey(codAct)) {
                        System.out.print("Introduce a nova cantidade total: ");
                        int novaCant = Integer.parseInt(sc.nextLine());
                        produtos.put(codAct, novaCant); // Sobrescribe o valor asociado
                        System.out.println("Cantidade modificada.");
                    } else {
                        System.out.println("Produto non atopado.");
                    }
                    break;

                case "d":
                    if (produtos.isEmpty()) {
                        System.out.println("Non hai existencias no almacén.");
                    } else {
                        System.out.println("--- LISTA DE EXISTENCIAS ---");
                        produtos.forEach((cod, cant) ->
                            System.out.println("Código: " + cod + " -> Stock: " + cant + " unidades."));
                    }
                    break;

                case "e":
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHEIRO_DAT))) {
                        oos.writeObject(produtos); // Persistencia ao pechar o programa 
                        System.out.println("Historial de existencias actualizado no disco correctamente.");
                    } catch (IOException e) {
                        System.err.println("Erro ao persistir o ficheiro: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (!opcion.equals("e"));
    }
}