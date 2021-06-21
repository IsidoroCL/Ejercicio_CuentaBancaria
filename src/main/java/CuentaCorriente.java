
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
public class CuentaCorriente extends CuentaBancaria{
    //Atributos
    HashMap lista;
    
    public CuentaCorriente (Persona titular, double saldo, String ccc, HashMap lista) {
       super(titular, saldo, ccc);
       this.lista = lista;
    }
}
