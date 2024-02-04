package DiscoDuroDeRoer;

// Realiza una aplicación que nos pida un número de ventas a introducir, después nos pedirá tantas ventas por teclado como número de ventas se hayan indicado. Al final mostrara la suma de todas las ventas. Piensa que es lo que se repite y lo que no.

import java.util.Scanner;


public class EjerciciosBásicos_13 {

    public static void main(String[] args) {
        double suma = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número de ventas: ");
        int num = teclado.nextInt();
        
        for (int i = 1; i <= num; i++) {
            System.out.println("Introduce el precio de venta "+i+":");
            double venta = teclado.nextDouble();
            suma = suma + venta;
        }
        System.out.println("El total de la suma es: "+suma);
    }
    
}
