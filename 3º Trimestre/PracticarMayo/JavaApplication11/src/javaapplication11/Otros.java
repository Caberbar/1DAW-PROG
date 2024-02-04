package javaapplication11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Otros {

    public static void main(String[] args) {

        //Crear una matriz de 3×3 con los números del 1 al 9. Mostrar por pantalla, tal como aparece en la matriz.
//        int [][] numeros = new int[3][3];
//
//        for (int i = 0; i < numeros.length; i++) {
//            for (int j = 0; j < numeros[0].length; j++) {
//                numeros[i][j]=(i * numeros.length)+j+1;
//                System.out.println(numeros[i][j]);
//            }
//            System.out.println("");
//        }
        //Crear una matriz de 5 filas y n columnas (se pide al usuario). Rellenarlo con números aleatorios entre 0 y 10.
//        int [][] numeros = new int[5][7];
//        
//        for (int i = 0; i < numeros.length; i++) {
//            for (int j = 0; j < numeros[0].length; j++) {
//                numeros[i][j] = (int) Math.floor(Math.random()*(0-(10+1))+(10+1));
//                System.out.println(numeros[i][j]);
//            }
//            System.out.println("");
//        }
        //Crear dos matrices de nxn y sumar sus valores, los resultados se deben almacenar en otra matriz. Los valores y la longitud, seran insertados por el usuario. Mostrar las matrices originales y el resultado.
//        Scanner sn = new Scanner(System.in);
//
//        int[][] numero1 = new int[3][3];
//        int[][] numero2 = new int[3][3];
//
//        int[][] suma = new int[3][3];
//
//        for (int i = 0; i < numero1.length; i++) {
//            for (int j = 0; j < numero1[0].length; j++) {
//                System.out.println("Escriba el valor para la fila " + i + " y columna " + j + " de la matriz 1");
//                numero1[1][j] = sn.nextInt();
//                System.out.println("Escriba el valor para la fila "+i+" y columna "+j+" de la matriz 2");
//                numero2[1][j] = sn.nextInt();
//
//                suma[i][j] = numero1[i][j] + numero2[i][j];
//            }
//        }
//
//        System.out.println("Matriz resultante");
//        muestraMatriz(suma);

        //Ordenar Array
//        int[] numeros = new int[]{12, 3, 5, 21, 4, 85, 6, 9, 2, 1};
//        
//        for (int i = 0; i < numeros.length; i++) {
//            for (int j = 0; j < numeros.length; j++) {
//                if (numeros[i] < numeros[j]) {
//                    int temp = numeros[i];
//                    numeros[i] = numeros[j];
//                    numeros[j] = temp;
//                }
//            }
//        }
//        System.out.println("\nAfter Sorting...");
//        for (int i : numeros) {
//            System.out.print(i + " ");
//        }

        
        //Ordenar ArrayList
//        ArrayList<Integer> lista = new ArrayList<>();
//        lista.add(5);
//        lista.add(2);
//        lista.add(8);
//        lista.add(1);
//        lista.add(9);
//        lista.add(3);
//        
//        int n = lista.size();
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < n - i - 1; j++) {
//                if (lista.get(j) > lista.get(j + 1)) {
//                    // Intercambiar elementos
//                    int temp = lista.get(j);
//                    lista.set(j, lista.get(j + 1));
//                    lista.set(j + 1, temp);
//                }
//            }
//        }
//        for (int elemento : lista) {
//            System.out.print(elemento + " ");
//        }


        //Ordenar Matriz
         int[][] multi = new int [][]{
                {4, 9, 8},
                {7, 5, 2},
                {3, 0, 6},

        };
        for(int i = 0; i< multi.length; i++) {
            for (int j = 0; j < multi[i].length; j++)
                System.out.print(multi[i][j] + " ");
                System.out.println();

        }
        //sort according to 3 column
        Sort2DArrayBasedOnColumnNumber(multi,3);
        System.out.println("after sorting");
        for(int i = 0; i< multi.length; i++) {
            for (int j = 0; j < multi[i].length; j++)
                System.out.print(multi[i][j] + " ");
                System.out.println();

        }
    }

    public static  void Sort2DArrayBasedOnColumnNumber (int[][] array, final int columnNumber){
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
               if(first[columnNumber-1] > second[columnNumber-1]) return 1;
               else return -1;
            }
        });
    }
    
    public static void muestraMatriz(int[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }

    }

}
