package ejerciciosconbucles;

import funciones.LeerDatosTeclado;
import funciones.Operaciones;
import java.util.Scanner;


public class Ejercicio28ConversorDigitoPalotes {
    public static void main(String[] args) {
        int digito;
        
            Scanner teclado = new Scanner(System.in);

            System.out.println("Bienvenido al programa para pasar de deciaml a palotes");
            System.out.println("--------------------------------------------------------");
            digito = LeerDatosTeclado.leerIntSinNeg("Introduce un número: ",-1);
            
            System.out.println(Operaciones.conversorDigitoPalotes(digito));
            
    }
}
