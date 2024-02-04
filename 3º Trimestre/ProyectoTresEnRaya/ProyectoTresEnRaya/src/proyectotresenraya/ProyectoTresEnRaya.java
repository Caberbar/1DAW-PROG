package proyectotresenraya;

public class ProyectoTresEnRaya {

    static final int FICHA_O = 1;
    static final int FICHA_X = 2;
    static final int CASILLA_VACIA = 0;

    public static void main(String[] args) {
        int[][] tablero = new int[3][3];

        System.out.println("BIENVENIDO AL JUEGO DE LAS TRES EN RAYA");
        System.out.println("Desarrollado por José L. Berenguel");
        System.out.println("IES Zaidín Vergeles");
        System.out.println("Ciclo Formativo de Desarrollo de Aplicaciones Web");
        System.out.println("(c) 2021");
        System.out.println("-------------------------------------------------");
        System.out.println("Comienza el juego");

        String nombreJugador1 = LeerDatosTeclado.leerString("Introduzca su nombre Jugador 1: ");
        String nombreJugador2 = LeerDatosTeclado.leerString("Introduzca su nombre Jugador 2: ");

        int turno = 0;
        String jugadorActual;
        int fichaActual;
        int fila, columna;
        boolean fichaColocada, juegoTerminado, hayGanador;

        //BUCLE PRINCIPAL DEL JUEGO 
        mostrarTablero(tablero);
        do {

            // ACTUALIZO LAS VARIABLES DEL TURNO
            if (turno % 2 == 0) {
                jugadorActual = nombreJugador1;
                fichaActual = FICHA_O;
            } else {
                jugadorActual = nombreJugador2;
                fichaActual = FICHA_X;
            }

            System.out.println("Turno de " + jugadorActual);

            // PIDO LAS COORDENADAS AL USUARIO Y COLOCO LA FICHA
            do {
                fila = LeerDatosTeclado.leerEntero("Introduzca la fila [1,3]", 1, 3) - 1;
                columna = LeerDatosTeclado.leerEntero("Introduzca la columna [1,3]", 1, 3) - 1;

                fichaColocada = colocarFicha(tablero, fichaActual, fila, columna);
                if (!fichaColocada) {
                    System.out.println("La casilla ya está ocupada, por favor introduzca otra");
                }
            } while (!fichaColocada);
            mostrarTablero(tablero);

            //COMPRUEBO SI EL JUEGO TERMINA O GANA EL JUGADOR ACTUAL
            hayGanador = hayGanador(tablero);
            juegoTerminado = juegoTerminado(tablero);

            if (hayGanador) {
                System.out.println("¡ENHORABUENA " + jugadorActual + ". Has ganado la partida");
            } else if (juegoTerminado) {
                System.out.println("La partida ha terminado en tablas");
            } else {
                turno++;
            }

        } while (!juegoTerminado && !hayGanador);

    }

    public static void mostrarTablero(int[][] tablero) {
        System.out.print("\n");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("+---+---+---+\n|");
            for (int j = 0; j < tablero[i].length; j++) {
                char ficha = ' ';
                switch (tablero[i][j]) {
                    case CASILLA_VACIA:
                        ficha = ' ';
                        break;
                    case FICHA_O:
                        ficha = 'O';
                        break;
                    case FICHA_X:
                        ficha = 'X';
                        break;
                }
                System.out.print(" " + ficha + " |");
            }
            System.out.print(" " + (i + 1) + "\n");
        }
        System.out.print("+---+---+---+\n");
        System.out.print("  1   2   3  \n");
    }

    public static boolean colocarFicha(int[][] tablero, int ficha, int x, int y) {

        boolean fichaColocada = false;
        if (ficha != FICHA_X && ficha != FICHA_O) {
            throw new IllegalArgumentException("Ficha no válida");
        }

        if (tablero.length != 3 || tablero[0].length != 3) {
            throw new IllegalArgumentException("Dimensiones del tablero no válido");
        }

        if (tablero[x][y] == CASILLA_VACIA) {
            tablero[x][y] = ficha;
            fichaColocada = true;
        }

        return fichaColocada;
    }

    public static boolean hayGanador(int[][] tablero) {

        return tresEnRayaHorizontal(tablero)
                || tresEnRayaVertical(tablero)
                || tresEnRayaDiagonal(tablero);

    }

    public static boolean juegoTerminado(int[][] tablero) {

        boolean juegoTerminado = true;

        for (int i = 0; i < tablero.length && juegoTerminado; i++) {
            for (int j = 0; j < tablero.length && juegoTerminado; j++) {
                if (tablero[i][j] == CASILLA_VACIA) {
                    juegoTerminado = false;
                }
            }
        }

        return juegoTerminado;
    }

    private static boolean tresEnRayaHorizontal(int[][] tablero) {
        boolean tresEnRaya = false;
        for (int i = 0; i < tablero.length && !tresEnRaya; i++) {
            tresEnRaya = (tablero[i][0] == tablero[i][1]
                    && tablero[i][1] == tablero[i][2]
                    && tablero[i][0] != CASILLA_VACIA);
        }

        return tresEnRaya;
    }

    private static boolean tresEnRayaVertical(int[][] tablero) {
        boolean tresEnRaya = false;
        for (int i = 0; i < tablero.length && !tresEnRaya; i++) {
            tresEnRaya = (tablero[0][i] == tablero[1][i]
                    && tablero[1][i] == tablero[2][i]
                    && tablero[0][i] != CASILLA_VACIA);
        }

        return tresEnRaya;
    }

    private static boolean tresEnRayaDiagonal(int[][] tablero) {
        boolean tresEnRaya=false;

        //Diagonal izquierda-derecha
        int posicion = tablero[0][0];
        if (posicion != CASILLA_VACIA) {
            tresEnRaya = true;
            for (int i = 1; i < tablero.length && posicion != CASILLA_VACIA && tresEnRaya; i++) {
                if (posicion != tablero[i][i]) {
                    tresEnRaya = false;
                }
            }

        }
        
        //Diagonal derecha-izquierda
        posicion = tablero[0][2];
        if (!tresEnRaya && posicion != CASILLA_VACIA) {
            tresEnRaya = true;
            
            for (int i = 1, j = 1; i < tablero.length && posicion != CASILLA_VACIA && tresEnRaya; i++, j--) {
                if (posicion != tablero[i][j]) {
                    tresEnRaya = false;
                }
            }
        }

        return tresEnRaya;
    }
}
