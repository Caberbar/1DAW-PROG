package ejerciciosconcondicionales;

import funciones.LeerDatosTeclado;
import java.util.Scanner;

public class Ejercicio07Ordenar3 {
    public static void main(String[] args) {
        int n1, n2, n3;
        
            Scanner teclado = new Scanner(System.in);

            System.out.println("Bienvenido al programa para ordenar tres números");
            System.out.println("--------------------------------------------------------");
            n1 = LeerDatosTeclado.leerInt("Introduce el primer número: ");
            n2 = LeerDatosTeclado.leerInt("Introduce el segundo número: ");
            n3 = LeerDatosTeclado.leerInt("Introduce el tercer número: ");
            
            if (n1 >= n2 && n1 >= n3 && n2 >= n3) {
                System.out.println("El orden es "+n1+" "+n2+" "+n3);
            }else if (n1 >= n2 && n1 >= n3 && n3 >= n2) {
                System.out.println("El orden es "+n1+" "+n3+" "+n2);
            }else if (n2 >= n1 && n2 >= n3 && n1 >= n3) {
                System.out.println("El orden es "+n2+" "+n1+" "+n3);
            }else if (n2 >= n1 && n2 >= n3 && n3 >= n1) {
                System.out.println("El orden es "+n2+" "+n3+" "+n1);
            }else if (n3 >= n2 && n3 >= n1 && n1 >= n2) {
                System.out.println("El orden es "+n3+" "+n1+" "+n2);
            }else if (n3 >= n2 && n3 >= n1 && n2 >= n1) {
                System.out.println("El orden es "+n3+" "+n2+" "+n1);
            } else {
                System.out.println("Introduce valores validos");
            }
    }
}
