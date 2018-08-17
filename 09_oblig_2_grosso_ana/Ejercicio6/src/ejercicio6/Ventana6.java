/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author laurix
 */
public class Ventana6 {
    JFrame ventana = new JFrame();
    
    
    JRadioButton boton1 = new JRadioButton("Soltero", true);
    JRadioButton boton2 = new JRadioButton("Casado");
    JRadioButton boton3 = new JRadioButton("Viudo");
    JRadioButton boton4 = new JRadioButton("Divorciado");
    JRadioButton boton5 = new JRadioButton("Concubino");
    
    public void crearVentana(){
        ventana.setTitle("Ventana con botones de selección única");
        ventana.setSize(400, 400);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new FlowLayout());
        ventana.add(boton1);
        ventana.add(boton2);
        ventana.add(boton3);
        ventana.add(boton4);
        ventana.add(boton5);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
