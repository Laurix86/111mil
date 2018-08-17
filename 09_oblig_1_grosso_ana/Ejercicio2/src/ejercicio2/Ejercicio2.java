/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import javax.swing.JOptionPane;

/**
 *
 * @author laurix
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double sueldo = 0, total = 0;
        
        for (int i = 0; i<=12; i++){
            sueldo = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el sueldo del mes " + (i+1), "Sueldos", JOptionPane.QUESTION_MESSAGE));
            if (sueldo < 0){
                break;
            }
            total += sueldo;
        }
        
        JOptionPane.showMessageDialog(null, "La suma de los sueldos es: $" + total);
        
        
        
    }
    
}
