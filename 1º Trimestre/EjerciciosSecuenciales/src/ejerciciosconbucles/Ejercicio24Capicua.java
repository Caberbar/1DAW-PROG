package ejerciciosconbucles;

import funciones.LeerDatosTeclado;
import funciones.Operaciones;
import java.util.Scanner;

public class Ejercicio24Capicua {
    public static void main(String[] args) {
        int numero;
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("Bienvenido al programa para saber si un numero es capicua");
        System.out.println("--------------------------------------------------------");
        numero = LeerDatosTeclado.leerIntSinNeg("Introduce un numero: ",-1);
            
        boolean capicua = Operaciones.esCapicua(numero);
            
    }
}
