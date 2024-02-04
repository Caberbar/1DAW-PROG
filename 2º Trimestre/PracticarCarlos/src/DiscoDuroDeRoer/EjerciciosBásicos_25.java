package DiscoDuroDeRoer;

//Crea una aplicación llamada CalculadoraPolacaInversaApp, nos pedirá 2 operandos (int) y un signo aritmético (String), según este último se 
import java.util.Scanner;

//realizara la operación correspondiente. Al final mostrara el resultado en un cuadro de dialogo. Los signos aritméticos disponibles son:
public class EjerciciosBásicos_25 {

    public static void main(String[] args) {

        double resul = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el primer número:");
        int n1 = teclado.nextInt();
        System.out.println("Introduce el segundo número:");
        int n2 = teclado.nextInt();
        System.out.println("Introduce el signo aritmético:");
        String ope = teclado.next();

        switch (ope) {
            case "+":
                resul = n1 + n2;
                break;
            case "-":
                resul = n1 - n2;
                break;
            case "*":
                resul = n1 * n2;                
                break;
            case "/":
                resul = n1 / n2;
                break;
            case "^":
                resul = (int) Math.pow(n1, n2);
                break;
            case "%":
                resul = n1 % n2;
                break;

            default:
                throw new AssertionError();
        }
        
        System.out.println(n1+" "+ope+" "+n2+" = "+resul);
    }

}
