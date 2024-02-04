package ejerciciosconbucles;

import funciones.LeerDatosTeclado;
import java.util.Scanner;

public class Ejercicio22MediaNumeros {
    public static void main(String[] args) {
        double numero = 0, media, suma, contador = 1;

        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Si desea salir escribe un número negativo.");
        numero = LeerDatosTeclado.leerDouble("Introduce un numero");
        suma = numero;
        
        while ( numero >=0 ){

           numero = LeerDatosTeclado.leerDouble("Introduce un numero");
           if (numero < 0){break;}
           contador++;
           suma = numero+suma;
        }
        
        media = suma/contador;
        System.out.println("Tu media es: "+media);
    }   
}
