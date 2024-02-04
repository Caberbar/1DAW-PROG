package bingo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bingo {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int numJugadores;
        do {
            System.out.print("¿Cuántos jugadores habrá? (2-6): ");
            numJugadores = teclado.nextInt();
        } while (numJugadores < 2 || numJugadores > 6);

        ArrayList<Carton> cartones = generarCartones(numJugadores);
        mostrarCartones(cartones);

        Random numero = new Random();

        ArrayList<Integer> bolas = new ArrayList<>();

        int bola;

        while (!cantarBingo(cartones)) {
            bola = numero.nextInt(50) + 1;
            System.out.println("Bola sacada: " + bola);
            bolas.add(bola);

            for (Carton carton : cartones) {
                if (carton.marcarCasilla(bola)) {
                    System.out.println("Carton marcado:");
                    System.out.println(carton);
                }
            }

            if (cantarFila(cartones)) {
                System.out.println("¡Fila cantada!");
            }
        }
        System.out.println("¡BINGO!");
    }

    private static ArrayList<Carton> generarCartones(int numJugadores) {
        ArrayList<Carton> cartones = new ArrayList<>();
        for (int i = 0; i < numJugadores; i++) {
            cartones.add(new Carton());
        }
        return cartones;
    }

    private static void mostrarCartones(ArrayList<Carton> cartones) {
        System.out.println("Cartones generados: ");
        for (Carton carton : cartones) {
            System.out.println(carton);
        }
    }

    private static boolean cantarFila(ArrayList<Carton> cartones) {
        boolean cantado = false;
        for (Carton carton : cartones) {
            if (carton.cantarFila()) {
                cantado = true;
            }
        }
        return cantado;
    }

    private static boolean cantarBingo(ArrayList<Carton> cartones) {
        boolean cantado = false;
        for (Carton carton : cartones) {
            if (carton.cantarBingo()) {
                cantado = true;
            }
        }
        return cantado;
    }

}
