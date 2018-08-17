/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;



import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author laurix
 */
public class Ventana2 {
     JFrame ventana = new JFrame();
     JLabel etiqueta = new JLabel("Nombre");
     JTextField cuadro = new JTextField("", 30);
     
    
    public void crearVentana(){
        ventana.setTitle("Ventana con etiquetas");
        ventana.setSize(400, 400);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new FlowLayout());
        ventana.add(etiqueta);
        ventana.add(cuadro);
        ventana.setVisible(true);
        
        
    }
    
}
