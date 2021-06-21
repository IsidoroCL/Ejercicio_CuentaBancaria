
import java.io.Serializable;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Isidoro
 */
public class CuentaPersonal extends CuentaCorriente implements Serializable {
    //Atributos
    float comision;
    
    public CuentaPersonal (Persona titular, double saldo, String ccc, HashMap lista, float comision) {
       super(titular, saldo, ccc, lista);
       this.comision = comision;
    }
}
