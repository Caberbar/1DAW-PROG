package DiscoDuroDeRoer;
// EjerciciosM�todosyFunciones_1

import java.util.Scanner;

//Crea una aplicaci�n que nos calcule el �rea de un circulo, cuadrado o triangulo.
//Pediremos que figura queremos calcular su �rea y seg�n lo introducido pedir� los
//valores necesarios para calcular el �rea. Crea un m�todo por cada figura para 
//calcular cada �rea, este devolver� un n�mero real. Muestra el resultado por pantalla
public class EjerciciosM�todosyFunciones_1 {

    public static void main(String[] args) {
        String opcion = "";
        Scanner teclado = new Scanner(System.in);

        System.out.println("� C�rculo");
        System.out.println("� Triangulo");
        System.out.println("� Cuadrado");
        System.out.println();

        do {
            System.out.println("De que figura desea calcular el area:");
            opcion = teclado.next();
            opcion = opcion.toLowerCase();
        } while (!opcion.equals("circulo") & !opcion.equals("triangulo") & !opcion.equals("cuadrado"));

        switch (opcion) {
            case "circulo":
                System.out.print("Introduce el radio del circulo: ");
                double radio = teclado.nextDouble();
                System.out.println("El �rea del circulo con radio " + radio + " es: " + areaCirculo(radio));
                break;
            case "triangulo":
                System.out.print("Introduce la base del triangulo: ");
                double base = teclado.nextDouble();
                System.out.print("Introduce la altura del triangulo: ");
                double altura = teclado.nextDouble();
                System.out.println("El �rea del triangulo con base " + base + " y altura " + altura + " es: " + areaTriangulo(base, altura));
                break;
            case "cuadrado":
                System.out.print("Introduce el lado del cuadrado: ");
                double lado = teclado.nextDouble();
                System.out.println("El �rea del cuadrado con lado " + lado + " es: " + areaCuadrado(lado));
                break;
            default:
                throw new AssertionError();
        }

    }

    public static double areaCirculo(double radio) {
        return (Math.pow(radio, 2)) * Math.PI;
    }

    public static double areaTriangulo(double base, double altura) {
        return (base * altura) / 2;
    }

    public static double areaCuadrado(double lado) {
        return lado*lado;
    }

}
