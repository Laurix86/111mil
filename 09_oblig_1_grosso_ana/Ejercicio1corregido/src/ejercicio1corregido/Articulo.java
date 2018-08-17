/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1corregido;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author laurix
 */
public class Articulo {
    private String nomPane = "";
    private String infoPane ="";
    private int tipoBoton = 0; // 0: si, no / 1: si, no, cancelar / 2: aceptar, cancelar
    private int tipoPanel = 2; //0: error / 1: informacion / 2: advertencia / 3: pregunta
    private JOptionPane panel;
    
    private double valUni = 0;
    private int cantArt = 0;
    private double total = 0;
    DecimalFormat formato = new DecimalFormat ("#.##");
    private String strValUni, strCantArt;
    
    private static final String infoSeguir = "Desea seguir...";
    private static final String msjSeguir = "¿Desea ingresar otro artículo? [S/N]";
    private static final String msjValArt = "Ingrese el valor unitario del Articulo";
    private static final String msjCantArt = "Ingrese la cantidad de Articulos";
    private static final String msjTotal = "El total es: ";
    
    //Get y Set
    private void setNomPane(String nomPane){
        this.nomPane = nomPane;
    }
    private String getNomPane(){
        return this.nomPane;
    }
    private void setInfoPane(String infoPane){
        this.infoPane = infoPane;
    }
    private String getInfoPane(){
        return infoPane;
    }
    private void setTipoBoton(int tipoBoton){
        this.tipoBoton = tipoBoton;
    }
    private int getTipoBoton(){
        return this.tipoBoton;
    }
    private void setTipoPanel(int tipoPanel){
        this.tipoPanel = tipoPanel;
    }
    private int getTipoPanel(){
        return this.tipoPanel;
    }
    private void setValUni(double valUni){
        this.valUni= valUni;
    }
    private double getValUni(){
        return this.valUni;
    }
    private void setTotal(double total){
        this.total = total;
    }
    private double getTotal(){
        return this.total;
    }
    private void sumTotal(){
        this.total = this.total + (this.getValUni() + this.cantArt);
    }
    private void setCantArt(int cantArt){
        this.cantArt = cantArt;
    }
    private int getCantArt(){
        return this.cantArt;
    }
    private void setStrValUni(String strValUni){
        this.strValUni = strValUni;
    }
    private String getStrValUni(){
        return this.strValUni;
    }
    private void setStrCantArt(String strCantArt){
        this.strCantArt= strCantArt;
    }
    private String getStrCantArt(){
        return this.strCantArt;
    }
    //Fin Get y Set
    
    public void cargar(){
        do{
            if (entrada()){
                this.sumTotal();
            }   
        }while(seguir());
        
        mostraTotal();
    }
    
    // metodos privados
    private boolean seguir(){
        int opcion;
        this.setNomPane(infoSeguir);
        this.setInfoPane(msjSeguir);
        this.setTipoBoton(0);
        this.setTipoPanel(3);
        opcion=panel.showConfirmDialog(null, this.getInfoPane(), 
                this.getNomPane(), this.getTipoBoton(),this.getTipoPanel());
        return opcion==0;
        
    }  
    private boolean entrada(){
        boolean ingreso=true;        
        this.setInfoPane(msjValArt);
        // ***Ingreso de valores ****
        this.setStrValUni(panel.showInputDialog(this.getInfoPane()));
        // al cancelar retorna el valor null.
        
        // si no es cancelar y si no esta vacio el input  
        if (this.strValUni != null && !this.strValUni.equals("")) {  
            this.setValUni(Double.parseDouble(this.strValUni));
            this.setInfoPane(msjCantArt);     
            this.setStrCantArt(panel.showInputDialog(this.getInfoPane()));
            if (this.strCantArt != null && !this.strCantArt.equals("")){
                this.setCantArt(Integer.parseInt(this.strCantArt));
            } 
            else{// selecciono cancelar en la vantana del ingreso de cant. de articulo
                 // o ingreso vacio
                 ingreso=false;
            }               
        }
        else{// selecciono cancelar en la vantana del ingreso de valor por unidad
             // o ingreso vacio
            ingreso = false;
        }
        return ingreso;
        // true  -> indica que la carga fue realizada con exito
        // false -> indica que se cancela la carga por algún motivo
    }
    
    private void mostraTotal(){
       
        this.setInfoPane(msjTotal + formato.format(this.total));
        panel.showMessageDialog(null, this.getInfoPane() );
        
    }
    
}


         /*
        ******************************************************
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
        *******************************************************
        */ 
