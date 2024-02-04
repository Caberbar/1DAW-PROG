package DiscoDuroDeRoer;

// Pide por teclado dos n�mero y genera 10 n�meros aleatorios entre esos n�meros. Usa el m�todo Math.random para generar un n�mero entero aleatorio (recuerda el casting de double a int).
import java.util.Scanner;

public class EjerciciosB�sicos_18 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el primer n�mero: ");
        int n1 = teclado.nextInt();
        System.out.println("Introduce el segundo n�mero: ");
        int n2 = teclado.nextInt();

        for (int i = 1; i < 10; i++) {
            int n = (int) Math.floor(Math.random()*(n1-n2)+n2);
            System.out.println(n);
        }
        
    }

}
