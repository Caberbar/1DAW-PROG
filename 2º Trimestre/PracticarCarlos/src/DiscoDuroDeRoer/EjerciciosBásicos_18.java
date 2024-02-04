package DiscoDuroDeRoer;

// Pide por teclado dos número y genera 10 números aleatorios entre esos números. Usa el método Math.random para generar un número entero aleatorio (recuerda el casting de double a int).
import java.util.Scanner;

public class EjerciciosBásicos_18 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el primer número: ");
        int n1 = teclado.nextInt();
        System.out.println("Introduce el segundo número: ");
        int n2 = teclado.nextInt();

        for (int i = 1; i < 10; i++) {
            int n = (int) Math.floor(Math.random()*(n1-n2)+n2);
            System.out.println(n);
        }
        
    }

}
