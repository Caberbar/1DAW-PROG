package proyectoarrays;

import funciones.LeerDatosTeclado;
import funciones.Funciones;
import java.util.Scanner;

public class EjercicioDePrueba {

    public static void main(String[] args) {
        int suma, cantidad, mayor;

        Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido al programa de prueba arrays");
        System.out.println("--------------------------------------------------------");
        cantidad = LeerDatosTeclado.leerIntSinNeg("Introduce la cantidad: ", -1);
        
        int[] numeros = {0};
        numeros = new int[cantidad];
        for (cantidad = 0; cantidad < numeros.length; cantidad++) {
            numeros[cantidad] = LeerDatosTeclado.leerInt("Introduce un numero: ");
        }
        suma = Funciones.sumarArray(numeros);
        System.out.println(suma);
        
        mayor = Funciones.numeroMaximo(numeros);
        System.out.println(mayor);
    }
}
