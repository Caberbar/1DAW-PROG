package ejerciciosconbucles;

import funciones.LeerDatosTeclado;
import java.util.Scanner;

public class Ejercicio21CajaFuerte {

    public static void main(String[] args) {
        int numero, contador, intentos;
        boolean abierto;

        contador = 0;
        abierto = false;

        Scanner teclado = new Scanner(System.in);

        while (!(abierto && contador < 4)) {
            contador++;
            numero = LeerDatosTeclado.leerIntSinNeg("Introduzca el número secreto: ",0);
            if (contador == 5){
                break;
            }
            if (numero == 1234){
                abierto = true;
                System.out.println("Contraseña correcta");
                System.out.println("Abriendo caja fuerte");
            }else{ 
                intentos = 5 - contador;
                System.out.println("Contraseña incorrecta, te quedan "+intentos+" intentos");
            }
        }
    }
}
