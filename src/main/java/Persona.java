
import java.io.Serializable;

/**
 *
 * @author Isidoro
 */
public class Persona implements Serializable {
    //Atributos
    String nombre;
    String apellidos;
    String fecha_nacimiento;
    
    public Persona(String nombre, String apellidos, String fecha_nacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    @Override
    public String toString() {
        
        return nombre+" "+apellidos;
    }
        
}
