public class Contacto {

    private final String nome;
    private String numtelefono;
    private String empresa;

    public Contacto(String nome, String numtelefono, String empresa) {
        this.nome = nome;
        this.numtelefono = numtelefono;
        this.empresa = empresa;
    }

    public String getNome() {
        return nome;
    }

    public String getNumtelefono() {
        return numtelefono;
    }

    public void setNumtelefono(String numtelefono) {
        this.numtelefono = numtelefono;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public boolean equals(Object outro) {
        if (this == outro) return true;
        if (outro == null || getClass() != outro.getClass()) return false;
        Contacto contactoOutro = (Contacto) outro;
        return this.nome.equalsIgnoreCase(contactoOutro.getNome());
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Tel: " + numtelefono + " | Empresa: " + (empresa.equals("") ? "Ningunha" : empresa);
    }
}