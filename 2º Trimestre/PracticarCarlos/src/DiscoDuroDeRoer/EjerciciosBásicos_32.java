package DiscoDuroDeRoer;

//Pedir dos palabras por teclado, indicar si son iguales.
import java.util.Scanner;

public class EjerciciosBásicos_32 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la primera palabra: ");
        String p1 = teclado.nextLine();
        System.out.println("Introduce la segunda palabra: ");
        String p2 = teclado.nextLine();

        if(p1.equals(p2)){
            System.out.println("Son dos palabras iguales.");
        }else{
            System.out.println("No son dos palabras iguales.");
        }
    }

}
