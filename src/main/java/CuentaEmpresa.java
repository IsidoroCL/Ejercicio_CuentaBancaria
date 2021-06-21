
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
public class CuentaEmpresa extends CuentaCorriente implements Serializable {
    //Atributos
    float tipo_descubierto;
    float maximo;
    
    public CuentaEmpresa (Persona titular, double saldo, String ccc, HashMap lista, float tipo, float maximo) {
       super(titular, saldo, ccc, lista);
       this.tipo_descubierto = tipo;
       this.maximo = maximo;
    }
}
