package proyectoarrays;

public class Ejercicio18 {
    public static void main(String[] args) {
    int[] numeros = new int[10];
    int[] menores = new int[10];
    int[] mayores = new int[10];
    int cuentaMenores = 0;
    int cuentaMayores = 0;
    
    for (int contador = 0; contador < 10; contador++) {
      numeros[contador] = (int) (Math.random() * 201);
      
      if (numeros[contador] <= 100) {
        menores[cuentaMenores++] = numeros[contador];
      } else {
        mayores[cuentaMayores++] = numeros[contador];
      }
    }

    // Original
    System.out.println("\nArray original:");
    System.out.println(" ");
    System.out.print("Índice ");
    for (int contador = 0; contador < 10; contador++) {
      System.out.printf("-%4d ", contador);
    }
    System.out.println(" ");
    System.out.println(" ");
    System.out.print("Valor  ");
    for (int contador = 0; contador < 10; contador++) {
      System.out.printf("-%4d ", numeros[contador]);
    }
    System.out.println("  ");
    System.out.println("  ");

    // Genera el array resultado
    int[] resultado = new int[10];
    int menoresColocados = 0;
    int mayoresColocados = 0;
    
    int aux = 0;
    do {
      if (menoresColocados < cuentaMenores) {
        resultado[aux++] = menores[menoresColocados++];
      }
      if (mayoresColocados < cuentaMayores) {
        resultado[aux++] = mayores[mayoresColocados++];
      }
    } while (aux < 10);


    // Resultado
    System.out.println("\nArray resultado:");
    System.out.println("  ");
    System.out.print("Índice ");
    for (int contador = 0; contador < 10; contador++) {
      System.out.printf("-%4d ", contador);
    }
    System.out.println("  ");
    System.out.println("  ");
    System.out.print("Valor  ");
    for (int contador = 0; contador < 10; contador++) {
      System.out.printf("-%4d ", resultado[contador]);
    }
    System.out.println("  ");
    System.out.println("  ");
  }
}

//Realiza un programa que genere 10 números enteros aleatorios entre 0 y 200
//ambos incluidos y que los almacene en un array. A continuación, el programa
//debe mostrar el contenido de ese array junto al índice (0 ? 9). Seguidamente el
//programa debe colocar de forma alterna y en orden los menores o iguales de
//100 y los mayores de 100: primero menor, luego mayor, luego menor, luego
//mayor? Cuando se acaben los menores o los mayores, se completará con los
//números que queden.