package DiscoDuroDeRoer;
// EjerciciosMétodosyFunciones_1

import java.util.Scanner;

//Crea una aplicación que nos calcule el área de un circulo, cuadrado o triangulo.
//Pediremos que figura queremos calcular su área y según lo introducido pedirá los
//valores necesarios para calcular el área. Crea un método por cada figura para 
//calcular cada área, este devolverá un número real. Muestra el resultado por pantalla
public class EjerciciosMétodosyFunciones_1 {

    public static void main(String[] args) {
        String opcion = "";
        Scanner teclado = new Scanner(System.in);

        System.out.println("· Círculo");
        System.out.println("· Triangulo");
        System.out.println("· Cuadrado");
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
                System.out.println("El área del circulo con radio " + radio + " es: " + areaCirculo(radio));
                break;
            case "triangulo":
                System.out.print("Introduce la base del triangulo: ");
                double base = teclado.nextDouble();
                System.out.print("Introduce la altura del triangulo: ");
                double altura = teclado.nextDouble();
                System.out.println("El área del triangulo con base " + base + " y altura " + altura + " es: " + areaTriangulo(base, altura));
                break;
            case "cuadrado":
                System.out.print("Introduce el lado del cuadrado: ");
                double lado = teclado.nextDouble();
                System.out.println("El área del cuadrado con lado " + lado + " es: " + areaCuadrado(lado));
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
