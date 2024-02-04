package Tema1;

import java.util.Scanner;

public class Actividad_resuelta_7_pg28 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el radio: ");
        double radio = teclado.nextDouble();
        double longitud = 2*Math.PI * radio;
        double area = Math.PI * (radio*radio);
        System.out.println("La longitud es: "+longitud);
        System.out.println("El área es "+area);
    }
    
}
