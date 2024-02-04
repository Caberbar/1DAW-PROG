package proyectoarrays;

import funciones.LeerDatosTeclado;

public class Ejercicio06 {
    public static void main(String[] args) {

    int num [][] = new int [3][6];
  
    num [0][0]=0;
    num [0][1]=30;
    num [0][2]=2;
    num [1][0]=75;
    num [1][4]=0;
    num [2][2]=-2;
    num [2][3]=9;
    num [2][5]=11;
    
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[0].length; j++) {
                System.out.printf("%5d   ",num[i][j]);
            }
        }
    }
}

//Escribe un programa que lea 15 números por teclado y que los almacene en un
//array. Rota los elementos de ese array, es decir, el elemento de la posición 0
//debe pasar a la posición 1, el de la 1 a la 2, etc. El número que se encuentra en
//la última posición debe pasar a la posición 0. Finalmente, muestra el contenido
//del array.
