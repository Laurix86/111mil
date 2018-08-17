/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author laurix
 */
public class Ventana5 {
    JFrame ventana = new JFrame();
    JCheckBox check1 = new JCheckBox("JAVA", true);
    JCheckBox check2 = new JCheckBox("PHP");
    JCheckBox check3 = new JCheckBox("C#");
    JCheckBox check4 = new JCheckBox("COBOL");
    JCheckBox check5 = new JCheckBox("JAVASCRIPT");
    
    
    public void crearVentana(){
        ventana.setTitle("Ventana con casillas de selección múltiple");
        ventana.setSize(650, 550);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new FlowLayout());
        ventana.add(check1);
        ventana.add(check2);
        ventana.add(check3);
        ventana.add(check4);
        ventana.add(check5);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
