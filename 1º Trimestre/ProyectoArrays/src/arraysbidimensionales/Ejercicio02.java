package arraysbidimensionales;

import funciones.Funciones;

public class Ejercicio02 {
    public static void main(String[] args) {

    int[][] numeros = new int[4][5];
    
    int fila = 0;
    int columna = 0;
    String mostrar;
    
    
    //Pedir al usuario 10 números
    mostrar = Funciones.pedirFilasColumnas(fila,columna,numeros);
    System.out.println(mostrar);
    
    System.out.println();

    //Procedemos a sumar las filas
    mostrar = Funciones.sumarFilas(fila,columna,numeros);
    System.out.println(mostrar);
    
    for(columna = 0; columna < 5; columna++) {
      System.out.print("----------");
    }
    System.out.println("-----------");

    //Procedemos a sumar las columnas
    mostrar = Funciones.sumarColumnas(fila,columna,numeros);
    System.out.println(mostrar);
    
    }
}


//Escribe un programa que pida 20 números enteros. Estos números se deben
//introducir en un array de 4 filas por 5 columnas. El programa mostrará las
//sumas parciales de filas y columnas igual que si de una hoja de cálculo se
//tratara. La suma total debe aparecer en la esquina inferior derecha.
