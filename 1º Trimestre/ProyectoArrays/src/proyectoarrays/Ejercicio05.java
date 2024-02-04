package proyectoarrays;

import funciones.LeerDatosTeclado;

public class Ejercicio05 {
    public static void main(String[] args) {
        int[] numero;
        numero = new int[10];

        int maximo = numero[0];
        int minimo = numero[0];

        for (int contador = 0; contador < 10; contador++) {
            numero[contador] = LeerDatosTeclado.leerInt("Introduce 10 numeros: ");
            if (numero[contador] > maximo) {
                maximo = numero[contador];
            }
            if (numero[contador] < minimo) {
                minimo = numero[contador];
            }
        }

        System.out.println("Los numeros son: ");

        for (int contador = 0; contador < 10; contador++) {
            System.out.println(numero[contador]);
            if (numero[contador] == maximo) {
                System.out.println("\n"+maximo + " maximo");
            } else if (numero[contador] == minimo) {
                System.out.println("\n"+minimo + " minimo");
            }
        }		
    }
}

//Escribe un programa que pida 10 números por teclado y que luego muestre los
//números introducidos junto con las palabras ?máximo? y ?mínimo? al lado del
//máximo y del mínimo respectivamente.