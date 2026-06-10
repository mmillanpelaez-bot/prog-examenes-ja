import java.util.ArrayList;

public class Concesionario {

    private String nome;
    private String cidade;
    private ArrayList<Coche> coches;

    public Concesionario(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
        this.coches = new ArrayList<>();
    }

    public Coche getCoche(String matricula) {
        for (Coche ch : this.coches) {
            if (ch.getMatricula().equalsIgnoreCase(matricula)) {
                return ch;
            }
        }
        return null;
    }

    public boolean engadeCoche(Coche novo) {
        if (novo == null) return false;
        if (getCoche(novo.getMatricula()) != null) {
            return false;
        }
        return this.coches.add(novo);
    }

    public ArrayList<Coche> getCoches() {
        return this.coches;
    }

    public ArrayList<Coche> getCochesPorMarca(String marca) {
        ArrayList<Coche> cestoResultado = new ArrayList<>();

        for (Coche ch : coches) {
            if (ch.getMarca().equalsIgnoreCase(marca)) {
                cestoResultado.add(ch);
            }
        }

        return cestoResultado;
    }
}

