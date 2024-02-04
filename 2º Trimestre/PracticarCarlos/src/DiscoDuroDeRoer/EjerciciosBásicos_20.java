package DiscoDuroDeRoer;

// Pide un n�mero por teclado e indica si es un n�mero primo o no. Un n�mero primo es aquel solo puede dividirse entre 1 y si mismo. 
//Por ejemplo: 25 no es primo, ya que 25 es divisible entre 5, sin embargo, 17 si es primo.
//Un buen truco para calcular la ra�z cuadrada del numero e ir comprobando que si es divisible desde ese numero hasta 1.
//NOTA: Si se introduce un numero menor o igual que 1, directamente es no primo. 
import java.util.Scanner;

public class EjerciciosB�sicos_20 {

    public static void main(String[] args) {
        int contador = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un n�mero: ");
        int num = teclado.nextInt();

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                contador++;
            }
        }

        if (contador == 2) {
            System.out.println(num + " es primo.");
        } else {
            System.out.println(num + " no es primo.");
        }
    }

}
