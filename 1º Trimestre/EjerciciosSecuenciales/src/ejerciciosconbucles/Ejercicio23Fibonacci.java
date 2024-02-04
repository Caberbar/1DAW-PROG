package ejerciciosconbucles;

import funciones.LeerDatosTeclado;
import java.util.Scanner;

public class Ejercicio23Fibonacci {
    public static void main(String[] args) {
        int numero, primero = 0, segundo = 1, contador = 2, suma = 0;

        Scanner teclado = new Scanner(System.in);
       
        do {
            numero = LeerDatosTeclado.leerIntSinNeg("Introduce un numero: ",-1);
        }while(numero<0);
        if (numero == 0){
            System.out.println(primero);
        }else if (numero == 1){
            System.out.println(primero);
            System.out.println(segundo);
        }else{
            System.out.println(primero);
            System.out.println(segundo);
            if (contador <= numero){
                contador++;
                suma = primero + segundo;
                primero = segundo;
                segundo = suma;
                System.out.println(suma);
            }
        }    
    }
}

