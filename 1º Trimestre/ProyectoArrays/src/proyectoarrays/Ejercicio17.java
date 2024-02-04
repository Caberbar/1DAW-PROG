package proyectoarrays;

public class Ejercicio17 {
    public static void main(String[] args) {
  
    int[] n = new int[10];

    // Genera el array
    for (int i = 0; i < 10; i++) {
      n[i] = (int)(Math.random() * 381) + 20;
    }

    // Muestra el array original.
    System.out.println("\n\n Array original:");
    System.out.println("\n ");
    System.out.print("�ndice ");
    for (int i = 0; i < 10; i++) {
      System.out.printf("?%4d ", i);
    }
    System.out.println("\n");
    System.out.print("Valor  ");
    for (int i = 0; i < 10; i++) {
      System.out.printf("%4d ", n[i]);
    }
    System.out.println("\n");

    // Pide un n�mero que est� dentro del array
    boolean existeNumero = false;
    int numeroIntroducido;
    do {
      System.out.print("\nIntroduzca uno de los n�meros del array: ");
      numeroIntroducido = Integer.parseInt(System.console().readLine());
      
      // Comprueba si el n�mero introducido se encuentra dentro del array
      for (int elemento : n) {
        if (elemento == numeroIntroducido) {
          existeNumero = true;
        }
      }
      
      if (!existeNumero) {
        System.out.println("Ese n�mero no se encuentra en el array.");
      }
    } while (!existeNumero);
    
    // Rota los el array hasta que el n�mero introducido se coloque en la posici�n 0
    while (n[0] != numeroIntroducido) {
      int aux = n[9];
      // Rotaci�n a la derecha
      for (int i = 9; i > 0; i--) {
        n[i] = n[i -1];
      }
      n[0] = aux;
    }

    // Muestra el resultado.
    System.out.println("\nArray resultante:");
    System.out.println("\n");
    System.out.print("�ndice ");
    for (int i = 0; i < 10; i++) {
      System.out.printf("%4d ", i);
    }
    System.out.println("\n");
    System.out.print("Valor  ");
    for (int i = 0; i < 10; i++) {
      System.out.printf("%4d ", n[i]);
    }
    System.out.println("\n"); 
  }
}


//Escribe un programa que muestre por pantalla un array de 10 n�meros enteros
//generados al azar entre 0 y 100. A continuaci�n, el programa debe pedir un
//n�mero al usuario. Se debe comprobar que el n�mero introducido por teclado
//se encuentra dentro del array, en caso contrario se mostrar� un mensaje por
//pantalla y se volver� a pedir un n�mero; as� hasta que el usuario introduzca uno
//correctamente. A continuaci�n, el programa rotar� el array hacia la derecha
//las veces que haga falta hasta que el n�mero introducido quede situado en la
//posici�n 0 del array. Por �ltimo, se mostrar� el array rotado por pantalla.