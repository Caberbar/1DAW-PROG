package DiscoDuroDeRoer;

// Muestra los números primos entre 1 y 100.
public class EjerciciosBásicos_21 {

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            int contador = 0;
            for (int j = i; j >= 1; j--) {
                if (i % j == 0) {
                    contador = contador + 1;
                }
            }
            if (contador == 2) {
                System.out.print(i+" ");
            }
        }
    }
}

