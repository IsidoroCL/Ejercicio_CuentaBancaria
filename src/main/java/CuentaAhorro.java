
import java.io.Serializable;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Isidoro
 */
public class CuentaAhorro extends CuentaBancaria implements Serializable {
    //Atributos de esta clase
    float tipo_interes;
    
    
    public CuentaAhorro (Persona titular, double saldo, String ccc, float tipo) {
        super(titular, saldo, ccc);
        this.tipo_interes = tipo;
        
    }
}
