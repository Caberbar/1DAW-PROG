package ejerciciosconbucles;

import funciones.LeerDatosTeclado;
import funciones.Operaciones;
import java.util.Scanner;


public class Ejercicio26NumeroPrimo {
    public static void main(String[] args) {
        int numero;
        
            Scanner teclado = new Scanner(System.in);

            System.out.println("Bienvenido al programa para saber si un numero es primo o no");
            System.out.println("--------------------------------------------------------");
            numero = LeerDatosTeclado.leerIntSinNeg("Introduce un número: ",-1);
            
            boolean resultado = Operaciones.esPrimo(numero);
    }
}
