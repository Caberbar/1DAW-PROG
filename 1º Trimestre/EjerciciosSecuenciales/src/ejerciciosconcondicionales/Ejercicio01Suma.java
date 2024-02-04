package ejerciciosconcondicionales;

import funciones.LeerDatosTeclado;
import java.util.Scanner;

public class Ejercicio01Suma {
  
    public static void main(String[] args) {
        double n1, n2, suma;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido al programa de suma de números");
        System.out.println("--------------------------------------------------------");
        n1 = LeerDatosTeclado.leerDouble("Introduce el primer numero: ");
        n2 = LeerDatosTeclado.leerDouble("Introduce el segundo numero: ");
        
        suma = n1+n2;
         
       if (suma>0) {
           System.out.println("La suma es mayuor que 0");
       } else {
           System.out.println("La suma es menor que 0");
       }
    }
}
