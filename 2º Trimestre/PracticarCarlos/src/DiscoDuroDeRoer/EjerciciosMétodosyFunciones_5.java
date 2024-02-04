package DiscoDuroDeRoer;

import java.util.Scanner;

//Crea una aplicaci�n que nos convierta un n�mero en base decimal a binario. Esto
//lo realizara un m�todo al que le pasaremos el numero como par�metro, devolver� 
//un String con el numero convertido a binario. Para convertir un numero decimal a
//binario, debemos dividir entre 2 el numero y el resultado de esa divisi�n se 
//divide entre 2 de nuevo hasta que no se pueda dividir mas, el resto que 
//obtengamos de cada divisi�n formara el numero binario, de abajo a arriba.

public class EjerciciosM�todosyFunciones_5 {

    public static void main(String[] args) {

        Scanner teclado=  new Scanner (System.in);

        System.out.println("Introduce el n�mero que desea pasar a binario.");
        int num = teclado.nextInt();
        
        System.out.println("El n�mero "+num+" pasado a binario es: "+generarBinario(num));
    }

    private static String generarBinario(int num) {
        String binario = "";
        String digito;
            
        for (int i = num; i > 0; i/=2) {
            if (i%2==1) {
                digito="1";
            }else{
                digito="0";
            }
            binario = digito+binario;
        }
        
        return binario;

    }
    
}
