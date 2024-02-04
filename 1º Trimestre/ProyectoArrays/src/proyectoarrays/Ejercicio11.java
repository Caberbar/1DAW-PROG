package proyectoarrays;

import funciones.LeerDatosTeclado;

public class Ejercicio11 {
    public static void main(String[] args) {
    
    int[] numeros = new int[10];
    int[] resultado = new int[10];
    int contadorNumeros = 0;
    int b = 0;
    int primos = 0;
    int x;
    
    System.out.println("\nIntroduzca 10 números");
    for (int contador = 0; contador < 10; contador++) {
      numeros[contador] = LeerDatosTeclado.leerInt("Introduzca un número");
    }
    
    System.out.println("\nÍndice\tOrden");
    for (int contador = 0; contador < 10; contador++) {
      System.out.println(contador + "\t" + numeros[contador]);
    }
    
    for (int contador = 0; contador < 10; contador++) {
      do {
        primos++;
        x = numeros[contador] % primos;
        
        if (x == 0) {
          contadorNumeros++;
        }
      } while (primos != numeros[contador]); 
      
        if (contadorNumeros == 2) {
          resultado[b] = numeros[contador];
          b++;
        }
      contadorNumeros = 0;
      primos = 0;
    }
    
    for (int contador = 0; contador < 10; contador++) {
      do {
        primos++;
        x = numeros[contador] % primos;
        
        if (x == 0) {
          contadorNumeros++;
        }
      } while (primos != numeros[contador]);  
      
        if (contadorNumeros != 2) {
        resultado[b] = numeros[contador];
        b++;
        }
      contadorNumeros = 0;
      primos = 0;
    }
    
    System.out.println("\nÍndice\tOrden");
    for (int contador = 0; contador < 10; contador++) {
      System.out.println(contador + "\t" + resultado[contador]);
    }
  }
}


//Realiza un programa que pida 10 números por teclado y que los almacene en
//un array. A continuación se mostrará el contenido de ese array junto al índice
//(0 ? 9) utilizando para ello una tabla. Seguidamente el programa pasará los
//primos a las primeras posiciones, desplazando el resto de números (los que no
//son primos) de tal forma que no se pierda ninguno. Al final se debe mostrar el
//array resultante.