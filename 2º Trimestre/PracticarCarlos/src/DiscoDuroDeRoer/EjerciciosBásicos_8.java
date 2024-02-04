package DiscoDuroDeRoer;

// Modifica el ejercicio anterior, para que en lugar de pedir un número, pida un carácter (char) y muestre su código en la tabla ASCII.
import java.util.Scanner;

public class EjerciciosBásicos_8 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un código de la tabla ASCII: ");
        char codigo = teclado.next().charAt(0);
        int caracter = (int) codigo;
        System.out.println("El código es: " + caracter);
    }

}
