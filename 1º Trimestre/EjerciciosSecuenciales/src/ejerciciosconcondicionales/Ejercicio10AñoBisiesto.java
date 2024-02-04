package ejerciciosconcondicionales;

import funciones.LeerDatosTeclado;
import funciones.Operaciones;
import java.util.Scanner;

public class Ejercicio10AñoBisiesto {
    public static void main(String[] args) {
        int año;
        
            Scanner teclado = new Scanner(System.in);

            System.out.println("Bienvenido al programa para saber si un año es bisiesto o no");
            System.out.println("--------------------------------------------------------");
            año = LeerDatosTeclado.leerIntSinNeg("Introduce un año: ",-1);
            
            boolean resultado = Operaciones.esBisiesto(año);
            
    }
}
