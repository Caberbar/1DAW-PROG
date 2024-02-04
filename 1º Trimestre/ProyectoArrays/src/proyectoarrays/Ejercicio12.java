package proyectoarrays;

import funciones.LeerDatosTeclado;

public class Ejercicio12 {

    public static void main(String[] args) {

        int[] numeros = {0,1,2,3,4,5,6,7,8,9};//new int[10];

//        System.out.println("\nIntroduzca 10 números");
//        for (int contador = 0; contador < 10; contador++) {
//            numeros[contador] = LeerDatosTeclado.leerInt("Introduzca un número");
//        }

        System.out.println("\nÍndice\tValor");
        for (int contador = 0; contador < 10; contador++) {
            System.out.println(contador + "\t" + numeros[contador]);
        }

        int inicial = LeerDatosTeclado.leerIntSinNegConMax("Introduce el valor inicial:", 0, 9);

        int destino = LeerDatosTeclado.leerIntSinNegConMax("Introduce el valor destino:", 0, 9);

        while (destino < inicial) {
            System.out.println("El destino debe ser mayor al valor inicial");
            destino = LeerDatosTeclado.leerIntSinNegConMax("Introduce el valor inicial:", 0, 9);
        }

        int mover = numeros[9];
        int contador;
        for (contador = 9; contador > 0; contador--) {
            numeros[contador] = numeros[contador - 1];
        }
        for (int j = 0; j < numeros.length - 1; j++) {
            int aux = numeros[1 + contador];
            numeros[1 + contador] = numeros[0];
            numeros[0] = aux;  
        }
        System.out.println(contador);

        numeros[0] = mover;
        System.out.println("\nArray rotado:");
        for (contador = 0; contador < 10; contador++) {
            System.out.printf("|%3d ", numeros[contador]);
        }
    }
}

//Realiza un programa que pida 10 números por teclado y que los almacene en
//un array. A continuación se mostrará el contenido de ese array junto al índice
//(0 ? 9). Seguidamente el programa pedirá dos posiciones a las que llamaremos
//?inicial? y ?final?. Se debe comprobar que inicial es menor que final y que ambos
//números están entre 0 y 9. El programa deberá colocar el número de la posición
//inicial en la posición final, rotando el resto de números para que no se pierda
//ninguno. Al final se debe mostrar el array resultante.