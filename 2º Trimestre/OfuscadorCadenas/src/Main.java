
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author DAW-B
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int numero;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduzca un mensaje: ");
        String mensaje = teclado.nextLine();

        do{
            System.out.println("Introduzca un numero aleatorio positivo: ");
            numero = teclado.nextInt();
        }while(numero < 0);

        System.out.println(ofuscar(mensaje, numero));
        String nuevo_mensaje = ofuscar(mensaje, numero);
        System.out.println(desofuscar(nuevo_mensaje,numero));
    }

    /**
     *
     * @param mensaje
     * @param n
     * @return
     */
    public static String ofuscar(String mensaje, int n) {
        String ofuscado = "";
        String cadena = ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890/*-+.'¡´{}()/&%$<>");
        int indice = n;

        for (int i = 0; i < mensaje.length(); i++) {
            ofuscado += mensaje.substring(i, i + 1);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    indice = ((int) Math.floor(Math.random() * (0 - cadena.length()) + cadena.length()));
                }
                ofuscado += cadena.substring(indice, indice + 1);
            }
        }
        return ofuscado;
    }
    
    /**
     *
     * @param mensaje
     * @param n
     * @return
     */
    public static String desofuscar(String mensaje, int n) {
        String desofuscar = "";

        for (int i = 0; i < mensaje.length();) {
            desofuscar += mensaje.substring(i, i + 1);
            i+=n+1;
        }
        return desofuscar;
    }

}
