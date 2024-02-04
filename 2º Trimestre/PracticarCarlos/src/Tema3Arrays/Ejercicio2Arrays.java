/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tema3Arrays;

import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class Ejercicio2Arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[] array = {2.5, 5.1, 1.3, 4.7, 3.2};

        // Prueba de las funciones
        double maximo = obtenerMaximo(array);
        double minimo = obtenerMinimo(array);
        double media = calcularMedia(array);
        double moda = obtenerModa(array);
        int posicion = buscarNumero(array, 4.7);
        double[] arrayVolteado = voltearArray(array);

        System.out.println("Máximo: " + maximo);
        System.out.println("Mínimo: " + minimo);
        System.out.println("Media: " + media);
        System.out.println("Moda: " + moda);
        System.out.println("Posición del número 4.7: " + posicion);
        System.out.println("Array volteado: " + Arrays.toString(arrayVolteado));
    }

    public static double obtenerMaximo(double[] array) {
        double maximo = Double.MIN_VALUE;
        for (double elemento : array) {
            if (elemento > maximo) {
                maximo = elemento;
            }
        }
        return maximo;
    }

    public static double obtenerMinimo(double[] array) {
        double minimo = Double.MAX_VALUE;
        for (double elemento : array) {
            if (elemento < minimo) {
                minimo = elemento;
            }
        }
        return minimo;
    }

    public static double calcularMedia(double[] array) {
        double suma = 0;
        for (double elemento : array) {
            suma += elemento;
        }
        return suma / array.length;
    }

    public static double obtenerModa(double[] array) {
        double moda = 0;
        int maxFrecuencia = 0;

        for (int i = 0; i < array.length; i++) {
            int frecuencia = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == array[i]) {
                    frecuencia++;
                }
            }
            if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
                moda = array[i];
            }
        }
        return moda;
    }

    public static int buscarNumero(double[] array, double numero) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numero) {
                return i;
            }
        }
        return -1;
    }

    public static double[] voltearArray(double[] array) {
        double[] volteado = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            volteado[i] = array[array.length - 1 - i];
        }
        return volteado;
    }
}
