/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import javax.swing.JFrame;


public class Ventana {
    JFrame ventana = new JFrame();
    
    public void crearVentana(){
        ventana.setTitle("Ventana de prueba");
        ventana.setSize(300, 400);
        ventana.setLocationRelativeTo(null); 
        //no podía entender porqué no centraba la ventana hasta que encontré 
        //que tenía mal el orden, primero hay que definir el tamaño y después centrarlo
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        
        
    }
    
   
}
