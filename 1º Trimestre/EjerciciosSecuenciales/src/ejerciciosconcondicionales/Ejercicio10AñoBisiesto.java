package ejerciciosconcondicionales;

import funciones.LeerDatosTeclado;
import funciones.Operaciones;
import java.util.Scanner;

public class Ejercicio10A�oBisiesto {
    public static void main(String[] args) {
        int a�o;
        
            Scanner teclado = new Scanner(System.in);

            System.out.println("Bienvenido al programa para saber si un a�o es bisiesto o no");
            System.out.println("--------------------------------------------------------");
            a�o = LeerDatosTeclado.leerIntSinNeg("Introduce un a�o: ",-1);
            
            boolean resultado = Operaciones.esBisiesto(a�o);
            
    }
}
