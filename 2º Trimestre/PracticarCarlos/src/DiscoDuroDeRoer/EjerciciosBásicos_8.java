package DiscoDuroDeRoer;

// Modifica el ejercicio anterior, para que en lugar de pedir un n�mero, pida un car�cter (char) y muestre su c�digo en la tabla ASCII.
import java.util.Scanner;

public class EjerciciosB�sicos_8 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un c�digo de la tabla ASCII: ");
        char codigo = teclado.next().charAt(0);
        int caracter = (int) codigo;
        System.out.println("El c�digo es: " + caracter);
    }

}
