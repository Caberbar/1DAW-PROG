package ejerciciossecuenciales;

import funciones.LeerDatosTeclado;
import java.util.Scanner;

public class Ejercicio07CalcularNota {
    
     public static void main(String[] args) {
        double examen1, trimestre, notafinal;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido al programa de calcular nota ");
        System.out.println("--------------------------------------------------------");
        examen1 = LeerDatosTeclado.leerDoubleSinNeg("Introduce la nota del primer examen: ",0);
        trimestre = LeerDatosTeclado.leerDoubleSinNeg("Introduce la nota que desea sacar en el trimestre: ",0);
        
        notafinal = (trimestre-(examen1*0.4))/0.6;
        
         System.out.println("La nota que debe sacar en el segundo examen para sacar un "+trimestre+" en el trimestre es: "+notafinal);
     }
}
