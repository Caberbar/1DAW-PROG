package ejerciciossecuenciales;

import funciones.LeerDatosTeclado;
import java.util.Scanner;

/**
 *
 * @author DAW-B
 */
public class Ejercicio02MediaAritmética {
    
        public static void main(String[] args) {
        double a, b, media;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido al programa de cálculo de média aritmética");
        System.out.println("--------------------------------------------------------");
        
        a = LeerDatosTeclado.leerDouble("Introduce un número: ");
        b = LeerDatosTeclado.leerDouble("Introduce otro número: ");
        media = (a+b)/2;
        System.out.println("La media de "+a+" y "+b+" es: "+media);
        
        
    }
}
