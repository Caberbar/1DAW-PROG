package ejerciciosconbucles;

import funciones.LeerDatosTeclado;
import funciones.Operaciones;
import java.util.Scanner;


public class Ejercicio25LlamadaTelefonica {
    public static void main(String[] args) {
        int segundos;
        
            Scanner teclado = new Scanner(System.in);

            System.out.println("Bienvenido al programa para saber cuanto cuesta una llamada");
            System.out.println("--------------------------------------------------------");
            segundos = LeerDatosTeclado.leerIntSinNeg("Introduce los segundos que has hablado: ",-1);
            
            boolean resultado = Operaciones.costeLLamadaTelefonica(segundos);
    }
}
