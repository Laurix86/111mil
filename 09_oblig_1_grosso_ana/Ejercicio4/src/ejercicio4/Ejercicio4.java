/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import javax.swing.JOptionPane;

/**
 *
 * @author laurix
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre = "";
        int opcion = 0;
        
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Saludar \n2. Despedirse \n3. Salir \nIngrese el número de la opción elegida: ", "Elija su propia aventura", JOptionPane.DEFAULT_OPTION));
        switch (opcion){
                case 1: nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre","Nombre", JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Hola " + nombre);
                break;
                case 2: JOptionPane.showMessageDialog(null, "Adios");
                break;
                case 3: System.exit(0);
                break;
                default: JOptionPane.showMessageDialog(null, "Error de selección", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
