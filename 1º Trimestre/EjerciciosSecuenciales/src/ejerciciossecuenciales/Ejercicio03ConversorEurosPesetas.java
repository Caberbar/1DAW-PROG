package ejerciciossecuenciales;

import funciones.LeerDatosTeclado;
import java.util.Scanner;

public class Ejercicio03ConversorEurosPesetas {
    public static void main(String[] args) {
        double euros, pesetas;
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido al programa de cálculo de Euros/Pesetas");
        System.out.println("--------------------------------------------------------");
        euros = LeerDatosTeclado.leerDoubleSinNeg("Introduce una cantidad: ",0);
        
        pesetas = euros * 166.386;
        
        System.out.println("La cantidad "+euros+" euivale a "+pesetas+" pesetas.");
    }
}
