package DiscoDuroDeRoer;

import java.util.Scanner;

//Crea un aplicaci�n que nos convierta una cantidad de euros introducida por 
//teclado a otra moneda, estas pueden ser a dolares, yenes o libras. El m�todo 
//tendr� como par�metros, la cantidad de euros y la moneda a pasar que sera una 
//cadena, este no devolver� ning�n valor, mostrara un mensaje indicando el cambio 
//(void).
public class EjerciciosM�todosyFunciones_7 {

    public static void main(String[] args) {
        int num;
        String opcion;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("Introduce un n�mero entero positivo: ");
            num = teclado.nextInt();
        } while (num < 1);
        System.out.println("\n");
        System.out.println("� Libras");
        System.out.println("� Dolares");
        System.out.println("� Yenes");
        System.out.println();
        do {
            System.out.println("A que moneada desea convertir los euros:");
            opcion = teclado.next();
            opcion = opcion.toLowerCase();
        } while (!opcion.equals("libras") & !opcion.equals("dolares") & !opcion.equals("yenes"));

        cambioDivisa(num, opcion);
    }

    private static void cambioDivisa(int num, String opcion) {

        switch (opcion) {
            case "libras":
                System.out.println(num + "euros a libras es: " + num * 0.89);
                break;
            case "dolares":
                System.out.println(num + "euros a dolares es: " + num * 1.0621);
                break;
            case "yenes":
                System.out.println(num + "euros a yenes es: " + num * 145.25);
                break;
            default:
                throw new AssertionError();
        }

    }

}
