/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author laurix
 */
public class Ventana3 extends JFrame implements ActionListener {
    private final String ACC_COPI_DATOS_ATIT ="copiaDatosEnTit" ;
    private final String ACC_SALIR_APP ="salirDeApp"; 

    private String tituloVentana = "Pasajero";
    private int anchoVentana = 700;
    private int altoVentana = 500;
    private FlowLayout layFlot;   
    
    private JLabel lblNombre;
    private JLabel lblApellido; 
    private JTextField txtNombre;
    private JTextField txtApellido;
    private ButtonGroup bgpEstadoCivil;
    private JRadioButton radSoltero, radCasado, radViudo, radDivorciado;
    private JList lstPaises;
    private JCheckBox chkEspañol, chkIngles, chkAleman, chkRuso;
    private JButton btnAceptar;         
    private JButton btnSalir;  
    
    private String lblNombreText= "Nombre: ";             
    private String lblApellidoText = "Apellido:  ";  
    private String txtNombreText= "";             
    private String txtApellidoText = "";
    private String[] paises = {"España", "Inglaterra", "Alemania", "Rusia"};
    private String soltero = "Soltero";
    private String casado = "Casado";
    private String viudo = "Viudo";
    private String divorciado = "Divorciado";
    private String español = "Español";
    private String ingles = "Inglés";
    private String aleman = "Alemán";
    private String ruso = "Ruso";
    private String btnAceptarText= "Aceptar";                 
    private String btnSalirText = "Salir";     
    
    
    public Ventana3() {
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
        lblNombre = new JLabel();
        lblApellido = new JLabel();
        txtNombre = new JTextField(10);
        txtApellido = new JTextField(10);
        bgpEstadoCivil = new ButtonGroup();
        radSoltero = new JRadioButton();
        radCasado = new JRadioButton();
        radViudo = new JRadioButton();
        radDivorciado = new JRadioButton();
        lstPaises = new JList();
        chkEspañol = new JCheckBox();
        chkIngles = new JCheckBox();
        chkAleman = new JCheckBox();
        chkRuso = new JCheckBox();
        
        this.lblNombre.setText(this.lblNombreText);
        this.txtNombre.setText(this.txtNombreText);
        this.lblApellido.setText(this.lblApellidoText);
        this.txtApellido.setText(this.txtApellidoText);
        this.radSoltero.setText(this.soltero);
        this.radSoltero.setActionCommand(soltero);
        this.radCasado.setText(this.casado);
        this.radCasado.setActionCommand(casado);
        this.radViudo.setText(this.viudo);
        this.radViudo.setActionCommand(viudo);
        this.radDivorciado.setText(this.divorciado);
        this.radDivorciado.setActionCommand(divorciado);
        this.lstPaises.setListData(paises);
        this.lstPaises.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);;
        this.chkEspañol.setText(this.español);
        this.chkIngles.setText(this.ingles);
        this.chkAleman.setText(this.aleman);
        this.chkRuso.setText(this.ruso);
        this.btnAceptar.setText(btnAceptarText);
        this.btnSalir.setText(btnSalirText);
        
       
   
    }
    
    private void agregarComponentesAVentana(){
        this.add(lblNombre);
        this.add(txtNombre);
        this.add(lblApellido);
        this.add(txtApellido);
        this.bgpEstadoCivil.add(radSoltero);
        this.bgpEstadoCivil.add(radCasado);
        this.bgpEstadoCivil.add(radViudo);
        this.bgpEstadoCivil.add(radDivorciado);
        this.add(radSoltero);
        this.add(radCasado);
        this.add(radDivorciado);
        this.add(radViudo);
        this.add(lstPaises);
        this.add(chkEspañol);
        this.add(chkIngles);
        this.add(chkAleman);
        this.add(chkRuso);
        this.add(btnAceptar);
        this.add(btnSalir);
        
        this.btnAceptar.addActionListener(this);
        this.btnSalir.addActionListener(this);
        this.btnAceptar.setActionCommand(ACC_COPI_DATOS_ATIT);
        this.btnSalir.setActionCommand(ACC_SALIR_APP);
    }

    private void setTitulo(String titulo){
        this.tituloVentana= titulo;
        this.setTitle(this.tituloVentana);
    }
    
    private void copiaDatosATit(){
        String auxIdiomas = "";
        //Seguramente hay una forma mejor con un action listener o event pero no terminé de encontrarle la vuelta
        if(chkEspañol.isSelected()== true){auxIdiomas = auxIdiomas + ", " + chkEspañol.getText();}
        if(chkIngles.isSelected()== true){auxIdiomas = auxIdiomas + ", " + chkIngles.getText();}
        if(chkAleman.isSelected()== true){auxIdiomas = auxIdiomas + ", " + chkAleman.getText();}
        if(chkRuso.isSelected()== true){auxIdiomas = auxIdiomas + ", " + chkRuso.getText();}

        String aux= this.txtApellido.getText() + ", "+ this.txtNombre.getText() + "\n País de destino: " + lstPaises.getSelectedValue() + "\n Estado civil: " + bgpEstadoCivil.getSelection().getActionCommand() + "\n Idiomas: " + auxIdiomas; 
        JOptionPane.showMessageDialog(null, aux);      
    }
    
     private void cerrarAplicacion(){
        this.setVisible(false);
        this.dispose();
        System.exit(0);
    }
    
     private void controlAccion1(ActionEvent e){
        String comando = e.getActionCommand();
        if (comando.equals(ACC_COPI_DATOS_ATIT)){
            this.copiaDatosATit();          
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
