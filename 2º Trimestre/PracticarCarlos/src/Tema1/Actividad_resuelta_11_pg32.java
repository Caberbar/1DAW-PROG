package Tema1;

import java.util.Scanner;

public class Actividad_resuelta_11_pg32 {

    public static void main(String[] args) {
        double priSemestre;
        double segSemestre;
        int manzanas;
        int peras;
        double total;
        Scanner teclado = new Scanner (System.in);
        System.out.println("Cuantas manzanas has vendido en el primer semestre: ");
        manzanas = teclado.nextInt();
        priSemestre = 2.35 * manzanas;
        System.out.println("Cuantas manzanas has vendido en el primer semestre: ");
        peras = teclado.nextInt();
        priSemestre += 1.95 * peras;
        System.out.println("Cuantas manzanas has vendido en el segundo semestre: ");
        manzanas = teclado.nextInt();
        segSemestre = 2.35 * manzanas;
        System.out.println("Cuantas manzanas has vendido en el segundo semestre: ");
        peras = teclado.nextInt();
        segSemestre += 1.95 * peras;
        total = priSemestre + segSemestre;
        System.out.println("El importe total es de: "+total+" euros.");
    }

}
