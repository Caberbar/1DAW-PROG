package ejerciciosconcondicionales;

import java.util.Scanner;

public class Ejercicio02Asignatura {
    public static void main(String[] args) {
        String dia;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido al programa de asignatura");
        System.out.println("--------------------------------------------------------");
        System.out.println("Introduce un d�a de la semana: ");
        dia = teclado.nextLine();
        String dia_minus = dia.toLowerCase();
        
        switch (dia_minus){
            case "lunes":
                System.out.println("FOL");
                break;
            case "martes":
                System.out.println("Programaci�n");
                break;
            case "miercoles":
                System.out.println("FOL");
                break;
            case "jueves":
                System.out.println("Base de Datos");
                break;
            case "viernes":
                System.out.println("Base de Datos");
                break;
            case "s�bado":
                System.out.println("Fin de semana");
                break;
            case "domingo":
                System.out.println("Fin de semana");
                break;
            default:
                System.out.println("Dia inv�lido");
                break;
        }
    }
}
