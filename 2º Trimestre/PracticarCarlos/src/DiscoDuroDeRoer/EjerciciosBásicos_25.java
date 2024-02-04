package DiscoDuroDeRoer;

//Crea una aplicaci�n llamada CalculadoraPolacaInversaApp, nos pedir� 2 operandos (int) y un signo aritm�tico (String), seg�n este �ltimo se 
import java.util.Scanner;

//realizara la operaci�n correspondiente. Al final mostrara el resultado en un cuadro de dialogo. Los signos aritm�ticos disponibles son:
public class EjerciciosB�sicos_25 {

    public static void main(String[] args) {

        double resul = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el primer n�mero:");
        int n1 = teclado.nextInt();
        System.out.println("Introduce el segundo n�mero:");
        int n2 = teclado.nextInt();
        System.out.println("Introduce el signo aritm�tico:");
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
