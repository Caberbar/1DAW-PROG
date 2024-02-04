package ejerciciosconcondicionales;

import funciones.LeerDatosTeclado;
import funciones.Operaciones;
import java.util.Scanner;


public class Ejercicio11Potencia {
    public static void main(String[] args) {
        double x, resultado;
        int n;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido al programa de calcular una potencia");
        System.out.println("--------------------------------------------------------");
        x = LeerDatosTeclado.leerDouble("Introduce el valor de X: ");
        n = LeerDatosTeclado.leerIntSinNeg("Introduce el valor del exponente: ",-1);
        
        resultado = Operaciones.potencia(x, n);
    }
}
