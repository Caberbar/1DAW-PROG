package Tema1;

import java.util.Scanner;

public class Actividad_resuelta_8_pg29 {

    public static void main(String[] args) {
        boolean mayoria;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce tu edad: ");
        int edad = teclado.nextInt();
        if(edad<18){
           mayoria = false; 
        }else{
            mayoria = true;
        }
        System.out.println(mayoria);
    }

}
