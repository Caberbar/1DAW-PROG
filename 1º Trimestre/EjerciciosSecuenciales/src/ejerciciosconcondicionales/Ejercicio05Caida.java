package ejerciciosconcondicionales;

import funciones.LeerDatosTeclado;
import funciones.Operaciones;
import java.util.Scanner;

public class Ejercicio05Caida {
    public static void main(String[] args) {
        double h, tiempo;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido al programa de ecuación de timepo de caida");
        System.out.println("--------------------------------------------------------");
        h = LeerDatosTeclado.leerDoubleSinNeg("Introduce la altura: ",0);
        
        tiempo = Operaciones.tiempoCaida(h);
        System.out.println("El tiempo que tardara es: "+tiempo);
    }
}
