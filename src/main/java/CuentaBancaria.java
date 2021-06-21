
import java.io.Serializable;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Isidoro
 */
public abstract class CuentaBancaria implements Serializable{
    //Atributos
    Persona titular;
    double saldo;
    String ccc;
    
    public CuentaBancaria(Persona titular, double saldo, String ccc) {
                this.ccc = ccc;
                this.titular = titular;
                this.saldo = saldo;       
    }
    
    @Override
    public String toString() {
        return "\n"+titular + " " + ccc + " " + saldo;
    }
    
    
}
