/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1corregido;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class VentanaCorregida extends JFrame implements ActionListener {

    //CONSTANTES para identificar acciones
    private final String ACC_COPI_NOM_APE_ATIT ="copiaNomApeEnTit" ;
    private final String ACC_SALIR_APP ="salirDeApp";      
    
    private int anchoVentana = 600;
    private int altoVentana = 400;
    private String tituloVentana = " - - - - - ";
    
    private FlowLayout layFlot;            // layout flotante

    // label
    private JLabel lblNombre;
    private JLabel lblApellido;   
    // texto de los label
    private String lblNombreText= "Nombre: ";             
    private String lblApellidoText = "Apellido:  ";   
    
    //textfield
    private JTextField txtNombre;
    private JTextField txtApellido;  
    // texto de los label
    private String txtNombreText= "";             
    private String txtApellidoText = ""; 
    
    // botones
    private JButton btnAceptar;         // boton 
    private JButton btnSalir;           // boton    
    // texto de los botones
    private String btnAceptarText= "Aceptar";                 
    private String btnSalirText = "Salir";       
 
    public VentanaCorregida() {
        this.inicializarVentana();
        this.inicializarComponentes();
        this.agregarComponentesAVentana();        
    }
    
    public void ver(){
        this.setVisible(true);
    }
    private void inicializarVentana(){
        //** creamos un layout
        layFlot=new FlowLayout();       // instancia el layout flotante
        
        //** seteamos ventana
        this.setTitle(tituloVentana);               //titulo a la ventana
        this.setSize(anchoVentana, altoVentana);    // tamanio a la ventana (ancho, altoVentana)
        this.setLocationRelativeTo(null);           // centramos la ventana en la pantalla
        this.setLayout(layFlot);                    // Usamos un layout, donde se "montaran" los componentes
        this.setResizable(false);                   // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // termina los proceso al salir(cerrar ventana)
    } 
    
    private void inicializarComponentes() {
        //** creamos los componentes
        btnAceptar = new JButton();
        btnSalir = new JButton();
        lblNombre = new JLabel();
        lblApellido = new JLabel();
        txtNombre = new JTextField(10);
        txtApellido = new JTextField(10);  
        
        //** configuramos los componentes
        this.lblNombre.setText(this.lblNombreText);
        this.txtNombre.setText(this.txtNombreText);
        this.lblApellido.setText(this.lblApellidoText);
        this.txtApellido.setText(this.txtApellidoText);
        this.btnAceptar.setText(btnAceptarText);
        this.btnSalir.setText(btnSalirText);
   
    }
    
    private void agregarComponentesAVentana(){
        // ** agregamos los componentes a la ventana
        this.add(lblNombre);
        this.add(txtNombre);
        this.add(lblApellido);
        this.add(txtApellido);
        this.add(btnAceptar);
        this.add(btnSalir);
        
        //** agregar los listener (oyente) para capturar eventos 
        //   que los utilizará ActionListener para capturar el evento   
        this.btnAceptar.addActionListener(this);
        this.btnSalir.addActionListener(this);
            // se puede asignar a cada componente un string a la propiedad 
            // ActionCommand del componente, para identificar una acción
            this.btnAceptar.setActionCommand(ACC_COPI_NOM_APE_ATIT);
            this.btnSalir.setActionCommand(ACC_SALIR_APP);
    }
    
    private void setTitulo(String titulo){
        this.tituloVentana= titulo;    // Asigna la variable
        this.setTitle(this.tituloVentana);   // setea el titulo en el formulario
    }
            
    private void copiaApeNomATit(){
        // copia apellido y nombre en el título de la ventana
        String aux= this.txtApellido.getText() + ", "+ this.txtNombre.getText();
        this.setTitulo(aux);        
    }
    private void cerrarAplicacion(){
        // cierra la aplicacion
        this.setVisible(false); // hace invisible la ventana (pero sigue en memoria y no sale de la aplicacion)
        this.dispose();         // elimina la ventana de la memoria
        System.exit(0);         // sale de la aplicación (es util cuando es el ultimo formulario y se desea cerrar toda la aplicacion)
                        
    }
    
    //** control de las acciones del formulario    
    private void controlAccion1(ActionEvent e){
        //(1) control de la accion por identificación del nombre del comando
        String comando = e.getActionCommand();    //obtener el comando del objeto que disparo el evento
        if (comando.equals(ACC_COPI_NOM_APE_ATIT)){
            this.copiaApeNomATit();          
        }
        else if (comando.equals(ACC_SALIR_APP)){
            this.cerrarAplicacion();
        }        
    }    
    private void controlAccion2(ActionEvent e){
        //(2) control de la accion por identificación del objeto fuente
        Object fuente = e.getSource();      //obtener el objeto que genero la acción
        if (fuente==btnAceptar){
            this.copiaApeNomATit();          
        }
        else if (fuente==btnSalir){
            this.cerrarAplicacion();
        }        
    }
    
    //** La captura del evento
    /*
    - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    actionPerformed(ActionEvent e) es un método de ActionListener . Se ejecuta
    cuando se detecta un evento de los agregados como oyentes
    ActionListener se usa para detectar y manejar eventos, los cuales tienen 
    lugar cuando se produce una acción sobre un elemento del programa.- - - - - - - - - - - - - - - - - - - - - - - - - - - -
    */
    @Override
    public void actionPerformed(ActionEvent e){
        // Aqui el código que queremos que se ejecute cuando tiene lugar la acción.
        
        this.controlAccion1(e);
        //this.controlAccion2(e);

    }   
}
