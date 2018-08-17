/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author laurix
 */
public class CuentaBancaria {
    private int saldo = 0;
    
    public void depositar(int p_deposito){
        this.saldo += p_deposito;
    }
    
    public void extraer(int p_extrac){
        this.saldo -= p_extrac;
    }
}
