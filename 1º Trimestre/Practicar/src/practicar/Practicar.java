package practicar;

import practicar.LeerDatosTeclado;
import practicar.Operaciones;
import java.util.Scanner;

public class Practicar {

    
    public static void main(String[] args) {
        // TODO code application logic here
    
        int numero[][] = new int [10][10];
        
        for (int i = 0; i < numero.length; i++) {
            for (int j = 0; j < numero[0].length; j++) {
                numero[i][j] = (int) (Math.random()*101)+200;
                System.out.printf("%5d   ",numero[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        
        int maximo = 200;
        int minimo = 300;
        int suma = 0;
        
        for (int i = 0; i < numero.length; i++) {
            int numeros = numero[i][i];
            System.out.println(numeros + " ");
            if (numeros > maximo) {
                maximo = numeros;
            }
            if (numeros < minimo) {
                minimo = numeros;
            }
            suma += numeros;
        }
        
        System.out.println();
        System.out.println("Máximo "+maximo);
        System.out.println("Mínimo "+minimo);
        System.out.println("Suma "+suma);
    }    
}

