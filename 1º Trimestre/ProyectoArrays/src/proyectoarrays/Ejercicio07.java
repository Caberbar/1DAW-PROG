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
    
    System.out.print("\nSelecciones un número: ");
    int numero1 = LeerDatosTeclado.leerInt("Introduzca un número");
    System.out.print("Por que numero deséa sustituirlo: ");
    int numero2 = LeerDatosTeclado.leerInt("Introduzca un número");
    
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

//Escribe un programa que genere 100 números aleatorios del 0 al 20 y que los
//muestre por pantalla separados por espacios. El programa pedirá entonces por
//teclado dos valores y a continuación cambiará todas las ocurrencias del primer
//valor por el segundo en la lista generada anteriormente. Los números que se
//han cambiado deben aparecer entrecomillados.
