package proyectoarrays;

public class Ejercicio13 {
    
    public static void main(String[] args){
 
    int[][] num = new int[6][10];

    int fila;
    int columna;
 
    int minimo = Integer.MAX_VALUE;
    int filaMinimo = 0;
    int columnaMinimo = 0;
    
    int maximo = Integer.MIN_VALUE;
    int filaMaximo = 0;
    int columnaMaximo = 0;

    System.out.print("\n      ");
    for(columna = 0; columna < 10; columna++) {
      System.out.print("   " + columna + "  ");
    }
    System.out.println();
    
    System.out.print("    ?");
    for(columna = 0; columna < 10; columna++) {
      System.out.print("??????");
    }
    System.out.println("?");
    
    for(fila = 0; fila < 6; fila++) {
      System.out.print("  " + fila + " ?");
      for(columna = 0; columna < 10; columna++) {
        num[fila][columna] = (int)(Math.random() * 1001);
        System.out.printf("%5d ", num[fila][columna]);
        ///Thread.sleep(100);
        
        // Calcula el m�nimo y guarda sus coordenadas
        if (num[fila][columna] < minimo) {
          minimo = num[fila][columna];
          filaMinimo = fila;
          columnaMinimo = columna;
        }
        
        // Calcula el m�ximo y guarda sus coordenadas
        if (num[fila][columna] > maximo) {
          maximo = num[fila][columna];
          filaMaximo = fila;
          columnaMaximo = columna;
        }
      }
      System.out.println("?");
    }
    System.out.print("    ?");
    for(columna = 0; columna < 10; columna++) {
      System.out.print("??????");
    }

    System.out.println("?\n\nEl m�ximo es " + maximo + " y est� en la fila " + filaMaximo + ", columna " + columnaMaximo);
    System.out.println("El m�nimo es " + minimo + " y est� en la fila " + filaMinimo + ", columna " + columnaMinimo);
    } 
}

//Escribe un programa que rellene un array de 100 elementos con n�meros enteros aleatorios comprendidos entre 0 y 500 (ambos incluidos). A continuaci�n
//el programa mostrar� el array y preguntar� si el usuario quiere destacar el
//m�ximo o el m�nimo. Seguidamente se volver� a mostrar el array escribiendo
//el n�mero destacado entre dobles asteriscos