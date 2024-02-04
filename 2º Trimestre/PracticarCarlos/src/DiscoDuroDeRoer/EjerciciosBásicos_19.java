package DiscoDuroDeRoer;

// Pide por teclado un n�mero entero positivo (debemos controlarlo) y muestra  el n�mero de cifras que tiene. Por ejemplo: si introducimos 1250, nos muestre que tiene 4 cifras. Tendremos que controlar si tiene una o mas cifras, al mostrar el mensaje.

import java.util.Scanner;


public class EjerciciosB�sicos_19 {

    public static void main(String[] args) {
        int numero;
        int contador = 0;
        Scanner teclado = new Scanner (System.in);
        
        do{
            System.out.println("Introduce un n�mero entero positivo: ");
            numero = teclado.nextInt();
            if(numero<0){
                System.out.println("El n�mero debe ser positivo: ");
            }
        }while(numero<0);
        
        for (int i = numero; i > 0; i/=10) {
            contador++;
        }
        
        System.out.println("El "+numero+" tiene "+contador+" cifras.");
    }
    
}
