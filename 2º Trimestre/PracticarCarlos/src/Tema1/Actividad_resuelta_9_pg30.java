package Tema1;

import java.util.Scanner;

public class Actividad_resuelta_9_pg30 {


    public static void main(String[] args) {
        boolean par;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        int num = teclado.nextInt();
        
        if(num%2==0){
            par = true;
        }else{
            par = false;
        }
        
        if(par==true){
            System.out.println(num + " es par");
        }else{
            System.out.println(num + " es impar");
        }
    }
    
}
