/*
Título: Alumnos
Tamaño: 600 px x 400 px
Debe contener:
1 etiqueta Nombre y su campo de texto
1 etiqueta Apellido y su campo de texto
1 botón de Aceptar, al hacer click en el botón deben aparecer el nombre y el
apellido en el título de la ventana
1 botón de Salir, debe cerrar la aplicación
 */
package ejercicio1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author laurix
 */
public class Ventana1 extends JFrame implements ActionListener {
    private final String ACC_COPI_NOM_APE_ATIT ="copiaNomApeEnTit" ;
    private final String ACC_SALIR_APP ="salirDeApp";  
    private String tituloVentana = "Alumnos";
    private int anchoVentana = 600;
    private int altoVentana = 400;
    private FlowLayout layFlot;   
    
    private JLabel lblNombre;
    private JLabel lblApellido; 
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JButton btnAceptar;         
    private JButton btnSalir;  
    
    private String lblNombreText= "Nombre: ";             
    private String lblApellidoText = "Apellido:  ";  
    private String txtNombreText= "";             
    private String txtApellidoText = ""; 
    private String btnAceptarText= "Aceptar";                 
    private String btnSalirText = "Salir";     
    
    
    public Ventana1() {
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
        
        this.lblNombre.setText(this.lblNombreText);
        this.txtNombre.setText(this.txtNombreText);
        this.lblApellido.setText(this.lblApellidoText);
        this.txtApellido.setText(this.txtApellidoText);
        this.btnAceptar.setText(btnAceptarText);
        this.btnSalir.setText(btnSalirText);
   
    }
    
    private void agregarComponentesAVentana(){
        this.add(lblNombre);
        this.add(txtNombre);
        this.add(lblApellido);
        this.add(txtApellido);
        this.add(btnAceptar);
        this.add(btnSalir);
        
        this.btnAceptar.addActionListener(this);
        this.btnSalir.addActionListener(this);
        this.btnAceptar.setActionCommand(ACC_COPI_NOM_APE_ATIT);
        this.btnSalir.setActionCommand(ACC_SALIR_APP);
    }

    private void setTitulo(String titulo){
        this.tituloVentana= titulo;
        this.setTitle(this.tituloVentana);
    }
    
    private void copiaApeNomATit(){
        String aux= this.txtApellido.getText() + ", "+ this.txtNombre.getText();
        this.setTitulo(aux);        
    }
    
    private void cerrarAplicacion(){
        this.setVisible(false);
        this.dispose();
        System.exit(0);
    }
    
    private void controlAccion1(ActionEvent e){
        String comando = e.getActionCommand();
        if (comando.equals(ACC_COPI_NOM_APE_ATIT)){
            this.copiaApeNomATit();          
        }
        else if (comando.equals(ACC_SALIR_APP)){
            this.cerrarAplicacion();
        }        
    }    
    /*private void controlAccion2(ActionEvent e){
        Object fuente = e.getSource();
        if (fuente==btnAceptar){
            this.copiaApeNomATit();          
        }
        else if (fuente==btnSalir){
            this.cerrarAplicacion();
        }        
    }*/
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.controlAccion1(e);
    }
    
    
    
}
