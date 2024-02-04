package proyectoarrays;

import java.util.Scanner;

public class Ejercicio19 {
    public static void main(String[] args) {
    

    int[] numeros = new int[12];
    
    for (int contador = 0; contador < 12; contador++) {
      numeros[contador] = (int) (Math.random() * 201);
    }


    System.out.println("Array original:");
    
    System.out.print("\n�ndice ");
    
    for (int contador = 0; contador < 12; contador++) {
      System.out.printf("%4d ", contador);
    }
    
    System.out.print("\nValor  ");
    
    for (int contador = 0; contador < 12; contador++) {
      System.out.printf("%4d ", numeros[contador]);
    }
    

    Scanner aux = new Scanner(System.in);
    
    System.out.print("\n\nIntroduzca el n�mero que quiere insertar: ");
    int numero = Integer.parseInt(aux.nextLine());
    
    System.out.print("Introduzca la posici�n donde lo quiere insertar (0 - 11): ");
    int posicion = Integer.parseInt(aux.nextLine());
    
    
    for (int contador = 11; contador > posicion; contador--) {
      numeros[contador] = numeros[contador - 1];
    }
    
    numeros[posicion] = numero;
    

    
    System.out.println("\nArray resultado:");
    
    System.out.print("\n�ndice ");
    
    for (int contador = 0; contador < 12; contador++) {
      System.out.printf("%4d ", contador);
    }
    
    System.out.print("\nValor  ");
    
    for (int contador = 0; contador < 12; contador++) {
      System.out.printf("%4d ", numeros[contador]);
    }
  }
  
}

//Realiza un programa que sea capaz de insertar un n�mero en una posici�n
//concreta de un array. En primer lugar, el programa generar� un array de 12
//n�meros enteros aleatorios entre 0 y 200 ambos incluidos. A continuaci�n se
//debe mostrar el contenido de ese array junto al �ndice (0 ? 11). Seguidamente
//el programa preguntar� por el n�mero que se quiere insertar y por la posici�n
//donde ser� insertado. Los n�meros del array se desplazan a la derecha para
//dejar sitio al nuevo. El �ltimo n�mero (el que se encuentra en la posici�n 11)
//siempre se perder�.