package DiscoDuroDeRoer;

//Modifica la aplicación anterior, para que nos pida el nombre que queremos introducir (recuerda usar JOptionPane).

import java.util.Scanner;


public class EjerciciosBásicos_4 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);
        System.out.println("Introduce tu nombre;");
        String nombre = teclado.nextLine();
        System.out.println("Bienvenido "+nombre);     
    }
    
}
