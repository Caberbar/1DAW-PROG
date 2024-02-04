package DiscoDuroDeRoer;

// Realiza una aplicación que nos calcule una ecuación de segundo grado. Debes pedir las variables a, b y c por teclado y comprobar antes que el discriminante (operación en la raíz cuadrada). Para la raíz cuadrada usa el método sqlrt de Math. Te recomiendo que uses mensajes de traza.
import java.util.Scanner;

public class EjerciciosBásicos_14 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Operacioón de 2º grado: ");
        System.out.println("Introduce el valor de a: ");
        int a = teclado.nextInt();
        System.out.println("Introduce el valor de b: ");
        int b = teclado.nextInt();
        System.out.println("Introduce el valor de n: ");
        int c = teclado.nextInt();

        double raiz = (Math.pow(b, 2) - 4 * a * c);

        if (raiz < 0) {
            System.out.println("No se puede realizar la ecuación");
        } else {
            double n1 = ((b * (-1)) + Math.sqrt(raiz)) / 2 * a;
            double n2 = ((b * (-1)) - Math.sqrt(raiz)) / 2 * a;
            System.out.println("Los valores de la ecuación son: "+n1+" | "+n2);
        }
        
    }

}
