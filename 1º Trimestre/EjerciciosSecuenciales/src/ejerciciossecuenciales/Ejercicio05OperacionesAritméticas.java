package ejerciciossecuenciales;

import funciones.LeerDatosTeclado;
import java.util.Scanner;

public class Ejercicio05OperacionesAritm�ticas {
    
    public static void main(String[] args) {
        int numero1, numero2, suma, resta, multiplicaci�n, divisi�n;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido al programa de operaciones aritm�ticas");
        System.out.println("--------------------------------------------------------");
        numero1 = LeerDatosTeclado.leerInt("Introduce el primer n�mero: ");
        numero2 = LeerDatosTeclado.leerInt ("Introduce el segundo numero: ");
        
        suma = numero1+numero2;
        resta = numero1-numero2;
        multiplicaci�n = numero1*numero2;
        divisi�n = numero1/numero2;
        
        System.out.println("La suma de los numero es ="+suma+" la resta de los numeros es ="+resta+
                " la multiplicaci�n de los numeros es ="+multiplicaci�n+" y la divisi�n de los n�meros es ="+divisi�n);       
    }
    
}
