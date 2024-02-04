package DiscoDuroDeRoer;

//Pedir números al usuario y cuando el usuario meta un -1 se terminará el programa.

import java.util.Scanner;

//Al terminar, mostrará lo siguiente:
//? mayor numero introducido
//? menor numero introducido
//? suma de todos los numeros
//? suma de los numeros positivos
//? suma de los numeros negativos
//? media de la suma (la primera que pido)
//
//El número -1 no contara como número.

public class EjerciciosBásicos_38 {

    public static void main(String[] args) {

        int num = 0, mayor = 0,menor = 0,sumt = 0,sumpo = 0,sumne = 0,contador = 0;
        Scanner teclado = new Scanner (System.in);
        
        do{
            System.out.println("Introduce un número:");
            num = teclado.nextInt();
            if(num!=-1){
                if(num>mayor){
                    mayor = num;
                    sumpo += num;
                }
                if(num<menor){
                    menor = num;
                    sumne += num;
                }
                sumt += num;
                contador ++;
            }
            
        }while(num!=-1);
        System.out.println("El número mayor introducido es: "+mayor);
        System.out.println("El número menor introducido es: "+menor);
        System.out.println("La suma total de los números introducidos es: "+sumt);
        System.out.println("La suma total de los números positivos introducidos es: "+sumpo);
        System.out.println("La suma total de los números negativos introducidos es: "+sumne);
        System.out.println("La media de los números introducidos es: "+(double)(sumt/contador));
    }
    
}
