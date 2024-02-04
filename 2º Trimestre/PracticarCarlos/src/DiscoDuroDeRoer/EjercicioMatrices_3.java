package DiscoDuroDeRoer;

import java.util.Scanner;


//Crear dos matrices de nxn y sumar sus valores, los resultados se deben 
//almacenar en otra matriz. Los valores y la longitud, seran insertados por el 
//usuario. Mostrar las matrices originales y el resultado.

public class EjercicioMatrices_3 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner (System.in);
        System.out.println("Introduce el número de filas que deseas: ");
        int filas = teclado.nextInt();
        System.out.println("Introduce el número de columnas que deseas: ");
        int columnas = teclado.nextInt();
        
        int matriz1[][] = new int[filas][columnas];
        int matriz2[][] = new int[filas][columnas];
        int matrizCopia[][] = new int[filas][columnas];
        
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {               
                System.out.println("Escriba el valor para la fila "+i+" y columna "+j+" de la matriz 1");
                matriz1[i][j]=teclado.nextInt();
                System.out.println("Escriba el valor para la fila "+i+" y columna "+j+" de la matriz 2");
                matriz2[i][j]=teclado.nextInt();
                matrizCopia[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        
        System.out.println("Matriz con la suma: ");
        System.out.println("");
        for (int i = 0; i < matrizCopia.length; i++) {
            for (int j = 0; j < matrizCopia[0].length; j++) {
                System.out.print(matrizCopia[i][j]+"");
            }
            System.out.println("");
        }
        
    }
    
}
