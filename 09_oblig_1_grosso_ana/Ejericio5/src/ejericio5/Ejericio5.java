/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejericio5;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author laurix
 */
public class Ejericio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double valorPesos = 0, valorConvertido = 0, EUR = 0.03, USD = 0.04, JPY = 4.39;
        int opcion = 0;
        DecimalFormat df = new DecimalFormat("#.00");
        
        
        valorPesos = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor (en pesos) que quiere convertir", "Cantiddad en pesos", JOptionPane.QUESTION_MESSAGE));
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione a qué moneda desea convertir el valor ingresado: \n1. Euro(EUR) \n2. Dolar(USD) \n3. Yen(JPY)", "Conversión a moneda extranjera", JOptionPane.QUESTION_MESSAGE));
        
        switch(opcion) {
            case 1 : valorConvertido = valorPesos * EUR;
            break;
            case 2 : valorConvertido = valorPesos * USD;
            break;
            case 3 : valorConvertido = valorPesos * JPY;
            break;
            default : JOptionPane.showMessageDialog(null, "Error de selección", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
        
        JOptionPane.showMessageDialog(null, "El resultado es: " + df.format(valorConvertido), "Convertido", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
