package DiscoDuroDeRoer;

// Pedir al usuario que nos escriba frases de forma infinita hasta que insertemos una cadena vacia. Mostrar la cadena resultante
import java.util.Scanner;

public class EjerciciosBásicos_29 {

    public static void main(String[] args) {
        String frase="", texto;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce una frase, siguiente texto en blanco para salir.");
        texto = teclado.nextLine();
        
        while (!texto.isEmpty()) {
            frase = frase+" "+texto;
            System.out.println("Introduce una frase, siguiente texto en blanco para salir");
            texto = teclado.nextLine();
            
        }

        System.out.println(frase);

    }

}
