package DiscoDuroDeRoer;

//Crea una aplicación que nos calcule el factorial de un número pedido por teclado,

import java.util.Scanner;

//lo realizara mediante un método al que le pasamos el número como parámetro. 
//Para calcular el factorial, se multiplica los números anteriores hasta llegar a 
//uno. Por ejemplo, si introducimos un 5, realizara esta operación 5*4*3*2*1=120.

public class EjerciciosMétodosyFunciones_4 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner (System.in);
        
        System.out.println("Introduce un número: ");
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
