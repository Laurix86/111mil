/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.util.Scanner;

/**
 *
 * @author laurix
 */
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
       String[] Alumnos = new String[5];
       double[][] Notas = new double[3][5];
       double prom = 0;
       
       for (int i = 0; i <=4; i++){
            System.out.println("Ingresar el nombre del alumno: ");
            Alumnos[i] = teclado.nextLine();
            
            for(int j= 0; j<=2; j++ ){
                System.out.print("Ingrese las notas del alumno: ... ");
                Notas[j][i] = teclado.nextDouble();
            }
            System.out.println();
            teclado.nextLine();
            
       }
        System.out.println("El resultado de los promedios es: ");
       for(int i=0; i<=4; i++){
           for(int j=0; j<=2; j++){
               prom += Notas[j][i];
           }
           System.out.println("El promedio de " + Alumnos[i] + " es: " + prom/3);
           prom = 0;
       }
        
    }
    
}
