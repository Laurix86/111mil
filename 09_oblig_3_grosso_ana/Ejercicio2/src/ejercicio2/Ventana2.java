/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

/**
 *
 * @author laurix
 */
public class Ventana2 extends JFrame implements ActionListener {
    private final String ACC_COPI_FLOR_ATIT ="copiaFlorEnTit" ;
    private final String ACC_SALIR_APP ="salirDeApp";  
    private String tituloVentana = "Flores";
    private int anchoVentana = 550;
    private int altoVentana = 450;
    private FlowLayout layFlot;   
    
    private JLabel lblNombreFlor;
    private JList lstFlores;
    private JButton btnAceptar;         
    private JButton btnSalir;  
    
    private String lblNombreText= "Nombre de flor";             
    private String btnAceptarText= "Aceptar";                 
    private String btnSalirText = "Salir";  
    private String[] flores = {"Margaritas", "Violetas", "Calas", "Orquideas", "Azucenas", "Fresias"};

    public Ventana2() {
        this.inicializarVentana();
        this.inicializarComponentes();
        this.agregarComponentesAVentana();        
    }
    
    public void ver(){
        this.setVisible(true);
    }
    
     private void inicializarVentana(){
       
        layFlot=new FlowLayout();      
        
        this.setTitle(tituloVentana);               
        this.setSize(anchoVentana, altoVentana);    
        this.setLocationRelativeTo(null);
        this.setLayout(layFlot);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     
     private void inicializarComponentes() {
        btnAceptar = new JButton();
        btnSalir = new JButton();
        lblNombreFlor = new JLabel();
        lstFlores = new JList(); 
       
        
        this.lblNombreFlor.setText(this.lblNombreText);
        this.lstFlores.setListData(flores);
        this.lstFlores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.btnAceptar.setText(btnAceptarText);
        this.btnSalir.setText(btnSalirText);
   
    }
     
     private void agregarComponentesAVentana(){
        this.add(lblNombreFlor);
        this.add(lstFlores);
        this.add(btnAceptar);
        this.add(btnSalir);
        
        this.btnAceptar.addActionListener(this);
        this.btnSalir.addActionListener(this);
        this.lstFlores.setSelectedIndex(0);
        this.btnAceptar.setActionCommand(ACC_COPI_FLOR_ATIT);
        this.btnSalir.setActionCommand(ACC_SALIR_APP);
    }
     
     private void setTitulo(String titulo){
        this.tituloVentana= titulo;
        this.setTitle(this.tituloVentana);
    }
    
    private void copiaFlorATit(){
        int aux = this.lstFlores.getSelectedIndex();
        this.setTitulo(flores[aux]);        
    }
    
     private void cerrarAplicacion(){
        this.setVisible(false);
        this.dispose();
        System.exit(0);
    }
    
     private void controlAccion1(ActionEvent e){
        String comando = e.getActionCommand();
        if (comando.equals(ACC_COPI_FLOR_ATIT)){
            this.copiaFlorATit();          
        }
        else if (comando.equals(ACC_SALIR_APP)){
            this.cerrarAplicacion();
        }        
    }    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.controlAccion1(e);
    }
}
