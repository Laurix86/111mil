/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import javax.swing.JOptionPane;

/**
 *
 * @author laurix
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] A = new int[5];
        int[] B = new int[5];
        int[] C = new int[5];
        String lista = "";
        
        for(int i = 0; i<=4; i++){
            A[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un número entero: ", "Arreglo A", JOptionPane.PLAIN_MESSAGE));
            B[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un número entero: ", "Arreglo B", JOptionPane.PLAIN_MESSAGE));
            C[i] = A[i] + B[i];
        }
        
        for(int i = 0; i<= 4; i++){
            lista = lista + "" + A[i] + " + " + B[i] + " = " + C[i] + "\n";
        }
        
        JOptionPane.showMessageDialog(null, "La suma de los números ingresados es: \n" + lista);
        
        
        
        
        
    }
    
}
