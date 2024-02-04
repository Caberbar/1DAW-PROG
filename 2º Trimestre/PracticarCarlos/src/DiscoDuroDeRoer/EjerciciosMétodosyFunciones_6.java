package DiscoDuroDeRoer;

import java.util.Scanner;


//Crea una aplicaci�n que nos cuente el n�mero de cifras de un n�mero entero 
//positivo (hay que controlarlo) pedido por teclado. Crea un m�todo que realice 
//esta acci�n, pasando el n�mero por par�metro, devolver� el n�mero de cifras.

public class EjerciciosM�todosyFunciones_6 {

    public static void main(String[] args) {
        int num;
        Scanner teclado = new Scanner (System.in);
        
        do{
        System.out.println("Introduce un n�mero entero positivo: ");
        num = teclado.nextInt();
        }while(num<1);
        
        System.out.println("El n�mero "+num+" tiene "+calcularCifras(num)+" cifra/s.");
    }

    public static int calcularCifras(int num) {
        int cont = 0;
        for (int i = num; i > 0; i/=10) {
            cont++;
        }
        
        return cont;

    }
    
}
