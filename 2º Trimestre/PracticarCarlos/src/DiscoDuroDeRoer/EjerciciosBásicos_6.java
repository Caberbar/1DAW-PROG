package DiscoDuroDeRoer;

//Lee un n�mero por teclado e indica si es divisible entre 2 (resto = 0). Si no lo es, tambi�n debemos indicarlo.

import java.util.Scanner;


public class EjerciciosB�sicos_6 {

    
    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);
        System.out.println("Introduce un numero: ");
        int numero = teclado.nextInt();
        if(numero%2==0){
            System.out.println(numero+" es divisible entre 2:");
        }else{
            System.out.println(numero+" no es divisible entre 2:");
        }
    }
    
}
