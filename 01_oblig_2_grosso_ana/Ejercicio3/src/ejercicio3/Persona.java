/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

/**
 *
 * @author laurix
 */
public class Persona {
    private String nombre;
    private double altura;
    private int edad;
    private String genero;
    
    public int getEdad(){
        return edad;
    }
    
    //Constructor default vacío
    public Persona(){
        
    }
    
    //Constructor completo
    public Persona(String p_nombre, double p_altura, int p_edad, String p_genero){
        this.nombre = p_nombre;
        this.altura = p_altura;
        this.edad = p_edad;
        this.genero = p_genero;
    }
    
}
