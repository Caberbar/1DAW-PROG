package DiscoDuroDeRoer;

//Haz una aplicaci�n que calcule el �rea de un c�rculo(pi*R2). El radio se pedir� por teclado (recuerda pasar de String a double con Double.parseDouble). Usa la constante PI y el m�todo pow de Math.

import java.util.Scanner;


public class EjerciciosB�sicos_5 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner (System.in);
        System.out.println("Introduce el radio del circulo: ");
        String radio = teclado.next();
        double rd = Double.parseDouble(radio);
        double area = (Math.PI*Math.pow(rd, 2));
        System.out.println("El area del circulo es: "+area);
    }
    
}
