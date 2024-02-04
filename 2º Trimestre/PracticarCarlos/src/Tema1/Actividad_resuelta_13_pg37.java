package Tema1;

import java.util.Scanner;

public class Actividad_resuelta_13_pg37 {

    public static void main(String[] args) {
        int tri1, tri2, tri3;
        int cali;
        double exp;
        Scanner teclado = new Scanner (System.in);
        System.out.println("Escribe la nota del primer tirmestre: ");
        tri1 = teclado.nextInt();
        System.out.println("Escribe la nota del segundo tirmestre: ");
        tri2 = teclado.nextInt();
        System.out.println("Escribe la nota del tercer tirmestre: ");
        tri3 = teclado.nextInt();
        exp = (tri1 + tri2 +tri3) / 3;
        cali = (int) exp;
        System.out.println("La nota de calificaciones es: "+cali); 
        System.out.println("La nota del expediente es: "+exp);
    }

}
