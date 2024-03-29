
package DiscoDuroDeRoer;

//Nos piden que implementemos el software para una m�quina expendedora de golosinas.
//Cada golosina tiene un nombre y un precio para ahorrar tiempo, os paso los datos que tendr� a continuaci�n (copiar y pegar):

//Tambi�n tendr�n una cantidad inicial, que en principio ser� de 5.
//
//Tendremos un peque�o men� con las siguientes opciones:
//
//Pedir golosina: pedir� la posici�n de la golosina que quiera. Esta m�quina tiene golosinas en cada posici�n, identificados por su fila y columna, que ser� lo que introduzca el usuario al pedir una golosina, por ejemplo si el usuario teclea 20 significa que est� pidiendo la golosina que est� en la fila 2 columna 0. Cuando no haya m�s golosinas se le indicar� al usuario. Solo puede pedir una golosina y supondremos que el usuario siempre tiene dinero al elegir. Recuerda de disminuir la cantidad la pedir.
//Mostrar golosinas: mostrara todas las golosinas disponibles. Mostrar� el c�digo que debe introducir el usuario, el nombre y el precio. La cantidad no se mostrar�.
//Rellenar golosinas: esta es una funci�n exclusiva de un t�cnico por lo que nos pedir� una contrase�a, si el usuario escribe ?MaquinaExpendedora2017? le pedir� la posici�n de la golosina y la cantidad.
//Apagar maquina: sale del programa, antes de salir mostrara las ventas totales durante la ejecuci�n del programa.
//El programa debe ser modularizado, es decir, todas las funciones que veas que sean necesarias debes crearlas, as� como todas aquellas acciones que veas que se repitan. Piensa que funciones pueden ser.
//
//Las funciones deben ser lo m�s gen�ricas posibles.
//
//No se deben utilizar POO para este ejercicio.

import java.util.InputMismatchException;
import java.util.Scanner;


public class EjercicioMatrices_8 {

    static Scanner sn = new Scanner(System.in);
 
    public static void main(String[] args) {
 
        //Llamo al m�todo menu
        menu();
 
    }
 
    /**
     * Muestra el menu, solicita la opcion y las ejecuta
     */
    public static void menu() {
 
        //Nombre de las golosinas
        String[][] nombresGolosinas = {
            {"KitKat", "Chicles de fresa", "Lacasitos", "Palotes"},
            {"Kinder Bueno", "Bolsa variada Haribo", "Chetoos", "Twix"},
            {"Kinder Bueno", "M&M'S", "Papa Delta", "Chicles de menta"},
            {"Lacasitos", "Crunch", "Milkybar", "KitKat"}
        };
 
        //Precio de las golosinas
        double[][] precio = {
            {1.1, 0.8, 1.5, 0.9},
            {1.8, 1, 1.2, 1},
            {1.8, 1.3, 1.2, 0.8},
            {1.5, 1.1, 1.1, 1.1}
        };
 
        int cantidad[][] = new int[4][4];
 
        //Relleno la matriz con 5
        rellenarMatriz(cantidad, 5);
 
        //Indica si salimos o no
        boolean salir = false;
        int opcion, fila, columna, cantidadNueva;
        String pos, password;
        double ventaTotales = 0;
 
        //Bucle para pedir las opciones hasta que elijamos salir
        while (!salir) {
 
            //opciones
            System.out.println("1. Pedir golosina");
            System.out.println("2. Mostrar golosinas");
            System.out.println("3. Rellenar golosinas");
            System.out.println("4. Apagar maquina");
 
            try {
 
                //Pide una opcion
                System.out.println("Introduce un numero: ");
                opcion = sn.nextInt();
 
                //Realiza una de las opciones
                switch (opcion) {
                    case 1:
 
                        //Pido la posicion
                        pos = pedirCadena("Introduce la posicion que quieras");
 
                        //Valido la posicion
                        if (validarPos(nombresGolosinas, pos)) {
                             
                            //Extraigo la fila y columna
                            fila = extraerNumero(pos, 0);
                            columna = extraerNumero(pos, 1);
 
                            //Indico si hay valores en la matriz
                            if (hayValorPosicion(cantidad, fila, columna)) {
                                //Muestro la golosina
                                System.out.println("Aqui tiene su golosiona: " + nombresGolosinas[fila][columna] + ". Gracias por su compra");
 
                                //Reduzco la cantidad en 1
                                reducirPosicion(cantidad, fila, columna, 1);
 
                                //aumento la cantidad
                                ventaTotales += precio[fila][columna];
 
                            } else {
                                System.out.println("No hay mas golosinas de este tipo, espere al t�cnico para que la rellene");
                            }
 
                        } else {
                            System.out.println("La posicion introducida no es valida");
                        }
 
                        break;
                    case 2:
 
                        //muestro las golosinas
                        mostrarGolosionas(nombresGolosinas, precio);
 
                        break;
                    case 3:
 
                        //pido el password
                        password = pedirCadena("Introduce la contrase�a");
 
                        //Compruebo si es correcta la contrase�a
                        if (cadenaIguales(password, "MaquinaExpendedora2017")) {
 
                            //Pido la posicion
                            pos = pedirCadena("Introduce la posicion que quieras");
                             
                            //Extraigo los numeros
                            fila = extraerNumero(pos, 0);
                            columna = extraerNumero(pos, 1);
 
                            //Validamos la posicion dada
                            if (validarPos(nombresGolosinas, pos)) {
                                //Introducimos la cantidad
                                cantidadNueva = pedirInteger("Introduce la cantidad");
 
                                //Aumentamos la cantidad en el valor dado
                                aumentarPosicion(cantidad, fila, columna, cantidadNueva);
 
                                System.out.println("Se ha incrementado la cantidad");
 
                            }else{
                                 System.out.println("La posicion introducida no es valida");
                            }
 
                        }else{
                            System.out.println("La contrase�a incorrecta");
                        }
 
                        break;
                    case 4:
                         
                        //Muestro las ventas
                        System.out.println("Las ventas han sido de "+ventaTotales);
                         
                        salir = true;
                        break;
                    default:
                        System.out.println("Las opciones son entre 1 y 7");
                }
 
                //controla la excepcionn en caso de que se introduzca un valor no correcto
            } catch (InputMismatchException e) {
                System.out.println("Debes escribir un numero");
                sn.next();
            }
 
        }
 
        System.out.println("Fin del menu");
 
    }
 
    /**
     * Rellena la matriz con un numero
     * @param matriz
     * @param num 
     */
    public static void rellenarMatriz(int[][] matriz, int num) {
 
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = num;
            }
        }
 
    }
 
    /**
     * Pide una cadena
     * @param mensaje
     * @return 
     */
    public static String pedirCadena(String mensaje) {
 
        System.out.println(mensaje);
        String cadena = sn.next();
 
        return cadena;
 
    }
 
    /**
     * Pide un integer
     * @param mensaje
     * @return 
     */
    public static int pedirInteger(String mensaje) {
 
        System.out.println(mensaje);
        int numero = sn.nextInt();
 
        return numero;
 
    }
 
    /**
     * Valida si una posicion es correcta
     * @param matriz
     * @param pos
     * @return 
     */
    public static boolean validarPos(String[][] matriz, String pos) {
 
        if (pos.length() != 2) {
            return false;
        }
 
        if (!(esNumero(pos.substring(0, 1)) && esNumero(pos.substring(1, 2)))) {
            return false;
        }
 
        int fila = extraerNumero(pos, 0);
        int columna = extraerNumero(pos, 1);
 
        if (!((fila >= 0 && fila < matriz.length) && (columna >= 0 && columna < matriz[0].length))) {
            return false;
        }
 
        return true;
 
    }
 
    /**
     * Indico si un String es un numero
     * @param num
     * @return 
     */
    public static boolean esNumero(String num) {
 
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
 
    }
 
    /**
     * Extraigo el numero, -1 si ha habido un error
     * @param numero
     * @param pos
     * @return 
     */
    public static int extraerNumero(String numero, int pos) {
 
        int num = -1;
        if (esNumero(numero)) {
            num = Integer.parseInt(numero.substring(pos, pos + 1));
        }
 
        return num;
 
    }
 
    /**
     * Reduce la cantidad de una posicion en concreto
     * @param matriz
     * @param fila
     * @param columna
     * @param cantidad 
     */
    public static void reducirPosicion(int[][] matriz, int fila, int columna, int cantidad) {
        matriz[fila][columna] -= cantidad;
    }
 
    /**
     * Indica si en una posicion hay un valor mayor que 0
     * @param matriz
     * @param fila
     * @param columna
     * @return 
     */
    public static boolean hayValorPosicion(int[][] matriz, int fila, int columna) {
        if (matriz[fila][columna] > 0) {
            return true;
        }
 
        return false;
    }
 
    /**
     * Muestra las golosinas
     * @param nombres
     * @param precios 
     */
    public static void mostrarGolosionas(String[][] nombres, double[][] precios) {
 
        for (int i = 0; i < nombres.length; i++) {
            for (int j = 0; j < nombres[i].length; j++) {
 
                System.out.println(i + "" + j + " " + nombres[i][j] + " " + precios[i][j]);
 
            }
        }
 
    }
 
    /**
     * Indica si dos cadenas son iguales
     * @param cadena1
     * @param cadena2
     * @return 
     */
    public static boolean cadenaIguales(String cadena1, String cadena2) {
 
        if (cadena1.equals(cadena2)) {
            return true;
        } else {
            return false;
        }
 
    }
 
    /**
     * Aumenta la cantidad de una posicion
     * @param matriz
     * @param fila
     * @param columna
     * @param cantidad 
     */
    public static void aumentarPosicion(int[][] matriz, int fila, int columna, int cantidad) {
        matriz[fila][columna] += cantidad;
    }
    
}
