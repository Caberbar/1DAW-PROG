package Tema1;

import java.util.Scanner;

public class Actividad_resuelta_4_pg26 {

    public static void main(String[] args) {
        int edad;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el a�o actual: ");
        int a�oActual = teclado.nextInt();
        System.out.println("Introduce tu a�o de nacimiento: ");
        int a�oNacido = teclado.nextInt();
        edad = a�oActual - a�oNacido;
        System.out.println("Tu edad actual es: "+edad);
    }
    
}
