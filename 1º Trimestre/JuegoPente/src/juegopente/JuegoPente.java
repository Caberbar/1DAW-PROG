package juegopente;

import funciones.Funciones;
import funciones.LeerDatosTeclado;
import java.util.Scanner;

/**
 * @author Carlos Bernal Barrionuevo
 **/
public class JuegoPente {

    public static void main(String[] args) {
        
        /* VARIABLES */
        
        int tablero[][];
        int tamaño;
        int fila;
        int columna;
        
        String Jugador1;
        String Jugador2;
        
        boolean esValido = false;
        boolean enFila = false;
        boolean Libre = false;
        
        int Numcapturas;
        int capturas;
        int capturadas1 = 0;
        int capturadas2 = 0;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("-------------------------\n\tBIENVENID@\n-------------------------\n");
        
        //Pedimos al usuario el tamaño del tablero y el nº de fichas capturadas
        tamaño = LeerDatosTeclado.leerIntSinNegConMax("Introduce el tamaño del tablero: ",9,20)+1;
        Numcapturas = LeerDatosTeclado.leerIntSinNegConMax("Introduce el numero de capturas para ganar: ",4,11);
        
        System.out.println();
        System.out.println();
        
        //Los jugadores introducen sus nombres
        System.out.println("Jugador 1 introduce tu nombre: ");
        Jugador1 = teclado.nextLine(); 
        System.out.println("Jugador 2 introduce tu nombre: ");
        Jugador2 = teclado.nextLine();
        
        //Se muestra el tablero
        tablero = new int [tamaño][tamaño];
        Funciones.mostrarTablero(tablero);
        
        System.out.println();
        
        do {
                System.out.println();
                System.out.println("Te toca " + Jugador1);
                
                do {
                    fila = LeerDatosTeclado.leerIntSinNegConMax("Introduce la fila: ", 0, tamaño);
                    columna = LeerDatosTeclado.leerIntSinNegConMax("Introduce la columna: ", 0, tamaño);
                    esValido = Funciones.colocarFicha(tablero,FICHA_EQUIS,fila,columna);
                } while(esValido == false);
                Funciones.mostrarTablero(tablero,fila,columna);
                capturas = Funciones.capturarFichas(tablero, fila, columna);
                System.out.println();
                System.out.println(Jugador2+" Has capturado "+capturadas2 );
                if (capturas != 0){
                    if (tablero[fila][columna] == FICHA_EQUIS){
                        capturadas1 = capturadas1 + capturas;
                        if (capturadas1 >= Numcapturas){
                            System.out.println("\033[35mENHORABUENA\u001B[0m "+Jugador1+" \033[35mHAS GANADO, HAS CAPTURADO\u001B[0m"+capturadas1);
                        break;
                        }
                    }
                }
                enFila = Funciones.comprobarLinea(tablero, fila, columna);if(enFila == true){break;}
                Libre = Funciones.casillasLibres(tablero); if(Libre == true){break;}            
                
                System.out.println();
                System.out.println("Te toca " + Jugador2);
                
                do {
                    fila = LeerDatosTeclado.leerIntSinNegConMax("Introduce la fila: ", 0, tamaño);
                    columna = LeerDatosTeclado.leerIntSinNegConMax ("Introduce la columna: ",0,tamaño);
                    esValido = Funciones.colocarFicha(tablero,FICHA_CIRCULO,fila,columna);
                } while(esValido == false);
                Funciones.mostrarTablero(tablero,fila,columna);
                capturas = Funciones.capturarFichas(tablero, fila, columna);
                System.out.println();
                System.out.println(Jugador1+" Has capturado "+capturadas1 );
                if (capturas != 0){
                    if (tablero[fila][columna] == FICHA_CIRCULO){
                        capturadas2 = capturadas2 + capturas;
                        if (capturadas2 >= Numcapturas){
                            System.out.println("\033[35mENHORABUENA\u001B[0m "+Jugador2+" \033[35mHAS GANADO, HAS CAPTURADO\u001B[0m"+capturadas1);
                        break;
                        }
                        
                    }
                }
                enFila = Funciones.comprobarLinea(tablero, fila, columna);if(enFila == true){break;}
                Libre = Funciones.casillasLibres(tablero);if(Libre == true){break;}

        } while (!Libre && !enFila);
    }
    
    public static final int CASILLA_VACIA=0;
    public static final int FICHA_CIRCULO=1;
    public static final int FICHA_EQUIS=2;
}

    
