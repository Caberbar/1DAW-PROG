package DiscoDuroDeRoer;

// Realiza una aplicaci�n que nos calcule una ecuaci�n de segundo grado. Debes pedir las variables a, b y c por teclado y comprobar antes que el discriminante (operaci�n en la ra�z cuadrada). Para la ra�z cuadrada usa el m�todo sqlrt de Math. Te recomiendo que uses mensajes de traza.
import java.util.Scanner;

public class EjerciciosB�sicos_14 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Operacio�n de 2� grado: ");
        System.out.println("Introduce el valor de a: ");
        int a = teclado.nextInt();
        System.out.println("Introduce el valor de b: ");
        int b = teclado.nextInt();
        System.out.println("Introduce el valor de n: ");
        int c = teclado.nextInt();

        double raiz = (Math.pow(b, 2) - 4 * a * c);

        if (raiz < 0) {
            System.out.println("No se puede realizar la ecuaci�n");
        } else {
            double n1 = ((b * (-1)) + Math.sqrt(raiz)) / 2 * a;
            double n2 = ((b * (-1)) - Math.sqrt(raiz)) / 2 * a;
            System.out.println("Los valores de la ecuaci�n son: "+n1+" | "+n2);
        }
        
    }

}
