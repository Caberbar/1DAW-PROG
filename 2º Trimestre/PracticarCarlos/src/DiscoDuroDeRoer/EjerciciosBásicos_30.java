package DiscoDuroDeRoer;

import java.util.Scanner;

public class EjerciciosBásicos_30 {

    public static void main(String[] args) {
        String opci = "";
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Eliga una opción");
        System.out.println("\t· Mayusculas");
        System.out.println("\t· Minusculas");
        System.out.print("Escoga: ");
        opci = teclado.nextLine();
        System.out.println("Introduzca una frase: ");
        String frase = teclado.nextLine();
        System.out.println("");
        switch (opci.toLowerCase()) {
            case "mayusculas":
                System.out.println(frase.toUpperCase());
                break;
            case "minusculas":
                System.out.println(frase.toLowerCase());
                break;
            default:
                throw new AssertionError();
        }

    }

}
