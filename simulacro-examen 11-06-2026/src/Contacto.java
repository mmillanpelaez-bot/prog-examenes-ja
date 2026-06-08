public class Contacto {

    private final String nome;
    private String numtelefono;
    private String empresa;

    // Constructor: Inicializa perfectamente el objeto
    public Contacto(String nome, String numtelefono, String empresa) {
        this.nome = nome;
        this.numtelefono = numtelefono;
        this.empresa = empresa;
    }

    // Métodos consultores (Getters) - Todos públicos
    public String getNome() {
        return nome;
    }

    public String getNumtelefono() {
        return numtelefono;
    }

    // Método modificador (Setter) corregido con 'public' y asignación
    public void setNumtelefono(String numtelefono) {
        this.numtelefono = numtelefono; // Guardamos el nuevo teléfono
    }

    public String getEmpresa() {
        return empresa;
    }

    // Método modificador (Setter) corregido: ¡Ahora sí recibe la empresa!
    public void setEmpresa(String empresa) {
        this.empresa = empresa; // Guardamos la nueva empresa
    }

    // SOBREESCRITURA DEL EQUALS: Crucial para buscar y borrar contactos
    @Override
    public boolean equals(Object outro) {
        // 1. Si apuntan a la misma dirección de memoria, son iguales
        if (this == outro) return true;

        // 2. Si el otro objeto es nulo o no es de la clase Contacto, no son iguales
        if (outro == null || getClass() != outro.getClass()) return false;

        // 3. Transformamos el Object genérico en un Contacto (Casting)
        Contacto contactoOutro = (Contacto) outro;

        // 4. Criterio del examen: Iguales si tienen el mismo nombre (sin importar mayúsculas)
        return this.nome.equalsIgnoreCase(contactoOutro.getNome());
    }
}