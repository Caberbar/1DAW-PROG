package ejerciciosconbucles;

import funciones.LeerDatosTeclado;
import java.util.Scanner;

public class Ejercicio20TabladeMultiplicar {
    
    public static void main(String[] args) {
        int numero, contador, tabla;
        
        contador = 0;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido al programa de calcular la tabla de multiplicar");
        System.out.println("--------------------------------------------------------");

        tabla = LeerDatosTeclado.leerIntSinNeg("Introduzca la tabla que desea multiplicar: ",0);
        
        while (contador <= 10){
            numero = tabla * contador;
            contador++;
            System.out.println(numero);
        }
    }
        
    }
