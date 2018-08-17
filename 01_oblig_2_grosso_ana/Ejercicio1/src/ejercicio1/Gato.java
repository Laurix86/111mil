/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

/**
 *
 * @author laurix
 */
public class Gato {
    private String nombre;
    private String raza;
    private String color;
    
    
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    
     public String getRaza() {
        return raza;
    }

    public void setRaza(String p_raza) {
        this.raza = p_raza;
    }
    
     public String getColor() {
        return color;
    }

    public void setColor(String p_color) {
        this.color = p_color;
    }
    
    public String maullar(){
        return "Miaauuu!";
    }
    
    public String caminar(int p_pasos){
        return "Avanza " + p_pasos + " pasos.";
    }
    
    public String saltar (int p_centim){
        return "Salta " + p_centim + " centímetros hacia arriba.";
    }
    
    public String jugar() {
        return "Juega con la lana.";
    }
    
    
}

