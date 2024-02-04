package DiscoDuroDeRoer;

import java.util.Scanner;


public class EjerciciosBásicos_15 {

//    Lee un número por teclado y comprueba que este numero es mayor o igual que cero, si no lo es lo volverá a pedir (do while), después muestra ese número por consola. 
    
    public static void main(String[] args) {
        int num = 0;
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Introduce un número mayor o igual a 0: ");
            num = teclado.nextInt();
        }while(num<0);
        
        System.out.println("El número es: "+num);
    }
    
}
