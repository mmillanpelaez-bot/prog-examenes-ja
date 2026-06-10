import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        List<Integer> positivos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int num;

        System.out.println("Introduce números enteiros (-1 para rematar):");
        while (true) {
            num = sc.nextInt();
            if (num == -1) break;
            if (num >= 0) {
                positivos.add(num);
            }
        }

        System.out.println("\nElementos en índices pares multiplicados por 100:");
        for (int i = 0; i < positivos.size(); i += 2) { // Incremento de 2 en 2 para evaluar índices pares 
            System.out.println("Índice [" + i + "]: " + (positivos.get(i) * 100));
        }
    }
}