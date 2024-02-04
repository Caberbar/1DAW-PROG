package ejerciciosconbucles;

import funciones.LeerDatosTeclado;
import funciones.Operaciones;
import java.util.Scanner;

public class Ejercicio29Cambiardigito {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido al programa para cambiar un dígito de un numero");
        System.out.println("--------------------------------------------------------");
        
        long numeroIntroducido = LeerDatosTeclado.leerLongSinNeg("Por favor, introduzca un número entero positivo: ",-1);

        long cifras = Operaciones.digitos(numeroIntroducido);
        
        long posicion = LeerDatosTeclado.leerLongSinNegConMax("Introduzca la posición dentro del número: ",0,cifras+1);

        long digito = LeerDatosTeclado.leerLongSinNeg("Introduzca el nuevo dígito: ",-1);

        long numero = numeroIntroducido;

        // calcula la longitud del número
        int longitud = 0;

        do {
            numero /= 10;
            longitud++;
        } while (numero > 0);

        // parte izquierda con el dígito nuevo
        long parteIzquierda = numeroIntroducido / (long) (Math.pow(10, longitud - posicion + 1));
        parteIzquierda = parteIzquierda * 10 + digito;

        // parte derecha
        long parteDerecha = numeroIntroducido % (long) (Math.pow(10, longitud - posicion));

        // resultado
        numero = parteIzquierda * (long) (Math.pow(10, longitud - posicion)) + parteDerecha;
        System.out.print("El número resultante es " + numero);
        System.out.println("");
    }
}

