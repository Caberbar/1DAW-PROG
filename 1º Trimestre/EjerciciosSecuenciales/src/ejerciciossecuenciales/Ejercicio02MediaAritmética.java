package ejerciciossecuenciales;

import funciones.LeerDatosTeclado;
import java.util.Scanner;

/**
 *
 * @author DAW-B
 */
public class Ejercicio02MediaAritm�tica {
    
        public static void main(String[] args) {
        double a, b, media;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido al programa de c�lculo de m�dia aritm�tica");
        System.out.println("--------------------------------------------------------");
        
        a = LeerDatosTeclado.leerDouble("Introduce un n�mero: ");
        b = LeerDatosTeclado.leerDouble("Introduce otro n�mero: ");
        media = (a+b)/2;
        System.out.println("La media de "+a+" y "+b+" es: "+media);
        
        
    }
}
