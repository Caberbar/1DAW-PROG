package Tema1;

import java.util.Scanner;

public class Actividad_resuelta_12_pg34 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe un numero: ");
        int numero = teclado.nextInt();
//        int valor = numero < 0 ? -1 * numero : numero; //Operador ternario
        int valor = Math.abs(numero);
        System.out.println("El valor absoluto es: "+ valor);

    }

}
