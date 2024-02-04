package DiscoDuroDeRoer;

//Lee un número por teclado y muestra por consola, el carácter al que pertenece en la tabla ASCII. Por ejemplo: si introduzco un 97, me muestre una a.

import java.util.Scanner;


public class EjerciciosBásicos_7 {

    public static void main(String[] args) {
       Scanner teclado = new Scanner (System.in); 
       System.out.println("Introduce un código de la tabla ASCII: ");
       int codigo = teclado.nextInt();
       char caracter = (char) codigo;
       System.out.println("El código es: "+caracter);
    }
    
}
