package DiscoDuroDeRoer;

//Crea una aplicaci�n que nos calcule el factorial de un n�mero pedido por teclado,

import java.util.Scanner;

//lo realizara mediante un m�todo al que le pasamos el n�mero como par�metro. 
//Para calcular el factorial, se multiplica los n�meros anteriores hasta llegar a 
//uno. Por ejemplo, si introducimos un 5, realizara esta operaci�n 5*4*3*2*1=120.

public class EjerciciosM�todosyFunciones_4 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner (System.in);
        
        System.out.println("Introduce un n�mero: ");
        int n = teclado.nextInt();
        
        System.out.println(calcularFactorial(n));
        
    }

    public static int calcularFactorial(int n) {

        int resultado = n;
        for (int i = n-1; i > 0; i--) {
            resultado = resultado * i;
        }
        return resultado;
    }
    
}
