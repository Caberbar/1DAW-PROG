package ejerciciosconbucles;

import funciones.LeerDatosTeclado;
import funciones.Operaciones;
import java.util.Scanner;

public class Ejercicio19NumeroDeCifras {
       public static void main(String[] args) {
        int numero;
        
            Scanner teclado = new Scanner(System.in);

            System.out.println("Bienvenido al programa para saber cuantas cifras tiene un numero enrte 0 y 9.999");
            System.out.println("--------------------------------------------------------");
            numero = LeerDatosTeclado.leerIntSinNegConMax("Introduce un numero: ",-1,10000);
            
            System.out.println("Tiene "+Operaciones.numeroCifras(numero)+" cifra/s");
            
    } 
}
