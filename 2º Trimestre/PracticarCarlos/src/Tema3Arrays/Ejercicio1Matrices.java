/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tema3Arrays;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Ejercicio1Matrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Ejemplo de uso de las funciones
        int filas = 3;
        int columnas = 3;

        // Crear matriz aleatoria
        int[][] matrizAleatoria = crearMatrizAleatoria(filas, columnas);
        mostrarMatrizPantalla(matrizAleatoria);
        System.out.println("");
        mostrarMatrizPantalla(traspuesta(matrizAleatoria));
        System.out.println("");
        mostrarArray(sumaFilas(matrizAleatoria));
        System.out.println("");
        System.out.println(determinanteMatriz3x3(matrizAleatoria));
        // Crear matriz aleatoria con límites
//        int minimo = 1;
//        int maximo = 10;
//        int[][] matrizAleatoriaLimites = crearMatrizAleatoria(filas, columnas, minimo, maximo);
//        mostrarMatrizPantalla(matrizAleatoriaLimites);

        // Cargar matriz desde teclado
//        int[][] matrizTeclado = cargarMatrizTeclado(filas, columnas);
//        mostrarMatrizPantalla(matrizTeclado);
        // Cargar matriz desde teclado con límites
//        int[][] matrizTecladoLimites = cargarMatrizTeclado(filas, columnas, minimo, maximo);
//        mostrarMatrizPantalla(matrizTecladoLimites);
    }

    public static int[][] crearMatrizAleatoria(int filas, int columnas) {
        Random random = new Random();
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = Math.abs(random.nextInt());
            }
        }
        return matriz;
    }

    public static int[][] crearMatrizAleatoria(int filas, int columnas, int minimo, int maximo) {
        Random random = new Random();
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(maximo - minimo + 1) + minimo;
            }
        }
        return matriz;
    }

    public static int[][] cargarMatrizTeclado(int filas, int columnas) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el valor para la posición [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        return matriz;
    }

    public static int[][] cargarMatrizTeclado(int filas, int columnas, int minimo, int maximo) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el valor para la posición [" + i + "][" + j + "]: ");
                int valor = scanner.nextInt();
                if (valor < minimo || valor > maximo) {
                    System.out.println("El valor está fuera de rango. Se asignará un valor aleatorio en el rango.");
                    valor = new Random().nextInt(maximo - minimo + 1) + minimo;
                }
                matriz[i][j] = valor;
            }
        }
        return matriz;
    }

    public static void mostrarMatrizPantalla(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void mostrarArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]+" ");
        }
        System.out.println();
    }
    
    public static int[][] traspuesta(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] traspuesta = new int[columnas][filas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                traspuesta[j][i] = matriz[i][j];
            }
        }
        return traspuesta;
    }

    public static int[][] sumaMatrices(int[][] matriz1, int[][] matriz2) {
        int filas1 = matriz1.length;
        int columnas1 = matriz1[0].length;
        int filas2 = matriz2.length;
        int columnas2 = matriz2[0].length;
        if (filas1 != filas2 || columnas1 != columnas2) {
            throw new IllegalArgumentException("Las matrices deben tener el mismo número de filas y columnas");
        }
        int[][] suma = new int[filas1][columnas1];
        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas1; j++) {
                suma[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        return suma;
    }

    public static int[] sumaFilas(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[] sumaFilas = new int[filas];
        for (int i = 0; i < filas; i++) {
            int suma = 0;
            for (int j = 0; j < columnas; j++) {
                suma += matriz[i][j];
            }
            sumaFilas[i] = suma;
        }
        return sumaFilas;
    }

    public static int determinanteMatriz3x3(int[][] matriz) {
        if (matriz.length != 3 || matriz[0].length != 3) {
            throw new IllegalArgumentException("La matriz debe ser de tamaño 3x3");
        }
        int det = matriz[0][0] * matriz[1][1] * matriz[2][2]
                + matriz[0][1] * matriz[1][2] * matriz[2][0]
                + matriz[0][2] * matriz[1][0] * matriz[2][1]
                - matriz[0][2] * matriz[1][1] * matriz[2][0]
                - matriz[0][0] * matriz[1][2] * matriz[2][1]
                - matriz[0][1] * matriz[1][0] * matriz[2][2];
        return det;
    }
}
