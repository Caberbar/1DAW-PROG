package DiscoDuroDeRoer;

// Crear una aplicaci�n que nos permite insertar n�meros hasta que insertemos un -1. Calcular el numero de n�meros introducidos

import java.util.Scanner;


public class EjerciciosB�sicos_27 {


    public static void main(String[] args) {

        Scanner teclado = new Scanner (System.in);
        int contador=0, num;
        do{
            System.out.println("Introduzca un n�mero, si desea salir escriba -1.");
            num = teclado.nextInt();
            if(num>-1){
                contador++;
            }
        }while(num>-1);
        System.out.println("Has introducido un total de "+contador+" numero/s.");
    }
    
}
