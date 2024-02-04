package ejerciciossecuenciales;

import java.util.Scanner;
import funciones.LeerDatosTeclado;

public class Ejercicio01CambioSigno {
    
    public static void main(String[] args) {
        short numero;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido al programa de cambio de signo");
        System.out.println("--------------------------------------------------------");
        
        numero = LeerDatosTeclado.leerShort("Introduce un número");
        
        numero *= -1;
        System.out.println("El numero cambiado de signo es: "+numero);
        
        
    }
    
}