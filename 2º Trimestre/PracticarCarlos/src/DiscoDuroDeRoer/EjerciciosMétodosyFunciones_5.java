package DiscoDuroDeRoer;

import java.util.Scanner;

//Crea una aplicación que nos convierta un número en base decimal a binario. Esto
//lo realizara un método al que le pasaremos el numero como parámetro, devolverá 
//un String con el numero convertido a binario. Para convertir un numero decimal a
//binario, debemos dividir entre 2 el numero y el resultado de esa división se 
//divide entre 2 de nuevo hasta que no se pueda dividir mas, el resto que 
//obtengamos de cada división formara el numero binario, de abajo a arriba.

public class EjerciciosMétodosyFunciones_5 {

    public static void main(String[] args) {

        Scanner teclado=  new Scanner (System.in);

        System.out.println("Introduce el número que desea pasar a binario.");
        int num = teclado.nextInt();
        
        System.out.println("El número "+num+" pasado a binario es: "+generarBinario(num));
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
