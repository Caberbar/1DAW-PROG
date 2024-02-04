package DiscoDuroDeRoer;

// Crea una aplicación que nos pida un día de la semana y que nos diga si es un dia laboral o no. Usa un switch para ello.
import java.util.Scanner;

public class EjerciciosBásicos_17 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un día de la semana: ");
        String dia = teclado.nextLine();

        switch (dia.toLowerCase()) {
            case "lunes":
                System.out.println("Día laboral");
                break;
            case "martes":
                System.out.println("Día laboral");
                break;
            case "miercoles":
                System.out.println("Día laboral");
                break;
            case "jueves":
                System.out.println("Día laboral");
                break;
            case "viernes":
                System.out.println("Día laboral");
                break;
            case "sabado":
                System.out.println("Día no laboral");
                break;
            case "domingo":
                System.out.println("Día no laboral");
                break;
            default:
                System.out.println("Día invalido, introducelo otra vez.");;
        }
    }

}
