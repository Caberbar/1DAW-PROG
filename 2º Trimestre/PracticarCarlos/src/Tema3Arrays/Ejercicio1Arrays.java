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
public class Ejercicio1Arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Prueba de las funciones
        int[] arrayAleatorio = crearArrayAleatorio(10);
        mostrarArrayPantalla(arrayAleatorio);

        int[] arrayAleatorioMinMax = crearArrayAleatorio(5, 10, 50);
        mostrarArrayPantalla(arrayAleatorioMinMax);

        int[] arrayTeclado = cargarArrayTeclado(3);
        mostrarArrayPantalla(arrayTeclado);

        int[] arrayTecladoMinMax = cargarArrayTeclado(4, 1, 100);
        mostrarArrayPantalla(arrayTecladoMinMax);
    }

    public static int[] crearArrayAleatorio(int n) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static int[] crearArrayAleatorio(int n, int minimo, int maximo) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(maximo - minimo + 1) + minimo;
        }
        return array;
    }

    public static int[] cargarArrayTeclado(int n) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Introduce el valor del elemento " + i + ": ");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int[] cargarArrayTeclado(int n, int minimo, int maximo) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Introduce un valor entre " + minimo + " y " + maximo + " para el elemento " + i + ": ");
            int valor = scanner.nextInt();
            while (valor < minimo || valor > maximo) {
                System.out.print("Valor fuera del rango. Introduce nuevamente: ");
                valor = scanner.nextInt();
            }
            array[i] = valor;
        }
        return array;
    }

    public static void mostrarArrayPantalla(int[] array) {
        System.out.print("Contenido del array: [");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println("]");
    }
}
