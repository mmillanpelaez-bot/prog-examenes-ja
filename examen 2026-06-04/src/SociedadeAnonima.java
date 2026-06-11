import java.util.ArrayList;

public class SociedadeAnonima {

    private String razonSocial;
    private String nif;
    private String actividadePrincipal;
    private String representanteLegal;
    private ArrayList<Oficina> oficinas;

    // CONSTRUTOR
    public SociedadeAnonima(String razonSocial, String nif, String actividadePrincipal, String representanteLegal) {
        this.razonSocial = razonSocial;
        this.nif = nif;
        this.actividadePrincipal = actividadePrincipal;
        this.representanteLegal = representanteLegal;
        this.oficinas = new ArrayList<>(); // Inicializa a lista baleira
    }

    // GETTERS E SETTERS
    public String getRazonSocial() { return razonSocial; }
    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }

    public String getNif() { return nif; }
    public void setNif(String nif) { this.nif = nif; }

    public String getActividadePrincipal() { return actividadePrincipal; }
    public void setActividadePrincipal(String actividadePrincipal) { this.actividadePrincipal = actividadePrincipal; }

    public String getRepresentanteLegal() { return representanteLegal; }
    public void setRepresentanteLegal(String representanteLegal) { this.representanteLegal = representanteLegal; }

    public ArrayList<Oficina> getOficinas() { return oficinas; }
    public void setOficinas(ArrayList<Oficina> oficinas) { this.oficinas = oficinas; }

    // EQUALS (Compara polo NIF)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SociedadeAnonima outra = (SociedadeAnonima) o;
        return this.nif != null && this.nif.equalsIgnoreCase(outra.getNif());
    }

    // TOSTRING
    @Override
    public String toString() {
        return "SociedadeAnónima [Razon Social=" + razonSocial + ", NIF=" + nif + 
               ", Actividade=" + actividadePrincipal + ", Representante=" + representanteLegal + 
               ", Nº Oficinas=" + oficinas.size() + "]";
    }

    // ==========================================================
    // MÉTODOS SOBRE A LISTA DE OFICINAS
    // ==========================================================

    // 1. Buscar oficina por nome (Corrixido o tipo de retorno a Oficina, que é o lóxico)
    public Oficina getOficina(String nome) {
        for (Oficina ofi : oficinas) {
            if (ofi.getNome().equalsIgnoreCase(nome)) {
                return ofi; // Devolve o obxecto se o atopa
            }
        }
        return null; // Se sae do bucle é que non existe
    }

    // 2. Engadir oficina sen repetidos (Comproba se xa existe unha co mesmo nome)
    public boolean engadeOficina(Oficina novaOficina) {
        if (novaOficina == null) return false;
        
        // Usamos o noso propio método getOficina para ver se xa existe
        if (getOficina(novaOficina.getNome()) != null) {
            return false; // Xa hai unha oficina con ese nome, devolvemos false
        }
        
        return oficinas.add(novaOficina); // Engade e devolve true
    }

    // 3. Filtrar oficinas por localidade (Estratexia do Cesto Temporal)
    public ArrayList<Oficina> oficinasLocalidade(String localidade) {
        ArrayList<Oficina> cestoResultado = new ArrayList<>();
        
        for (Oficina ofi : oficinas) {
            if (ofi.getLocalidade().equalsIgnoreCase(localidade)) {
                cestoResultado.add(ofi);
            }
        }
        
        return cestoResultado;
    }
}