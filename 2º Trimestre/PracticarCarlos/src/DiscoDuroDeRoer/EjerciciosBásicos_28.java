package DiscoDuroDeRoer;

// Eliminar los espacios de una frase pasada por consola por el usuario.

import java.util.Scanner;



public class EjerciciosBásicos_28 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce una frase.");
        String frase = teclado.nextLine();
        System.out.println(frase.replaceAll(" ", ""));
    }
    
}
