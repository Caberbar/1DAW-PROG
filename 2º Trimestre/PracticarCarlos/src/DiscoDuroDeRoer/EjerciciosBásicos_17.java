package DiscoDuroDeRoer;

// Crea una aplicaci�n que nos pida un d�a de la semana y que nos diga si es un dia laboral o no. Usa un switch para ello.
import java.util.Scanner;

public class EjerciciosB�sicos_17 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un d�a de la semana: ");
        String dia = teclado.nextLine();

        switch (dia.toLowerCase()) {
            case "lunes":
                System.out.println("D�a laboral");
                break;
            case "martes":
                System.out.println("D�a laboral");
                break;
            case "miercoles":
                System.out.println("D�a laboral");
                break;
            case "jueves":
                System.out.println("D�a laboral");
                break;
            case "viernes":
                System.out.println("D�a laboral");
                break;
            case "sabado":
                System.out.println("D�a no laboral");
                break;
            case "domingo":
                System.out.println("D�a no laboral");
                break;
            default:
                System.out.println("D�a invalido, introducelo otra vez.");;
        }
    }

}
