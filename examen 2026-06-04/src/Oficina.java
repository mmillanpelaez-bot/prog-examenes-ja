import java.util.Comparator;

public class Oficina {
    private String nome;
    private String direccion;
    private String localidade;
    private String provincia;

    public Oficina(String nome, String direccion, String localidade, String provincia) {
        this.nome = nome;
        this.direccion = direccion;
        this.localidade = localidade;
        this.provincia = provincia;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getLocalidade() { return localidade; }
    public void setLocalidade(String localidade) { this.localidade = localidade; }

    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }

    @Override
    public String toString() {
        return "Oficina { nome='" + nome + "', direccion='" + direccion + "', localidade='" + localidade + "', provincia='" + provincia + "' }";
    }

    // INTERFACE COMPARATOR (1 PTO)
    // Compara por nome, provincia, localidade e dirección (nese orde)
    public static class ComparadorDeOficinas implements Comparator<Oficina> {
        @Override
        public int compare(Oficina o1, Oficina o2) {
            int res = o1.getNome().compareToIgnoreCase(o2.getNome());
            if (res != 0) return res;

            res = o1.getProvincia().compareToIgnoreCase(o2.getProvincia());
            if (res != 0) return res;

            res = o1.getLocalidade().compareToIgnoreCase(o2.getLocalidade());
            if (res != 0) return res;

            return o1.getDireccion().compareToIgnoreCase(o2.getDireccion());
        }
    }
}