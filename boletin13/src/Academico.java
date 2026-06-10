public class Academico implements Comparable<Academico> {
    private final String nome;
    private final int anoIngreso;

    public Academico(String nome, int anoIngreso) {
        this.nome = nome;
        this.anoIngreso = anoIngreso;
    }

    public String getNome() { return nome; }
    public int getAnoIngreso() { return anoIngreso; }

    // Criterio de ordenación natural: Alfabético por nome
    @Override
    public int compareTo(Academico outro) {
        return this.nome.compareTo(outro.nome);
    }

    @Override
    public String toString() {
        return "Académico: " + nome + " | Ano de ingreso: " + anoIngreso;
    }
}