import java.time.LocalDate;
import java.util.Objects;

// Clase base provista
public class Animal {
    private String codigoIdentificacion;
    private String raza;
    private char sexo;
    private LocalDate dataNacemento;
    private double peso;

    public Animal(String codigoIdentificacion, String raza, char sexo, LocalDate dataNacemento, double peso) {
        this.codigoIdentificacion = codigoIdentificacion;
        this.raza = raza;
        this.sexo = sexo;
        this.dataNacemento = dataNacemento;
        this.peso = peso;
    }

    public String getCodigoIdentificacion() { return codigoIdentificacion; }
    public String getRaza() { return raza; }
    public char getSexo() { return sexo; }
    public LocalDate getDataNacemento() { return dataNacemento; }
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
    
    @Override
    public String toString() { return "Animal"; }        
}

// Clase Filla con Atributos de Proxenitores e equals/toString estritos
class Res extends Animal {
    private Res pai;
    private Res nai;

    public Res(String codigoIdentificacion, String raza, char sexo, LocalDate dataNacemento, double peso, Res pai, Res nai) {
        super(codigoIdentificacion, raza, sexo, dataNacemento, peso);
        this.pai = pai;
        this.nai = nai;
    }

    public Res getPai() { return pai; }
    public void setPai(Res pai) { this.pai = pai; }
    public Res getNai() { return nai; }
    public void setNai(Res nai) { this.nai = nai; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Res res = (Res) o;
        return Objects.equals(this.getCodigoIdentificacion(), res.getCodigoIdentificacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getCodigoIdentificacion());
    }

    @Override
    public String toString() {
        String codPai = (pai != null) ? pai.getCodigoIdentificacion() : "descoñecido";
        String codNai = (nai != null) ? nai.getCodigoIdentificacion() : "descoñecido";
        return "Código: " + getCodigoIdentificacion() + "\n" +
               "<" + getRaza() + ">, <" + getPeso() + "> kg, data de nacemento: <" + getDataNacemento() + ">\n" +
               "Pai: <" + codPai + ">\n" +
               "Nai: <" + codNai + ">";
    }
}