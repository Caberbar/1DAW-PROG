package Tema1;

import java.util.Scanner;

public class Actividad_resuelta_4_pg26 {

    public static void main(String[] args) {
        int edad;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el año actual: ");
        int añoActual = teclado.nextInt();
        System.out.println("Introduce tu año de nacimiento: ");
        int añoNacido = teclado.nextInt();
        edad = añoActual - añoNacido;
        System.out.println("Tu edad actual es: "+edad);
    }
    
}
