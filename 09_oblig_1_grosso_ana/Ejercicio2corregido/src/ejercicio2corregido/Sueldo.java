/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2corregido;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author laurix
 */
public class Sueldo {
    public static final int CANT_MESES = 12;
    public static final String[] mes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo",
        "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static final String msjIngSueldo =  "Ingresar sueldo ";
    public static final String msjTotal_1 =  "El total es : ";
    public static final String msjTotal_2 =  "hasta el mes de ";
    
    private String nomPane ="";     // Información de la cabecera de la ventana que se esta ejecutando
    private String infoPane ="";    // Información del cuerpo de la ventana que se esta ejecutando      
    private int tipoBoton=0;        // 0: (Si, No),  1: (Si, No, Cancelar), 2 (Aceptar, cancelar)
    private int tipoPanel=2;        // 0:Error 1:Informacion, 2:Advertencia o 3: Pregunta
    private JOptionPane panel;
    
    DecimalFormat formato = new DecimalFormat("#.###"); 
            
    private boolean cancelar=false; //indica si cancela ingreso (tanto con boton cancelar como con un negativo
                                    // false: no cancela
    private int mesActual=0;        //de 1 a 12
    private double sueldo=0;
    private double sueldoTotal=0;    
    private String strSueldo;
       
        
    //** GET y SET INICIO*//
    
        private void acumularSueldo(){
            this.sueldoTotal=this.sueldoTotal+this.sueldo;            
        }
        private void incrementarMes(){       
                this.mesActual=this.mesActual+1;           
        }
        private String getMes(){
            // obtiene el mes en string desde el arreglo pre-cargado
            System.out.println(this.mesActual);
            if(this.mesActual<=(CANT_MESES)&&this.mesActual>=1)
                return mes[this.mesActual-1];
            return " * * * * "; // Retorna cuando el mesActual esta fuera de rango
        }
        private boolean proximoMes(){
            // maneja el incremento del mes
            // retorna falso cuando no lo puede realizar, ya que quedaría fuera de rango
            if(this.mesActual<CANT_MESES){ 
                this.incrementarMes();
                return true;
            }
            else
                return false;
        }
        
        private void setNomPane(String nomPane ){
            this.nomPane=nomPane;
        }
        private String getNomPane(){
            return this.nomPane;
        }

        private void setInfoPane(String infoPane ){
            this.infoPane=infoPane;
        }
        private String getInfoPane(){
            return this.infoPane;
        }
    
        private void setTipoBoton(int tipoBoton){
            this.tipoBoton=tipoBoton;
        }
        private int getTipoBoton(){
            return this.tipoBoton;
        }  
        
        private void setTipoPanel(int tipoPanel){
            this.tipoPanel=tipoPanel;
        }
        private int getTipoPanel(){
            return this.tipoPanel;
        }    
        
    //** GET y SET   FIN*//
    
    // metodo público
    public void cargar(){               
        while(proximoMes()&&entrada()){            
            this.acumularSueldo(); 
        }
        mostraTotal();
        
    }
       
    // metodo privados
    private boolean entrada(){        
        this.setInfoPane(msjIngSueldo +this.getMes()+" ("+this.mesActual+")");        
        this.strSueldo= panel.showInputDialog(this.getInfoPane());// ***Ingreso valor
        // al cancelar retorna el valor null.        
        if (this.strSueldo != null && !this.strSueldo.equals("")) {           // si no es cancelar y si no esta vacio el input  
            this.sueldo = Double.parseDouble(this.strSueldo);
            System.out.println(this.sueldo);
            if (this.sueldo <0){
                this.cancelar=true; // indica que cancela ingreso
            }     
        }
        else{
            this.cancelar=true;     // indica que cancela ingreso
        }
        return !this.cancelar;
    }
    
    private void mostraTotal(){
        if (this.cancelar){
            this.mesActual=this.mesActual-1;
        }
        this.setInfoPane(msjTotal_1 + formato.format(this.sueldoTotal)+" "+
                msjTotal_2 +this.getMes());
        panel.showMessageDialog(null, this.getInfoPane() );
        
    }
    
}


         /*
        opcion (JOptionPane retorna valor del boton apretado)
            tipoBoton 0 (Si, No)
                0)si
                1)no
               -1)X de la ventana 
            tipoBoton 1 (Si, No, Cancelar)
                0)si
                1)no
                2)cancelar
               -1)X de la ventana 
            tipoBoton 2 (Aceptar, cancelar)
                0)Aceptar
                2)Cancelar
               -1)X de la ventana 
        */
