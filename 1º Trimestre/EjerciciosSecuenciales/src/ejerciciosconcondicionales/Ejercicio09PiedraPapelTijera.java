package ejerciciosconcondicionales;

import java.util.Scanner;

public class Ejercicio09PiedraPapelTijera {
        public static void main(String[] args) {
            String jugador1, jugador2;
        
            Scanner teclado = new Scanner(System.in);

            System.out.println("Bienvenido al programa de piedra, papel o tijera");
            System.out.println("--------------------------------------------------------");
            System.out.println("Introduce tu opción jugador 1: ");
            jugador1 = teclado.nextLine();
            System.out.println("Introduce tu opción jugador 2: ");
            jugador2 = teclado.nextLine();
            
            if ((jugador1.equals("piedra")&&jugador2.equals("tijera")) || 
                (jugador1.equals("papel")&&jugador2.equals("piedra")) ||
                (jugador1.equals("tijera")&&jugador2.equals("papel"))) {
                System.out.println("Gana el jugador 1");
            } else if (jugador1.equals(jugador2)) {
                System.out.println("Empate");
            } else {
                System.out.println("Gana el jugador 2");
            }      
        }
}
