/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout; 
import static javax.swing.GroupLayout.Alignment.TRAILING;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class RGB extends JFrame implements ActionListener {
 
    private final int anchoVentana = 700;
    private final int altoVentana = 700;
    private String tituloVentana = "RGB - Creando colores";
   
    private GroupLayout layGroup; 
    
    private JComboBox cmbRojo;
    private JComboBox cmbVerde;
    private JComboBox cmbAzul;
    
    private JLabel lblRojo;
    private JLabel lblVerde;
    private JLabel lblAzul;
    
    private String textLblRojo = "Rojo: ";             
    private String textLblVerde = "Verde: ";   
    private String textLblAzul = "Azul: "; 
  
    private JButton btnColor;  
    private String btnFijarColor = "Fijar color";   
    
    public RGB() {
        this.inicializarVentana();
        this.setTitulo(tituloVentana);
        this.inicializarComponentes();
        this.agregarComponentesAVentana();    
        this.agregarAccionAComponente();
        this.ver();
    }
   
    private void ver(){
        this.setVisible(true);
    }
    
    private void inicializarVentana(){
      
        this.layGroup= new GroupLayout(this.getContentPane());
        this.setLayout(layGroup);                    
        this.setTitle(tituloVentana);           
        this.setSize(anchoVentana, altoVentana);   
        this.setLocationRelativeTo(null);     
        this.setResizable(true); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
    
    private void inicializarComponentes() {

        lblRojo = new JLabel();
        lblVerde = new JLabel();
        lblAzul = new JLabel();
            
        this.cmbRojo = new JComboBox();
        this.cmbVerde = new JComboBox();
        this.cmbAzul = new JComboBox();
                       
        btnColor= new JButton();

        this.lblRojo.setText(this.textLblRojo);
        this.lblVerde.setText(this.textLblVerde);       
        this.lblAzul.setText(this.textLblAzul);
         
        cmbRojo = new JComboBox();
        for (int i=0;i<=255;i++){
            cmbRojo.addItem(i);}
        
        cmbVerde = new JComboBox();
        for (int i=0;i<=255;i++){
            cmbVerde.addItem(i);}
        
        cmbAzul = new JComboBox();
        for (int i=0;i<=255;i++){
            cmbAzul.addItem(i);}
                
        this.btnColor.setText(btnFijarColor);
        
    }
    
    private void agregarComponentesAVentana(){
       
        inicializarLayoutGrupal();
        
    }
    
    private void inicializarLayoutGrupal(){
       
        this.layGroup.setAutoCreateGaps(true);
        this.layGroup.setAutoCreateContainerGaps(true);        

        this.layGroup.setHorizontalGroup(this.layGroup.createParallelGroup(TRAILING)
            .addGroup(this.layGroup.createSequentialGroup()
                .addComponent(this.lblRojo)
                .addComponent(this.cmbRojo))
            .addGroup(this.layGroup.createSequentialGroup()
                .addComponent(this.lblVerde)
                .addComponent(this.cmbVerde))
            .addGroup(this.layGroup.createSequentialGroup()
                .addComponent(this.lblAzul)
                .addComponent(this.cmbAzul))
            .addGroup(this.layGroup.createSequentialGroup()
                .addComponent(this.btnColor))
        );
        this.layGroup.setVerticalGroup(this.layGroup.createSequentialGroup()
            .addGroup(this.layGroup.createParallelGroup()
                .addComponent(this.lblRojo)
                .addComponent(this.cmbRojo))
            .addGroup(this.layGroup.createParallelGroup()
                .addComponent(this.lblVerde)
                .addComponent(this.cmbVerde))
            .addGroup(this.layGroup.createParallelGroup()
                .addComponent(this.lblAzul)
                .addComponent(this.cmbAzul))
            .addGroup(this.layGroup.createParallelGroup()
                .addGap(20)) //Agrego espacio para separa los botones del resto
            .addGroup(this.layGroup.createParallelGroup()
                .addComponent(this.btnColor))
        );
        
        this.layGroup.linkSize(SwingConstants.HORIZONTAL,this.lblRojo,this.lblAzul,this.lblVerde);
        this.layGroup.linkSize(SwingConstants.VERTICAL,this.lblRojo,this.lblAzul,this.lblVerde);
        this.layGroup.linkSize(SwingConstants.HORIZONTAL,this.cmbRojo,this.cmbAzul,this.cmbVerde);
        this.layGroup.linkSize(SwingConstants.VERTICAL,this.cmbRojo,this.cmbAzul,this.cmbVerde);
        this.layGroup.linkSize(SwingConstants.HORIZONTAL,this.btnColor);
        this.pack();    
    }
    
     private void setTitulo(String titulo){
        this.tituloVentana = titulo;  
        this.setTitle(this.tituloVentana); 
    }

    private void agregarAccionAComponente(){
        this.btnColor.addActionListener(this);
        this.btnColor.setActionCommand(btnFijarColor);
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnColor){
            int red = Integer.parseInt(this.cmbRojo.getSelectedItem().toString());
            int green = Integer.parseInt(this.cmbVerde.getSelectedItem().toString());
            int blue =Integer.parseInt(this.cmbAzul.getSelectedItem().toString());
            Color colorido = new Color(red, green, blue);
            this.btnColor.setBackground(colorido);
        
        
        }
    
    }
    
}
