package DiscoDuroDeRoer;

//Lee un n�mero por teclado y muestra por consola, el car�cter al que pertenece en la tabla ASCII. Por ejemplo: si introduzco un 97, me muestre una a.

import java.util.Scanner;


public class EjerciciosB�sicos_7 {

    public static void main(String[] args) {
       Scanner teclado = new Scanner (System.in); 
       System.out.println("Introduce un c�digo de la tabla ASCII: ");
       int codigo = teclado.nextInt();
       char caracter = (char) codigo;
       System.out.println("El c�digo es: "+caracter);
    }
    
}
