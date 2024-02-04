package funciones;

import java.util.Scanner;
import juegopente.JuegoPente;

public class Funciones {


    //Función de dibujar el tablero por pantalla

    //Visualizará el tablero en pantalla de forma apropiada para que el usuario
    //lo entienda. Habrá que escribir O o X para representar las fichas de los
    //jugadores, en lugar de valores numéricos.
    public static void mostrarTablero(int [][] tablero) {

        System.out.println();
        System.out.println();
        System.out.print("\t");


        //nº de columnas
        for(int i=1;i<=tablero.length-1;i++){
            System.out.print(i + "\t");
            if(i==tablero.length-1){
                System.out.println();
            }
        }

        //nº de filas
        for(int i=1; i<=tablero.length-1; i++){

            if(i!=tablero.length-1){
                System.out.print("");
            }
            System.out.print(i + "\t");

            //relleno de los huecos
            for(int j=1; j<=tablero.length-1; j++){
                System.out.print("·\t");
            }
            System.out.println();
        }

    }


    //Igual que la función anterior, pero además recibe por parámetro la
    //posición de la última ficha colocada para poder mostrarla de forma resaltada.
    public static void mostrarTablero(int [][] tablero, int fila, int columna){
        System.out.println();
        System.out.println();
        System.out.print("\t");



        //nº de columnas
        for(int i=1;i<=tablero.length-1;i++){
            System.out.print(i + "\t");
        }
        System.out.println();

        //nº de filas
        for(int i=1; i<tablero.length; i++){
            System.out.print(i + "\t");

            //relleno de los huecos

            for(int j=1; j<tablero.length; j++){

                switch (tablero[i][j]) {
                    case JuegoPente.FICHA_CIRCULO:
                        if (tablero[i][j] == JuegoPente.FICHA_CIRCULO && i == fila && j == columna) {
                            System.out.print("\033[31mO\033[30m \t");
                        } else if (tablero[i][j] == JuegoPente.FICHA_CIRCULO) {
                            System.out.print("O\t");
                        }
                        break;
                    case JuegoPente.FICHA_EQUIS:
                        if (tablero[i][j] == JuegoPente.FICHA_EQUIS && i == fila && j == columna) {
                            System.out.print("\033[36mX\033[30m \t");
                        } else if (tablero[i][j] == JuegoPente.FICHA_EQUIS) {
                            System.out.print("X\t");
                        }

                        break;
                    case JuegoPente.CASILLA_VACIA:
                        if (tablero[i][j] == JuegoPente.CASILLA_VACIA && i == fila && j == columna) {
                            System.out.print("·\t");
                        }
                    default:
                        System.out.print("·\t");
                }

            }
            System.out.println();
        }
    }


    //Coloca la ficha en la posición indicada por las coordenadas (fila, columna.
    //Devuelve true si ha habido éxito y false si no.
    public static boolean colocarFicha(int [][] tablero, int ficha, int fila, int columna){

        boolean valor = false;
        if(tablero[fila][columna]==JuegoPente.CASILLA_VACIA){
            tablero[fila][columna] = ficha;
            valor = true;
        }else {
            System.out.println();
            System.out.println("La casilla está llena");
            System.out.println("Vuelvo a introducir valores válidos");
            System.out.println();
        }
        return valor;
    }


    //Comprueba si en la última posición donde se ha colocado una ficha se
    //pueden realizar capturas. En caso afirmativo, elimina las fichas capturadas
    //del tablero y devuelve el número de fichas capturadas.
    public static int capturarFichas(int [][] tablero, int fila, int columna){

        int ficha = cambioficha(tablero[fila][columna]);
        int capturadas=0;

        //Fichas arriba
        if (posicion(tablero, fila - 3, columna) && tablero[fila - 1][columna] == ficha && tablero[fila - 2][columna] == ficha && tablero[fila - 3][columna] == tablero[fila][columna]) {
            capturadas = 2;
            tablero[fila - 1][columna] = JuegoPente.CASILLA_VACIA;
            tablero[fila - 2][columna] = JuegoPente.CASILLA_VACIA;
        }
        //Fichas Abajo
        if(posicion(tablero,fila+3,columna) && tablero[fila+1][columna]==ficha && tablero[fila+2][columna]==ficha && tablero[fila+3][columna]==tablero[fila][columna]){
            capturadas = 2;
            tablero[fila+1][columna]=JuegoPente.CASILLA_VACIA;
            tablero[fila+2][columna]=JuegoPente.CASILLA_VACIA;
        }
        //Derecha
        if (posicion(tablero, fila, columna + 3) && tablero[fila][columna + 1] == ficha && tablero[fila][columna + 2] == ficha && tablero[fila][columna + 3] == tablero[fila][columna]) {
            capturadas = 2;
            tablero[fila][columna + 1] = JuegoPente.CASILLA_VACIA;
            tablero[fila][columna + 2] = JuegoPente.CASILLA_VACIA;
        }
        //Izquierda
        if (posicion(tablero, fila, columna - 3) && tablero[fila][columna - 1] == ficha && tablero[fila][columna - 2] == ficha && tablero[fila][columna - 3] == tablero[fila][columna]) {
            capturadas = 2;
            tablero[fila][columna - 1] = JuegoPente.CASILLA_VACIA;
            tablero[fila][columna - 2] = JuegoPente.CASILLA_VACIA;
        }
        //Arriba Izquierda
        if (posicion(tablero, fila - 3, columna - 3) && tablero[fila - 1][columna - 1] == ficha && tablero[fila - 2][columna - 2] == ficha && tablero[fila - 3][columna - 3] == tablero[fila][columna]) {
            capturadas = 2;
            tablero[fila - 1][columna - 1] = JuegoPente.CASILLA_VACIA;
            tablero[fila - 2][columna - 2] = JuegoPente.CASILLA_VACIA;
        }

        //Arriba derecha
        if (posicion(tablero, fila - 3, columna + 3) && tablero[fila - 1][columna + 1] == ficha && tablero[fila - 2][columna + 2] == ficha && tablero[fila - 3][columna + 3] == tablero[fila][columna]) {
            capturadas = 2;
            tablero[fila - 1][columna + 1] = JuegoPente.CASILLA_VACIA;
            tablero[fila - 2][columna + 2] = JuegoPente.CASILLA_VACIA;
        }

        //Abajo Izquierda
        if (posicion(tablero, fila + 3, columna - 3) && tablero[fila + 1][columna - 1] == ficha && tablero[fila + 2][columna - 2] == ficha && tablero[fila + 3][columna - 3] == tablero[fila][columna]) {
            capturadas = 2;
            tablero[fila + 1][columna - 1] = JuegoPente.CASILLA_VACIA;
            tablero[fila + 2][columna - 2] = JuegoPente.CASILLA_VACIA;
        }

        //Abajo Derecha
        if (posicion(tablero, fila + 3, columna + 3) && tablero[fila + 1][columna + 1] == ficha && tablero[fila + 2][columna + 2] == ficha && tablero[fila + 3][columna + 3] == tablero[fila][columna]) {
            capturadas = 2;
            tablero[fila + 1][columna + 1] = JuegoPente.CASILLA_VACIA;
            tablero[fila + 2][columna + 2] = JuegoPente.CASILLA_VACIA;
        }
        return capturadas;
    }

    
    //Comprobar que no se sale del tablero
    public static boolean posicion(int[][] tablero, int fila, int columna) {
        boolean posicion = false;
        if (fila >= 0 && columna >= 0 && fila < tablero.length && columna < tablero[fila].length) {posicion = true;}
        return posicion;
    }



    //Devuelve true si en el tablero hay cinco fichas en línea
    //(horizontal, vertical o diagonal), false en caso contrario. La comprobación
    //se realizará desde la posición de la última ficha colocada.
    public static boolean comprobarLinea(int [][] tablero, int fila, int columna){

        int Horizontal=-1;
        int Vertical=1;
        int Abajo=0;
        int Arriba = 1;
        int Arriba2 = -1;

        //(Hacia la izquierda)
        while(posicion(tablero, fila, columna+1) && tablero[fila][columna]==tablero[fila][columna+1]){
            Horizontal++;
            columna++;
        }
        Horizontal=1;
        //(Hacia la derecha)
        while(posicion(tablero, fila, columna-1) && tablero[fila][columna]==tablero[fila][columna-1]){
            Horizontal++;
            columna--;
        }
        //(Hacia arriba)
        while(posicion(tablero, fila+3, columna) && tablero[fila][columna]==tablero[fila+3][columna]){
            Vertical++;
            fila++;
        }
        //(Hacia abajo)
        while(posicion(tablero, fila-1, columna) && tablero[fila][columna]==tablero[fila-1][columna]){
            Vertical++;
            fila--;
        }
        //(Desde arriba hacia abajo derecha)
        while(posicion(tablero, fila+1, columna+1) && tablero[fila][columna]==tablero[fila+1][columna+1]){
            Abajo++;
            fila++;
            columna++;
        }
        Abajo=1;
        //(Desde abajo hacia arriba izquierda)
        while(posicion(tablero, fila-1, columna-1) && tablero[fila][columna]==tablero[fila-1][columna-1]){
            Abajo++;
            fila--;
            columna--;
        }
        
        //(Desde arriba hacia abajo izquierda)
        while (posicion(tablero, fila-1, columna+1) && tablero[fila][columna] == tablero[fila - 1][columna + 1]) {
            Arriba2++;
            fila--;
            columna++;
        }
        //(Desde abajo hacia arriba derecha) - CLASE
            while (posicion(tablero, fila+1, columna-1) && tablero[fila][columna] == tablero[fila + 1][columna - 1]) {
                Arriba++;
                fila++;
                columna--;
            }
        
        if(Horizontal >= 5 || Vertical >= 5 || Arriba >= 5 || Abajo >= 5 || Arriba2 >= 5){
            System.out.println("HAS GANADO \033[35mCONECTASTES 5\u001B[0m");
            return true;
        }
        return false;
    }


    //Devuelve true si en el tablero hay alguna casilla libre, o false si el tablero está completo.
    public static boolean casillasLibres(int[][] tablero) {
        for (int i = 1; i < tablero.length; i++) {
            for (int j = 1; j < tablero[0].length; j++) {
                if (tablero[i][j] == JuegoPente.CASILLA_VACIA) {
                    return false;
                }
            }
        }
        System.out.println("EMPATE");
        System.out.println("EL TABLERO SE HA LLENADO");
        return true;
    }


    //iremos haciendo el cambio de ficha aquí.
    public static int cambioficha(int ficha) {
        if(ficha == JuegoPente.FICHA_CIRCULO){
           ficha = JuegoPente.FICHA_EQUIS;
        }else if(ficha == JuegoPente.FICHA_EQUIS){
           ficha = JuegoPente.FICHA_CIRCULO;
        }
       return ficha;
    }
}







