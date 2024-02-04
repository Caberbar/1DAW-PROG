package DiscoDuroDeRoer;

// Realiza una aplicaci�n que nos pida un n�mero de ventas a introducir, despu�s nos pedir� tantas ventas por teclado como n�mero de ventas se hayan indicado. Al final mostrara la suma de todas las ventas. Piensa que es lo que se repite y lo que no.

import java.util.Scanner;


public class EjerciciosB�sicos_13 {

    public static void main(String[] args) {
        double suma = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el n�mero de ventas: ");
        int num = teclado.nextInt();
        
        for (int i = 1; i <= num; i++) {
            System.out.println("Introduce el precio de venta "+i+":");
            double venta = teclado.nextDouble();
            suma = suma + venta;
        }
        System.out.println("El total de la suma es: "+suma);
    }
    
}
