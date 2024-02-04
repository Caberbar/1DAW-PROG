package arraysbidimensionales;

public class Ejercicio12 {
    public static void main(String[] args) {
    int[][] n = new int[9][9];

    // Genera el array y lo muestra
    for (int cont = 0; cont < n.length; cont++) {
      for (int cont2 = 0; cont2 < n[0].length; cont2++) {
        n[cont][cont2] = (int) (Math.random() * 401) + 500;
        System.out.printf("%5d", n[cont][cont2]);
      }
      System.out.println();
    }

    System.out.print("\nDiagonal desde la esquina inferior izquierda ");
    System.out.println("a la esquina superior derecha: ");

    int maximo = 500;
    int minimo = 900;
    int suma = 0;
    double media;


    for (int cont = 0; cont < 9; cont++) {
      int numero = n[8 - cont][cont];
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
    
    System.out.println("\nM�ximo: " + maximo);
    System.out.println("M�nimo: " + minimo);
    System.out.println("Media: " + media);
  }
}


//Realiza un programa que muestre por pantalla un array de 9 filas por 9
//columnas relleno con n�meros aleatorios entre 500 y 900. A continuaci�n, el
//programa debe mostrar los n�meros de la diagonal que va desde la esquina
//inferior izquierda a la esquina superior derecha, as� como el m�ximo, el m�nimo
//y la media de los n�meros que hay en esa diagonal.
