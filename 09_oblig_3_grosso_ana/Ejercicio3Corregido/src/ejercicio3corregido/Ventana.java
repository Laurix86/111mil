/*
https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html
https://www.formdev.com/jformdesigner/doc/layouts/grouplayout/
*/
package ejercicio3corregido;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout; 
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.CENTER;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.GroupLayout.Alignment.LEADING;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
A la ventana se le "agrega funcionalidad" para que escuche eventos.
implements ActionListener: agrega la interfaz a la clase ventana
*/
public class Ventana extends JFrame implements ActionListener {

    //CONSTANTES para identificar acciones
    private final String ACC_ENVIAR_DATOS ="enviarDatos" ;
    private final String ACC_SALIR_APP ="salirDeApp";   
    
    private final String[] PAISES = {"Argentina", "Australia", "Brasil", "Canadá",
        "China", "Francia", "Alemania", "India", "Indonesia", "Italia", "Japón",
        "México", "República de Corea", "Rusia", "Arabia Saudita", "Sudáfrica",
        "Turquía", "Reino Unido", "Estados Unidos", "Unión Europea"};
    private final String[] ESTADOS_CIVILES = {"Soltero", "Casado",
        "Viudo", "Conviviente","Divorciado"};
    private final String[] IDIOMAS = {"Español", "Ingles", "Frances", "Chino",
        "Portugués", "Ruso"};
    
    private int anchoVentana = 700;
    private int altoVentana = 500;
    private String tituloVentana = "Pasajero";
    
    //Layout
    private GroupLayout layGrup; 
    

    private JComboBox cmbPaises;
    
    private LinkedList<JCheckBox> lstChkBoxIdiomas;        // lista de checkbox. Se evita declarar todo y ademas pueden crecer en forma dinámica
    private LinkedList<JRadioButton> lstBtnRadEstCiv;      //  lista de btnRad. Se evita declarar todo y ademas pueden crecer en forma dinámica
    private ButtonGroup btgEstadoCivil;                    // grupo de radio button    
    private JPanel pnlIdiomas;                             // panel de idiomas
    private JPanel pnlEstCiv;                              // panel de estado civil
    // titulo para los bordes del panel
    private String tituloBordePnlIdiomas = "Idiomas";
    private String tituloBordePnlEstCiv = "Estado Civil";
        
    // label
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblCmbPaises;
       
    // texto de los label
    private String textLblNombre= "Nombre: ";             
    private String textLblApellido = "Apellido:  ";   
    private String textCmbPaises= "Pais: "; 
    
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
 
    public Ventana() {
        this.inicializarVentana();
        this.inicializarComponentes();
        this.agregarComponentesAVentana();    
        this.agregarAccionAComponente();
        //this.setSize(this.anchoVentana, this.altoVentana); // setear aqui si se quiere ver la ventana en tamaño solicitado
        this.ver();
    }
    
    public void ver(){
        this.setVisible(true);
    }
    private void inicializarVentana(){
        //** creamos un layout para la ventana
        
        this.layGrup= new GroupLayout(this.getContentPane());
        this.setLayout(layGrup);                    // Usamos un layout, donde se "montaran" los componentes    
        
        //** configuramos ventana
        this.setTitle(tituloVentana);               //titulo a la ventana
        this.setSize(anchoVentana, altoVentana);    // tamanio a la ventana (ancho, altoVentana)
        this.setLocationRelativeTo(null);           // centramos la ventana en la pantalla
        
        this.setResizable(true); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // termina los proceso al salir(cerrar ventana)
    } 
    
    private void inicializarComponentes() {
        //** creamos los componentes
        pnlEstCiv= new JPanel();  
        pnlIdiomas = new JPanel();  
        
        lblNombre = new JLabel();
        lblApellido = new JLabel();
        lblCmbPaises = new JLabel();
            
        txtNombre = new JTextField(10);
        txtApellido = new JTextField(10);  
       
        this.cmbPaises= new JComboBox();
        this.lstChkBoxIdiomas = new LinkedList<JCheckBox>();
        this.lstBtnRadEstCiv = new LinkedList<JRadioButton>();     
        btgEstadoCivil = new ButtonGroup();
               
        btnAceptar = new JButton();
        btnSalir = new JButton();
        
        //** configuramos los componentes
        
        // borde y titulo de los paneles
        this.pnlIdiomas.setBorder(BorderFactory.createTitledBorder(this.tituloBordePnlIdiomas));
        this.pnlEstCiv.setBorder(BorderFactory.createTitledBorder(this.tituloBordePnlEstCiv));
        
        this.lblNombre.setText(this.textLblNombre);
        this.txtNombre.setText(this.txtNombreText);
        this.lblApellido.setText(this.textLblApellido);        
        this.txtApellido.setText(this.txtApellidoText);
        this.lblCmbPaises.setText(this.textCmbPaises);
         
        for (String pais : PAISES) {// cargar el combo
            cmbPaises.addItem(pais); 
        } 
        
        for (String estCiv : this.ESTADOS_CIVILES){// cargar radio button, setear titulo y agregar al grupo
            JRadioButton rad=new JRadioButton(estCiv);
            this.lstBtnRadEstCiv.add(rad);
            this.btgEstadoCivil.add(rad);
        }
        
        for (String idioma :IDIOMAS ){ // cargar checkbox de idioma y setear el titulo
            this.lstChkBoxIdiomas.add(new JCheckBox(idioma));
        }      
                
        this.btnAceptar.setText(btnAceptarText);
        this.btnSalir.setText(btnSalirText);
    }
    
    private void agregarComponentesAVentana(){
        // ** agregamos los componentes a la ventana
        // agregar los rad y chk al panel

        for (JRadioButton radEstCiv: this.lstBtnRadEstCiv){
            this.pnlEstCiv.add(radEstCiv);
        }
        for (JCheckBox chkIdioma :lstChkBoxIdiomas ){ // cargar los checkbox al panel
            this.pnlIdiomas.add(chkIdioma);
        }
                
        //.....
        // ** agrega los componentes al layout grupal y los ubica  
        inicializarLayoutGrupal();
        
    }
    private void agregarAccionAComponente(){
        // ** agregamos las acciones a los componentes 
        
        //** agregar los listener (oyente) para capturar eventos 
        //   que los utilizará ActionListener para capturar el evento   
        this.btnAceptar.addActionListener(this);
        this.btnSalir.addActionListener(this);
            // se puede asignar a cada componente un string a la propiedad 
            // ActionCommand del componente, para identificar una acción
           this.btnAceptar.setActionCommand(ACC_ENVIAR_DATOS);
           this.btnSalir.setActionCommand(ACC_SALIR_APP);
     
    }
    
    private void inicializarLayoutGrupal(){
        //** Coloca a cada uno de los componenete en su posicion
        //   hay que configurar en forma horizontal y vertical 
        
        // configuracion general
        this.layGrup.setAutoCreateGaps(true);
        this.layGrup.setAutoCreateContainerGaps(true);        

        // configuracion horizontal
        this.layGrup.setHorizontalGroup(this.layGrup.createParallelGroup(TRAILING)
            .addGroup(this.layGrup.createSequentialGroup()
                .addComponent(this.lblNombre)
                .addComponent(this.txtNombre))
            .addGroup(this.layGrup.createSequentialGroup()
                .addComponent(this.lblApellido)
                .addComponent(this.txtApellido))
            .addGroup(this.layGrup.createSequentialGroup()
                .addComponent(this.lblCmbPaises)
                .addComponent(this.cmbPaises))
            .addGroup(this.layGrup.createSequentialGroup()
                .addComponent(this.pnlEstCiv))
            .addGroup(this.layGrup.createSequentialGroup()
                .addComponent(this.pnlIdiomas))
            .addGroup(this.layGrup.createSequentialGroup()
                .addComponent(this.btnAceptar)
                .addComponent(this.btnSalir))
        );
        // configuracion vertical
        this.layGrup.setVerticalGroup(this.layGrup.createSequentialGroup()
            .addGroup(this.layGrup.createParallelGroup()
                .addComponent(this.lblNombre)
                .addComponent(this.txtNombre))
            .addGroup(this.layGrup.createParallelGroup()
                .addComponent(this.lblApellido)
                .addComponent(this.txtApellido))
            .addGroup(this.layGrup.createParallelGroup()
                .addComponent(this.lblCmbPaises)
                .addComponent(this.cmbPaises))
            .addGroup(this.layGrup.createParallelGroup()       
                .addComponent(this.pnlEstCiv))
            .addGroup(this.layGrup.createParallelGroup()           
                .addComponent(this.pnlIdiomas))
            .addGroup(this.layGrup.createParallelGroup()
                .addGap(20)) //Agrego espacio para separa los botones del resto
            .addGroup(this.layGrup.createParallelGroup()
                .addComponent(this.btnAceptar)
                .addComponent(this.btnSalir))
        );
        
        //configuracion para darle mismo tamaño a los btn, a los txt y a los lbl ...etc
        this.layGrup.linkSize(SwingConstants.HORIZONTAL, this.btnAceptar, this.btnSalir);
        this.layGrup.linkSize(SwingConstants.VERTICAL, txtApellido, txtNombre,this.cmbPaises);
        this.layGrup.linkSize(SwingConstants.HORIZONTAL, txtApellido, txtNombre,this.cmbPaises,this.pnlEstCiv, this.pnlIdiomas);
        this.layGrup.linkSize(SwingConstants.VERTICAL, lblApellido, lblNombre,this.lblCmbPaises);
        this.layGrup.linkSize(SwingConstants.VERTICAL,this.pnlIdiomas,this.pnlEstCiv);

        this.pack();    
        
    }
    
    private void setTitulo(String titulo){
        this.tituloVentana= titulo;    // Asigna la variable
        this.setTitle(this.tituloVentana);   // setea el titulo en el formulario
    }
            
    private void enviarDatos(){
        // copia apellido y nombre en el título de la ventana
        String aux="";
        aux ="Apellido: "+ this.txtApellido.getText() + "\nNombre: "+ this.txtNombre.getText()+"\n";
        aux = aux + "Pais: " + this.cmbPaises.getSelectedItem().toString()+"\n";
        
        aux=aux + "Estado Civil: ";
        for (JRadioButton rad : this.lstBtnRadEstCiv){// cargar radio button, setear titulo y agregar al grupo
            if(rad.isSelected()){
                aux= aux +rad.getText()+"\n";
                
            }
        }
        
        aux=aux + "Idiomas: "; 
        for (JCheckBox chk: this.lstChkBoxIdiomas){
            if(chk.isSelected()){
                aux=aux+chk.getText()+" ";
            }
        }
        
        //System.out.println(aux);
        this.verVenEmergente(aux);
        
    }
    private void verVenEmergente(String msj){

       JOptionPane.showMessageDialog(null, msj );
        
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
        if (comando.equals(ACC_ENVIAR_DATOS)){
            this.enviarDatos();          
        }
        else if (comando.equals(ACC_SALIR_APP)){
            this.cerrarAplicacion();
        }        
    }    
    
    private void controlAccion2(ActionEvent e){
        //(2) control de la accion por identificación del objeto fuente
        Object fuente = e.getSource();      //obtener el objeto que genero la acción
        if (fuente==btnAceptar){
            this.enviarDatos();          
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