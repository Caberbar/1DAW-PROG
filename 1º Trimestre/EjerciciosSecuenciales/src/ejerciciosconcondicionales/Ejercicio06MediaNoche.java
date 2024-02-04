package ejerciciosconcondicionales;

import funciones.LeerDatosTeclado;
import java.util.Scanner;

public class Ejercicio06MediaNoche {
    public static void main(String[] args) {
        double horas, minutos, medianoche;
        
            Scanner teclado = new Scanner(System.in);

            System.out.println("Bienvenido al programa de timepo que queda hasta medianoche");
            System.out.println("--------------------------------------------------------");
            horas = LeerDatosTeclado.leerDoubleSinNegConMax("Introduce las horas: ",-1,24);
            minutos = LeerDatosTeclado.leerDoubleSinNegConMax("Introduce los minutos: ",-1,60);
            
            medianoche = (horas*3600)+(minutos*60);
            medianoche = (24*3600) - medianoche;
            System.out.println("Quedan "+medianoche+" segundos para que sea medianoche");
    }
}
