
import java.util.ArrayList;
import java.util.Scanner;

public class Explotacion {
    private String cif;
    private String nome;
    private ArrayList<Animal> animais;

    public Explotacion(String nome, String cif) {
        this.nome = nome;
        this.cif = cif;
        this.animais = new ArrayList<>();
    }

    public String getCif() { return cif; }
    public void setCif(String cif) { this.cif = cif; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public boolean engadirAnimal(Animal novoAnimal) {
        for (Animal a : animais) {
            if (a.getCodigoIdentificacion().equals(novoAnimal.getCodigoIdentificacion())) {
                return false;
            }
        }
        animais.add(novoAnimal);
        return true;
    }

    public void modificarAnimal(Animal animalMod) {
        for (Animal a : animais) {
            if (a.getCodigoIdentificacion().equals(animalMod.getCodigoIdentificacion())) {
                a.setPeso(animalMod.getPeso());
                break;
            }
        }
    }

    public String mostrarAnimais() {
        if (animais.isEmpty()) return "Non hai animais na explotación.";
        StringBuilder sb = new StringBuilder();
        for (Animal a : animais) {
            sb.append("Crotal: ").append(a.getCodigoIdentificacion())
              .append(" | Raza: ").append(a.getRaza())
              .append(" | Peso: ").append(a.getPeso()).append(" kg\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Explotacion exp = new Explotacion("Gandería Castelao Java", "G12345678");
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\n--- MENÚ EXPLOTACIÓN (JAVA) ---");
            System.out.println("1. Engadir animal á lista.");
            System.out.println("2. Modificar animal.");
            System.out.println("3. Mostrar animais da explotación.");
            System.out.println("4. Sair.");
            System.out.print("Selecciona unha opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Código Identificación (ES 22 11 XXXX XXXX): ");
                    String cod = sc.nextLine();
                    if (!CodigoIdentificacion.verificarCodigoIdentificacion(cod)) {
                        System.out.println("Formato de crotal non válido.");
                        break;
                    }
                    System.out.print("Raza: ");
                    String raza = sc.nextLine();
                    System.out.print("Sexo (M/F): ");
                    char sexo = sc.next().charAt(0);
                    System.out.print("Peso (kg): ");
                    double peso = sc.nextDouble();
                    
                    if (exp.engadirAnimal(new Animal(cod, raza, sexo, java.time.LocalDate.now(), peso))) {
                        System.out.println("Animal engadido con éxito.");
                    } else {
                        System.out.println("Erro: O animal xa existe.");
                    }
                }
                case 2 -> {
                    System.out.print("Introduce o código do animal a modificar: ");
                    String cod = sc.nextLine();
                    System.out.print("Introduce o novo peso: ");
                    double peso = sc.nextDouble();
                    exp.modificarAnimal(new Animal(cod, "", 'F', java.time.LocalDate.now(), peso));
                    System.out.println("Proceso de modificación completado.");
                }
                case 3 -> System.out.print(exp.mostrarAnimais());
                case 4 -> System.out.println("Saindo do programa en Java...");
                default -> System.out.println("Opción incorrecta.");
            }
        }
        sc.close();
    }
}