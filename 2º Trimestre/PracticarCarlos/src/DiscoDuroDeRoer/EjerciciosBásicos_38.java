package DiscoDuroDeRoer;

//Pedir n�meros al usuario y cuando el usuario meta un -1 se terminar� el programa.

import java.util.Scanner;

//Al terminar, mostrar� lo siguiente:
//? mayor numero introducido
//? menor numero introducido
//? suma de todos los numeros
//? suma de los numeros positivos
//? suma de los numeros negativos
//? media de la suma (la primera que pido)
//
//El n�mero -1 no contara como n�mero.

public class EjerciciosB�sicos_38 {

    public static void main(String[] args) {

        int num = 0, mayor = 0,menor = 0,sumt = 0,sumpo = 0,sumne = 0,contador = 0;
        Scanner teclado = new Scanner (System.in);
        
        do{
            System.out.println("Introduce un n�mero:");
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
        System.out.println("El n�mero mayor introducido es: "+mayor);
        System.out.println("El n�mero menor introducido es: "+menor);
        System.out.println("La suma total de los n�meros introducidos es: "+sumt);
        System.out.println("La suma total de los n�meros positivos introducidos es: "+sumpo);
        System.out.println("La suma total de los n�meros negativos introducidos es: "+sumne);
        System.out.println("La media de los n�meros introducidos es: "+(double)(sumt/contador));
    }
    
}
