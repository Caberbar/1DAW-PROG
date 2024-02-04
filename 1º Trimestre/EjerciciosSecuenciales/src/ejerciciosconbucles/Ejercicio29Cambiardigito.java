package ejerciciosconbucles;

import funciones.LeerDatosTeclado;
import funciones.Operaciones;
import java.util.Scanner;

public class Ejercicio29Cambiardigito {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido al programa para cambiar un d�gito de un numero");
        System.out.println("--------------------------------------------------------");
        
        long numeroIntroducido = LeerDatosTeclado.leerLongSinNeg("Por favor, introduzca un n�mero entero positivo: ",-1);

        long cifras = Operaciones.digitos(numeroIntroducido);
        
        long posicion = LeerDatosTeclado.leerLongSinNegConMax("Introduzca la posici�n dentro del n�mero: ",0,cifras+1);

        long digito = LeerDatosTeclado.leerLongSinNeg("Introduzca el nuevo d�gito: ",-1);

        long numero = numeroIntroducido;

        // calcula la longitud del n�mero
        int longitud = 0;

        do {
            numero /= 10;
            longitud++;
        } while (numero > 0);

        // parte izquierda con el d�gito nuevo
        long parteIzquierda = numeroIntroducido / (long) (Math.pow(10, longitud - posicion + 1));
        parteIzquierda = parteIzquierda * 10 + digito;

        // parte derecha
        long parteDerecha = numeroIntroducido % (long) (Math.pow(10, longitud - posicion));

        // resultado
        numero = parteIzquierda * (long) (Math.pow(10, longitud - posicion)) + parteDerecha;
        System.out.print("El n�mero resultante es " + numero);
        System.out.println("");
    }
}

