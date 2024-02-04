package Tema1;

import java.util.Locale;
import java.util.Scanner;

public class Actividad_resuelta_14_pg37 {

    public static void main(String[] args) {
        double numero;
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US); //Sirve para usar punto para los decimales al escribir por teclado.
        System.out.println("Escribe un número con decimales: ");
        numero = teclado.nextDouble();
        int redondeo = (int) (numero+0.5);
        System.out.println("El número redondeado es: "+redondeo);
        double a =  123;
    }

}
