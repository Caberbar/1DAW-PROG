package DiscoDuroDeRoer;

import java.util.Scanner;


public class EjerciciosB�sicos_15 {

//    Lee un n�mero por teclado y comprueba que este numero es mayor o igual que cero, si no lo es lo volver� a pedir (do while), despu�s muestra ese n�mero por consola. 
    
    public static void main(String[] args) {
        int num = 0;
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Introduce un n�mero mayor o igual a 0: ");
            num = teclado.nextInt();
        }while(num<0);
        
        System.out.println("El n�mero es: "+num);
    }
    
}
