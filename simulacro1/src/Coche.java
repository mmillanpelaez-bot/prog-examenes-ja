import java.util.Comparator;

public class Coche {

    private String matricula;
    private String marca;
    private String modelo;
    private int prezo;

    public Coche(String matricula, String marca, String modelo, int prezo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.prezo = prezo;
    }

    public String getMatricula() { return matricula; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getPrezo() { return prezo; }

    public static class ComparadorDeCoches implements Comparator<Coche> {
        @Override
        public int compare(Coche c1, Coche c2) {
            int res = c1.getMarca().compareToIgnoreCase(c2.getMarca());
            if (res != 0) return res;

            res = c1.getModelo().compareToIgnoreCase(c2.getModelo());
            if (res != 0) return res;

            return Integer.compare(c1.getPrezo(), c2.getPrezo());
        }
    }
}
