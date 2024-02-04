package DiscoDuroDeRoer;

// Pide por teclado un número entero positivo (debemos controlarlo) y muestra  el número de cifras que tiene. Por ejemplo: si introducimos 1250, nos muestre que tiene 4 cifras. Tendremos que controlar si tiene una o mas cifras, al mostrar el mensaje.

import java.util.Scanner;


public class EjerciciosBásicos_19 {

    public static void main(String[] args) {
        int numero;
        int contador = 0;
        Scanner teclado = new Scanner (System.in);
        
        do{
            System.out.println("Introduce un número entero positivo: ");
            numero = teclado.nextInt();
            if(numero<0){
                System.out.println("El número debe ser positivo: ");
            }
        }while(numero<0);
        
        for (int i = numero; i > 0; i/=10) {
            contador++;
        }
        
        System.out.println("El "+numero+" tiene "+contador+" cifras.");
    }
    
}
