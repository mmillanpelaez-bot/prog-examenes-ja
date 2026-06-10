import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Ejercicio 9: Simulación de Estación Meteorológica (I/O Binario)
public class RegistroTemperatura implements Serializable {
    private static final long serialVersionUID = 1L; // Control de versión de serialización
    private final double temperatura;
    private final LocalDateTime hora;

    public RegistroTemperatura(double temperatura) {
        this.temperatura = temperatura;
        this.hora = LocalDateTime.now(); // Captura automática do sistema 
    }

    public double getTemperatura() { return temperatura; }
    public LocalDateTime getHora() { return hora; }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        return String.format("Hora: %s | Temperatura: %.2f °C", hora.format(dtf), temperatura);
    }
}