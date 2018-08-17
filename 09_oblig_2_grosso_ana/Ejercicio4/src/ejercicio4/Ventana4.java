/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author laurix
 */
public class Ventana4 {
    JFrame ventana = new JFrame();
    JList lista;
    JComboBox combo;
    String[] colores = {"rojo", "naranja", "amarillo", "verde", "cian", "azul", "violeta"};
    
    public void crearVentana(){
        ventana.setTitle("Ventana con lista desplegable");
        ventana.setSize(500, 500);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new FlowLayout());
        //hice lista y combo porque no sabía cuál de los dos pedía
        ventana.add(lista = new JList(colores)); 
        ventana.add(combo = new JComboBox(colores));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
