package DiscoDuroDeRoer;

// Realizar la suma del 1 al numero que indiquemos, este debe ser mayor que 1. 

import java.util.Scanner;


public class EjerciciosBásicos_26 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int num, aux=0;
        do{
           System.out.println("Introduce un número mayor a 1: ");
           num = teclado.nextInt();
        }while(num<2);
        for (int i = 1; i <= num; i++) {
            aux += i;
        }
        
        System.out.println("El resultado es: "+aux);
    }
    
}
