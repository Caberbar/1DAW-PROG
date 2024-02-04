/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;

import java.util.Scanner;

/**
 *
 * @author Tarde
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static final int CASILLA_VACIA=0;
    public static final int FICHA_CIRCULO=1;
    public static final int FICHA_EQUIS=2;
    
    public static void mostrarTablero(int [][]tablero){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println("");
        }
 
    }
    
    public static void main(String[] args) {      
        
        
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce el numero de filas del tablero: ");
        int filas = sc.nextInt();
        while (filas < 10 || filas > 19){
            System.out.println("Error. Numero de filas incorrectas.");
            System.out.println("Introduce el numero de filas del tablero: ");
            filas=sc.nextInt();
        }
        
        System.out.println("Introduce el numero de columnas del tablero: ");
        int columnas = sc.nextInt();
        while(columnas < 10 || columnas > 19){
            System.out.println("Error. Numero de columnas incorrectas.");
            System.out.println("Introduce el numero de columnas del tablero: ");
            columnas = sc.nextInt();
        }
        
        int tablero[][]= new int [filas][columnas];
        
        System.out.println("Introduce el numero de fichas capturadas con el que se gana la partida: ");
        int fichas = sc.nextInt();
        while(fichas < 5 || fichas > 10){
            System.out.println("Error. Numero de fichas incorrectas.");
            System.out.println("Introduce el numero de fichas del tablero: ");
            fichas = sc.nextInt();
        }
            
        System.out.println("Introduce el nombre del jugador 1: ");
        String jugador1 =sc.nextLine();
        
        sc.nextLine();
        
        System.out.println("Introduce el nombre del jugador 2: ");
        String jugador2 =sc.nextLine();
        
        do{
            String jugada=jugador1;
            System.out.println("Turno de " + jugada);
            
            System.out.println("Introduce la fila en la que deseas introducir la ficha: ");
            int filajuego = sc.nextInt();
            
            System.out.println("Introduce la columna en la que deseas introducir la ficha: ");
            int columnajuego = sc.nextInt();
            
            mostrarTablero(tablero);
            
            if(jugada==jugador1){
                jugada=jugador2;
            }
            columnas++;
        }while(columnas>10);
        
        
    }
    
}
