package ejerciciossecuenciales;

import funciones.LeerDatosTeclado;
import java.util.Scanner;

public class Ejercicio05OperacionesAritméticas {
    
    public static void main(String[] args) {
        int numero1, numero2, suma, resta, multiplicación, división;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido al programa de operaciones aritméticas");
        System.out.println("--------------------------------------------------------");
        numero1 = LeerDatosTeclado.leerInt("Introduce el primer número: ");
        numero2 = LeerDatosTeclado.leerInt ("Introduce el segundo numero: ");
        
        suma = numero1+numero2;
        resta = numero1-numero2;
        multiplicación = numero1*numero2;
        división = numero1/numero2;
        
        System.out.println("La suma de los numero es ="+suma+" la resta de los numeros es ="+resta+
                " la multiplicación de los numeros es ="+multiplicación+" y la división de los números es ="+división);       
    }
    
}
