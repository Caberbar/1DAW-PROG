package DiscoDuroDeRoer;

import java.util.Scanner;


//Crea una aplicación que nos cuente el número de cifras de un número entero 
//positivo (hay que controlarlo) pedido por teclado. Crea un método que realice 
//esta acción, pasando el número por parámetro, devolverá el número de cifras.

public class EjerciciosMétodosyFunciones_6 {

    public static void main(String[] args) {
        int num;
        Scanner teclado = new Scanner (System.in);
        
        do{
        System.out.println("Introduce un número entero positivo: ");
        num = teclado.nextInt();
        }while(num<1);
        
        System.out.println("El número "+num+" tiene "+calcularCifras(num)+" cifra/s.");
    }

    public static int calcularCifras(int num) {
        int cont = 0;
        for (int i = num; i > 0; i/=10) {
            cont++;
        }
        
        return cont;

    }
    
}
