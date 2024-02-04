package DiscoDuroDeRoer;

//Haz una aplicación que calcule el área de un círculo(pi*R2). El radio se pedirá por teclado (recuerda pasar de String a double con Double.parseDouble). Usa la constante PI y el método pow de Math.

import java.util.Scanner;


public class EjerciciosBásicos_5 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner (System.in);
        System.out.println("Introduce el radio del circulo: ");
        String radio = teclado.next();
        double rd = Double.parseDouble(radio);
        double area = (Math.PI*Math.pow(rd, 2));
        System.out.println("El area del circulo es: "+area);
    }
    
}
