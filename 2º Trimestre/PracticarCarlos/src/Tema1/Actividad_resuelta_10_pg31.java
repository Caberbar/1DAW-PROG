package Tema1;

import java.util.Scanner;

public class Actividad_resuelta_10_pg31 {


    public static void main(String[] args) {
        boolean llover,tarea,biblio;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido: ");
        System.out.println("¿Esta lloviendo?");
        llover = teclado.nextBoolean();
        System.out.println("¿Has acabado las tareas?");       
        tarea = teclado.nextBoolean();
        System.out.println("¿Necesitas ir a la biblioteca?");
        biblio = teclado.nextBoolean();
        if(llover!=true && tarea!=false && biblio!=true){
            System.out.println("Puedes salir a la calle");
        }else{
            System.out.println("No puedes salir a la calle");
        }
    }
    
}
