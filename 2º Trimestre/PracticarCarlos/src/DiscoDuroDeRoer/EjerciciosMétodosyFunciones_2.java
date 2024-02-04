package DiscoDuroDeRoer;

import java.util.Scanner;

//Crea una aplicación que nos genere una cantidad de números enteros aleatorios 
//que nosotros le pasaremos por teclado. Crea un método donde pasamos como 
//parámetros entre que números queremos que los genere, podemos pedirlas por 
//teclado antes de generar los números. Este método devolverá un número entero 
//aleatorio. Muestra estos números por pantalla.

public class EjerciciosMétodosyFunciones_2 {


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
