/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;


import javax.swing.*;

/**
 *
 * @author laurix
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int cant= 0, respuesta;
        double precio=0, total=0;
        
        JOptionPane.showMessageDialog(null, "A continuación se procederá a la carga de la cantidad y los precios de los productos comprados");
        
        do{
        precio = Double.parseDouble(JOptionPane.showInputDialog(null, "Precio individual: ", "Precio", JOptionPane.QUESTION_MESSAGE));
        cant = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad comprada: ", "Cantidad", JOptionPane.QUESTION_MESSAGE));
        total = total + (precio * cant);
        respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar otra compra?", "Seleccione una opción", JOptionPane.YES_NO_OPTION);
        }while (respuesta == JOptionPane.YES_OPTION);
        
        
        JOptionPane.showMessageDialog(null, "El total de lo comprado es: $" + total, "Monto de la factura", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
