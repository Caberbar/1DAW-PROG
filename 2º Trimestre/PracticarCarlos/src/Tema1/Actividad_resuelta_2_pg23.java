package Tema1;

import java.util.Locale;
import java.util.Scanner;

public class Actividad_resuelta_2_pg23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un n�mero.");
        double numero;
        numero = sc.nextDouble();
        sc.useLocale(Locale.US);
        System.out.println("El n�mero double introducido es: "+numero);
    }
    
}
