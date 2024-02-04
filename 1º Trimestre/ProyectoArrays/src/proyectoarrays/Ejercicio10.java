package proyectoarrays;

public class Ejercicio10 {
    public static void main(String[] args) {
  
    int[] numeros = new int[20];
    int[] par = new int[20];
    int[] impar = new int[20];
    int contador;
    int pares = 0;
    int impares = 0;
    
    for (contador = 0; contador < 20; contador++) {
      numeros[contador] = (int)(Math.random() * 101);
      if (numeros[contador] % 2 == 0) {
        par[pares++] = numeros[contador];
      } else {
        impar[impares++] = numeros[contador];
      }
    }
    
    System.out.println("Array original:");
    for (contador = 0; contador < 20; contador++) {
      System.out.print(numeros[contador] + " ");
    }
    
    for (contador = 0; contador < pares; contador++) {
      numeros[contador] = par[contador];
    }
    
    for (contador = pares; contador < 20; contador++) {
      numeros[contador] = impar[contador - pares];
    }
    System.out.println("\nArray empezando con por pares:");
    for (contador = 0; contador < 20; contador++) {
      System.out.print(numeros[contador] + " ");
    }
  }
}

//Escribe un programa que genere 20 números enteros aleatorios entre 0 y 100
//y que los almacene en un array. El programa debe ser capaz de pasar todos
//los números pares a las primeras posiciones del array (del 0 en adelante) y
//todos los números impares a las celdas restantes. Utiliza arrays auxiliares si es
//necesario.
