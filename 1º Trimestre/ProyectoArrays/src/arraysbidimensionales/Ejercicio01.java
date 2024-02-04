package arraysbidimensionales;

public class Ejercicio01 {
    public static void main(String[] args){
 
    int[][] numero = new int[3][6];

    numero[0][0] = 0;
    numero[0][1] = 30;
    numero[0][2] = 2;
    numero[0][5] = 7;
    numero[1][0] = 75;
    numero[1][4] = 0;
    numero[2][2] = -2;
    numero[2][3] = 9;
    numero[2][5] = 11;

    int fila;
    int columna;

    System.out.print("-------------------------------------------------------");
    for(columna = 0; columna < 6; columna++) {
    }
    for(fila = 0; fila < 3; fila++) {

      System.out.print("\n Fila " + fila + " |");
  
      for(columna = 0; columna < 6; columna++) {
        System.out.printf("%5d   ", numero[fila][columna]);
    }
   }
    System.out.print("\n-------------------------------------------------------\n");
  }
}

//Define un array de números enteros de 3 filas por 6 columnas con nombre num
//y asigna los valores según la siguiente tabla. Muestra el contenido de todos
//los elementos del array dispuestos en forma de tabla como se muestra en la
//figura.