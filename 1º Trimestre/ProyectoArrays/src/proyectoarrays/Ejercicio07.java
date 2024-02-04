package proyectoarrays;

import funciones.LeerDatosTeclado;

public class Ejercicio07 {
    public static void main(String[] args) {
    
    int[] numeros = new int[100];
    int contador;
    
    for (contador = 0; contador < 100; contador++) {
      numeros[contador] = (int)(Math.random() * 21);
      System.out.print(numeros[contador] + " ");
    }
    
    System.out.print("\nSelecciones un n�mero: ");
    int numero1 = LeerDatosTeclado.leerInt("Introduzca un n�mero");
    System.out.print("Por que numero des�a sustituirlo: ");
    int numero2 = LeerDatosTeclado.leerInt("Introduzca un n�mero");
    
    for (contador = 0; contador < 100; contador++) {
      if (numeros[contador] == numero1) {
        numeros[contador] = numero2;
        System.out.print("\"" + numeros[contador] + "\"  ");
      } else {
        System.out.print(numeros[contador] + "  ");
      }
    }
    
    
  }
}

//Escribe un programa que genere 100 n�meros aleatorios del 0 al 20 y que los
//muestre por pantalla separados por espacios. El programa pedir� entonces por
//teclado dos valores y a continuaci�n cambiar� todas las ocurrencias del primer
//valor por el segundo en la lista generada anteriormente. Los n�meros que se
//han cambiado deben aparecer entrecomillados.
