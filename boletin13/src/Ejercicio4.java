import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        List<Double> positivos = new ArrayList<>();
        List<Double> negativos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        double num;

        System.out.println("Introduce números reais (0 para rematar):");
        while (true) {
            num = sc.nextDouble();
            if (num == 0) break;
            
            if (num > 0) {
                positivos.add(num);
            } else {
                negativos.add(num);
            }
        }

        // Cálculo de sumas
        double sumaPos = 0;
        for (double p : positivos) sumaPos += p;
        
        double sumaNeg = 0;
        for (double n : negativos) sumaNeg += n;

        System.out.println("\n--- Datos Iniciais ---");
        System.out.println("Positivos: " + positivos + " | Suma: " + sumaPos);
        System.out.println("Negativos: " + negativos + " | Suma: " + sumaNeg);

        // Eliminación de elementos > 10 e < -10
        positivos.removeIf(n -> n > 10);
        negativos.removeIf(n -> n < -10);

        System.out.println("\n--- Despois do Filtrado (Eliminados >10 e <-10) ---");
        System.out.println("Positivos filtrados: " + positivos);
        System.out.println("Negativos filtrados: " + negativos);
    }
}