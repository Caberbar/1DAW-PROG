package arraysbidimensionales;

import funciones.Funciones;

public class Ejercicio11 {
    public static void main(String[] args) {
    
    int[][] numeros = new int[10][10];
    String mostrar;

    // genera el array y lo muestra //
    mostrar = Funciones.generarArray(numeros);
    System.out.println(mostrar);


    System.out.print("\nDiagonal desde la esquina superior izquierda ");
    System.out.println("a la esquina inferior derecha: ");
    
    int maximo = 200;
    int minimo = 300;
    int suma = 0;
    double media;
    
    for(int cont = 0; cont < 10; cont++) {
      int numero = numeros[cont][cont];
      System.out.print(numero + " ");
      if (numero > maximo) {
        maximo = numero;
      }
      if (numero < minimo) {
        minimo = numero;
      }
      suma += numero;
    }
   
    media = (double)suma / 10;
    
    System.out.println("\nMáximo: " + maximo);
    System.out.println("Mínimo: " + minimo);
    System.out.println("Media: " + media);
  }
}

//Realiza un programa que muestre por pantalla un array de 10 filas por 10
//columnas relleno con números aleatorios entre 200 y 300. A continuación, el
//programa debe mostrar los números de la diagonal que va desde la esquina
//superior izquierda a la esquina inferior derecha, así como el máximo, el mínimo
//y la media de los números que hay en esa diagonal.
