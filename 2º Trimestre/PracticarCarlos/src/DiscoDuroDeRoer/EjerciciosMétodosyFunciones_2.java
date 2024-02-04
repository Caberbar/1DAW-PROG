package DiscoDuroDeRoer;

import java.util.Scanner;

//Crea una aplicaci�n que nos genere una cantidad de n�meros enteros aleatorios 
//que nosotros le pasaremos por teclado. Crea un m�todo donde pasamos como 
//par�metros entre que n�meros queremos que los genere, podemos pedirlas por 
//teclado antes de generar los n�meros. Este m�todo devolver� un n�mero entero 
//aleatorio. Muestra estos n�meros por pantalla.

public class EjerciciosM�todosyFunciones_2 {


    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introduce el limite de numeros que quieres generar: ");
        int limite = teclado.nextInt();
        System.out.print("Introduce el primer numero: ");
        int n1 = teclado.nextInt();
        System.out.print("Introduce el primer numero: ");
        int n2 = teclado.nextInt();
        
        for (int i = 0; i < limite; i++) {
            System.out.print(numeroAleatorio(n1,n2)+" ");
        }
        System.out.println();
    }
    
    public static int numeroAleatorio(int n1, int n2){
        return (int) (Math.random() * (n2-n1) + n1);
    }
}
