package prueba;


import java.util.Scanner;

/**
 * @author Carlos Bernal Barrionuevo
 **/
public class JuegoPente {

    public static void main(String[] args) {
        
        /* VARIABLES */
        
        int tablero[][];
        int capturas;
        int tamaño;
        int fila;
        int columna;
        
        String Jugador1;
        String Jugador2;
        boolean esValido;
        
        boolean turno = true;
        
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("-------------------------\n\tBIENVENID@\n-------------------------\n");
        
        //Pedimos al usuario el tamaño del tablero y el nº de fichas capturadas
        tamaño = LeerDatosTeclado.leerIntSinNegConMax("Introduce el tamaño del tablero: ",9,20)+1;
        //capturas = LeerDatosTeclado.leerIntSinNegConMax("Introduce el numero de capturas para ganar: ",4,11);
        
        System.out.println();
        System.out.println();
        
        //Los jugadores introducen sus nombres
//        System.out.println("Jugador 1 introduce tu nombre: ");
//        Jugador1 = teclado.nextLine(); 
//        System.out.println("Jugador 2 introduce tu nombre: ");
//        Jugador2 = teclado.nextLine();
        
        //Se muestra el tablero
        
        tablero = new int [tamaño][tamaño];
        Funciones.mostrarTablero(tablero);
        
        System.out.println();

        Jugador1 = "1";
        Jugador2 = "2";
        
        do {
            if (turno) {
                System.out.println();
                System.out.println("Te toca " + Jugador1);
                
                do {
                fila = LeerDatosTeclado.leerIntSinNegConMax("Introduce la fila: ", 0, tamaño);
                columna = LeerDatosTeclado.leerIntSinNegConMax("Introduce la columna: ", 0, tamaño);
                esValido = Funciones.colocarFicha(tablero,FICHA_EQUIS,fila,columna);
                } while(esValido == false);
                Funciones.mostrarTablero(tablero,fila,columna);
                Funciones.capturarFichas(tablero, fila, columna);
                //Funciones.comprobarLinea(tablero, fila, columna);
                Funciones.casillasLibres(tablero);
                turno = false;
                esValido = false;
            } else {
                System.out.println();
                System.out.println("Te toca " + Jugador2);
                
                do {
                fila = LeerDatosTeclado.leerIntSinNegConMax("Introduce la fila: ", 0, tamaño+1);
                columna = LeerDatosTeclado.leerIntSinNegConMax ("Introduce la columna: ",0,tamaño+1);
                esValido = Funciones.colocarFicha(tablero,FICHA_CIRCULO,fila,columna);
                } while(esValido == false);
                Funciones.mostrarTablero(tablero,fila,columna);
                Funciones.capturarFichas(tablero, fila, columna);
                Funciones.casillasLibres(tablero);
                turno = true;
                esValido = false;
            }

        } while (!esValido);
    }
    
    public static final int CASILLA_VACIA=0;
    public static final int FICHA_CIRCULO=1;
    public static final int FICHA_EQUIS=2;
}

    
