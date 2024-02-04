package proyectoarrays;

import funciones.Funciones;

public class Ejercicio03 {
    public static void main(String[] args) {
        int vuelta;

        System.out.println("Bienvenido al programa de ordenador los números al reves");
        System.out.println("--------------------------------------------------------");
        
        int cantidad = 10;
        int[] numeros = {0};
        numeros = new int[cantidad];
        
        vuelta = Funciones.inverso(numeros);
        System.out.println(vuelta);
        
    }
}

//Escribe un programa que lea 10 números por teclado y que luego los muestre
//en orden inverso, es decir, el primero que se introduce es el último en mostrarse
//y viceversa.
