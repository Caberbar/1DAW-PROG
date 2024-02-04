package ejerciciosconcondicionales;

import funciones.LeerDatosTeclado;
import funciones.Operaciones;
import java.util.Scanner;

public class Ejercicio04EcuacionPrimerGrado {
    public static void main(String[] args) {
        double a, b, x;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido al programa de ecuación de Primer Grado");
        System.out.println("--------------------------------------------------------");
        a = LeerDatosTeclado.leerDoubleSinNeg("Introduce el valor de a: ",0);
        b = LeerDatosTeclado.leerDouble("Introduce el valor de b: ");
        
        
        x = Operaciones.ecuacionPrimerGrado(a, b);
        System.out.println("El valor de x es: "+x);       

    }
}
