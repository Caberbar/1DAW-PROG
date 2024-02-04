package proyectoarrays;

import java.util.Scanner;

public class Ejercicio19 {
    public static void main(String[] args) {
    

    int[] numeros = new int[12];
    
    for (int contador = 0; contador < 12; contador++) {
      numeros[contador] = (int) (Math.random() * 201);
    }


    System.out.println("Array original:");
    
    System.out.print("\nÍndice ");
    
    for (int contador = 0; contador < 12; contador++) {
      System.out.printf("%4d ", contador);
    }
    
    System.out.print("\nValor  ");
    
    for (int contador = 0; contador < 12; contador++) {
      System.out.printf("%4d ", numeros[contador]);
    }
    

    Scanner aux = new Scanner(System.in);
    
    System.out.print("\n\nIntroduzca el número que quiere insertar: ");
    int numero = Integer.parseInt(aux.nextLine());
    
    System.out.print("Introduzca la posición donde lo quiere insertar (0 - 11): ");
    int posicion = Integer.parseInt(aux.nextLine());
    
    
    for (int contador = 11; contador > posicion; contador--) {
      numeros[contador] = numeros[contador - 1];
    }
    
    numeros[posicion] = numero;
    

    
    System.out.println("\nArray resultado:");
    
    System.out.print("\nÍndice ");
    
    for (int contador = 0; contador < 12; contador++) {
      System.out.printf("%4d ", contador);
    }
    
    System.out.print("\nValor  ");
    
    for (int contador = 0; contador < 12; contador++) {
      System.out.printf("%4d ", numeros[contador]);
    }
  }
  
}

//Realiza un programa que sea capaz de insertar un número en una posición
//concreta de un array. En primer lugar, el programa generará un array de 12
//números enteros aleatorios entre 0 y 200 ambos incluidos. A continuación se
//debe mostrar el contenido de ese array junto al índice (0 ? 11). Seguidamente
//el programa preguntará por el número que se quiere insertar y por la posición
//donde será insertado. Los números del array se desplazan a la derecha para
//dejar sitio al nuevo. El último número (el que se encuentra en la posición 11)
//siempre se perderá.