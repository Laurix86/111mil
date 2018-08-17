/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.util.Scanner;

/**
 *
 * @author laurix
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        int[] arrEnteros = new int[10];
        int contNeg = 0, contPos = 0;
        
        Scanner teclado = new Scanner(System.in);
        
        for (int i = 0; i<= 9; i++){
            System.out.println("Ingrese un número entero, positivo o negativo.");
            arrEnteros[i] = teclado.nextInt();
        }
        
        for (int elem: arrEnteros){
           if (elem < 0) {
               contNeg++;
           } else {
               contPos++;
           }
        }

        System.out.println("El promedio de valores positivos es: " + (contPos * 100) / 10);
        System.out.println("El promedio de valores negativos es: " + (contNeg * 100) / 10);

        
        
        
    }
}
    
