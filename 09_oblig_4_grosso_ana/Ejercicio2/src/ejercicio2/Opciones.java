/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author laurix
 */
public class Opciones extends JFrame implements ActionListener{

    private final int anchoVentana = 700;
    private final int altoVentana = 700;
    private final String tituloVentana = "Ventana con Menú";
    
    private FlowLayout miLayout;
    
    private JMenuBar barraMenu;
    private JMenu opcionesMenu;
    private JMenuItem itemRojo, itemVerde, itemAzul;
    private final String txtMenu = "Opciones";
    private final String[] OPCIONES = {"Rojo","Verde","Azul"};
    
    
    public Opciones(){
        
        this.inicializarVentana();
        this.inicializarComponentes();
        this.ver();
    }
    
    public void ver(){
        this.setVisible(true);
    }
    
    public void inicializarVentana(){
        //inicializo el layout
        this.miLayout = new FlowLayout();
        this.setLayout(miLayout);
        
        this.setTitle(tituloVentana);
        this.setSize(anchoVentana, altoVentana);
        this.setLocationRelativeTo(null);
        
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void inicializarComponentes(){
               
        barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);
        opcionesMenu = new JMenu(txtMenu);
        barraMenu.add(opcionesMenu);
        itemRojo = new JMenuItem(OPCIONES[0]);
            itemRojo.addActionListener(this);
            opcionesMenu.add(itemRojo);
        itemVerde = new JMenuItem(OPCIONES[1]);
            itemVerde.addActionListener(this);
            opcionesMenu.add(itemVerde);
        itemAzul = new JMenuItem(OPCIONES[2]);
            itemAzul.addActionListener(this);
            opcionesMenu.add(itemAzul);
       
    }
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
            
        Container contenedor = this.getContentPane();
        
        if (e.getSource()==itemRojo){
            contenedor.setBackground(Color.red);
        }
        if (e.getSource()==itemVerde){
            contenedor.setBackground(Color.green);
        }
        if (e.getSource()==itemAzul){
            contenedor.setBackground(Color.blue);
        }
        
    }
    
}
