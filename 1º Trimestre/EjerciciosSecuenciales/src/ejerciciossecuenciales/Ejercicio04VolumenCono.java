package ejerciciossecuenciales;

import funciones.LeerDatosTeclado;
import funciones.Operaciones;
import java.util.Scanner;

public class Ejercicio04VolumenCono {
    public static void main(String [] args) {
        double radio, altura, volumen;
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido al programa de calcular el volumen de un cono");
        System.out.println("--------------------------------------------------------");
        radio = LeerDatosTeclado.leerDoubleSinNeg("Introduce el radio del cono: ",0);
        altura = LeerDatosTeclado.leerDoubleSinNeg("Introduce la altura del cono: ",0);
        
        volumen =Operaciones.volumenCono(radio,altura);
                
        System.out.println("El volumen del cono con radio "+radio+" y altura "+altura+" es: "+volumen);

    }
}
