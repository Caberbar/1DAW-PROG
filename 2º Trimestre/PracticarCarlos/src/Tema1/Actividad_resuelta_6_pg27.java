package Tema1;

import java.util.Scanner;

public class Actividad_resuelta_6_pg27 {

    public static void main(String[] args) {
        double total;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca la primera nota: ");
        double nota1 = teclado.nextDouble();
        System.out.println("Introduzca la segunda nota: ");
        double nota2 = teclado.nextDouble();
        total = (nota1+nota2)/2;
        System.out.println("La media total es: "+total);
    }
    
}
