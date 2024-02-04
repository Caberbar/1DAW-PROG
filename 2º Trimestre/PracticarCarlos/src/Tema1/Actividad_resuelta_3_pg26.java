package Tema1;

import java.util.Scanner;

public class Actividad_resuelta_3_pg26 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce tu edad: ");
        int edad = teclado.nextInt();
        edad += 1;
        System.out.println("El año que viene tu edad será: "+edad);
    }
    
}
