package DiscoDuroDeRoer;

import java.util.Scanner;

//Crea una aplicación que nos pida un número por teclado y con un método se lo 
//pasamos por parámetro para que nos indique si es o no un número primo, debe 
//devolver true si es primo sino false.
//Un número primo es aquel solo puede dividirse entre 1 y si mismo. Por ejemplo: 
//25 no es primo, ya que 25 es divisible entre 5, sin embargo, 17 si es primo.
//Un buen truco para calcular la raíz cuadrada del numero e ir comprobando que si 
//es divisible desde ese numero hasta 1.

public class EjerciciosMétodosyFunciones_3 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner (System.in);
        
        System.out.println("Introduce un número: ");
        int n = teclado.nextInt();
        
        if(comprobarNumero(n)!=true){
            System.out.println(n+" es un número primo.");
        }else{
            System.out.println(n+" no es un número primo.");
        }
    }
    
    public static boolean comprobarNumero (int n){
        int cont = 0;
        boolean esValido = false;
        for (int i = 1; i < n; i++) {
            if(n%i==0){
                cont++;
            }
            
            if(cont == 2){
                esValido = true;
            }
        }
        return esValido;
        
    }
}
