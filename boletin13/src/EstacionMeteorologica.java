import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Aplicación Principal
public class EstacionMeteorologica {
    public static void main(String[] args) {
        List<RegistroTemperatura> listaRexistros = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n--- ESTACIÓN METEOROLÓXICA ---");
            System.out.println("a. Novo rexistro");
            System.out.println("b. Listar rexistros");
            System.out.println("c. Mostrar estatística");
            System.out.println("d. Saír");
            System.out.print("Selecciona unha opción: ");
            opcion = sc.nextLine().toLowerCase();

            switch (opcion) {
                case "a":
                    System.out.print("Introduce a temperatura en °C: ");
                    double temp = Double.parseDouble(sc.nextLine());
                    listaRexistros.add(new RegistroTemperatura(temp));
                    System.out.println("Rexistro engadido.");
                    break;

                case "b":
                    if (listaRexistros.isEmpty()) {
                        System.out.println("Non hai rexistros introducidos.");
                    } else {
                        listaRexistros.forEach(System.out::println);
                    }
                    break;

                case "c":
                    if (listaRexistros.isEmpty()) {
                        System.out.println("Non hai datos dabondo.");
                    } else {
                        double min = Double.MAX_VALUE;
                        double max = -Double.MAX_VALUE;
                        double suma = 0;
                        for (RegistroTemperatura r : listaRexistros) {
                            double t = r.getTemperatura();
                            if (t < min) min = t;
                            if (t > max) max = t;
                            suma += t;
                        }
                        System.out.printf("Temperatura Máxima: %.2f °C\n", max);
                        System.out.printf("Temperatura Mínima: %.2f °C\n", min);
                        System.out.printf("Promedio Diario: %.2f °C\n", (suma / listaRexistros.size()));
                    }
                    break;

                case "d":
                    // Formateo do nome do ficheiro binario segundo a data actual 
                    String dataFormat = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
                    String nomeFicheiro = "registros" + dataFormat + ".dat";

                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFicheiro))) {
                        oos.writeObject(listaRexistros); // Escritura indexada 
                        System.out.println("Datos gardados con éxito en: " + nomeFicheiro);
                    } catch (IOException e) {
                        System.err.println("Erro ao gardar o ficheiro binario: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Opción non válida.");
            }
        } while (!opcion.equals("d"));
    }
}