package DiscoDuroDeRoer;

import java.util.Scanner;

//Crea una aplicaci�n que nos pida un n�mero por teclado y con un m�todo se lo 
//pasamos por par�metro para que nos indique si es o no un n�mero primo, debe 
//devolver true si es primo sino false.
//Un n�mero primo es aquel solo puede dividirse entre 1 y si mismo. Por ejemplo: 
//25 no es primo, ya que 25 es divisible entre 5, sin embargo, 17 si es primo.
//Un buen truco para calcular la ra�z cuadrada del numero e ir comprobando que si 
//es divisible desde ese numero hasta 1.

public class EjerciciosM�todosyFunciones_3 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner (System.in);
        
        System.out.println("Introduce un n�mero: ");
        int n = teclado.nextInt();
        
        if(comprobarNumero(n)!=true){
            System.out.println(n+" es un n�mero primo.");
        }else{
            System.out.println(n+" no es un n�mero primo.");
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
