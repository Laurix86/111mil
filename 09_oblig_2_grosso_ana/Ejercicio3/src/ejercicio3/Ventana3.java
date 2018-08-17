/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author laurix
 */
public class Ventana3 {
    JFrame ventana = new JFrame();
    JButton botonAzul = new JButton("Azul");
    JButton botonRojo = new JButton("Rojo");
    JButton botonAmarillo = new JButton("Amarillo");
    
    
    public void crearVentana(){
        ventana.setTitle("Ventana con botones");
        ventana.setSize(600, 400);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new FlowLayout());
        ventana.add(botonAzul);
        ventana.add(botonRojo);
        ventana.add(botonAmarillo);
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        
    }
}
