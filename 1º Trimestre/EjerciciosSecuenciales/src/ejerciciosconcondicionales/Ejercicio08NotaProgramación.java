package ejerciciosconcondicionales;

import funciones.LeerDatosTeclado;
import java.util.Scanner;

public class Ejercicio08NotaProgramación {
    public static void main(String[] args) {
        double nota1, nota2, media;
        String recuperacion;
        
            Scanner teclado = new Scanner(System.in);

            System.out.println("Bienvenido al programa para saber la nota de programación");
            System.out.println("--------------------------------------------------------");
            nota1 = LeerDatosTeclado.leerDoubleSinNeg("Introduce la primera nota: ",0);
            nota2 = LeerDatosTeclado.leerDoubleSinNeg("Introduce la segunda nota: ",0);
            
            media = (nota1*nota2)/2;
                    
            if (media >= 5){
                System.out.println("Esta aprobado, esta es tu media: "+media);
            } else {
                System.out.println("Introduce el resultado de la recuperación: ");
                recuperacion = teclado.next();
                String recuperacion_lower = recuperacion.toLowerCase();
                if (recuperacion_lower.equals("apto")){
                    System.out.println("Tu media es un 5");
                }else{
                    System.out.println("Tu media es: "+media);
                }
            }
    }
}
