package ejerciciossecuenciales;

import funciones.LeerDatosTeclado;
import java.util.Scanner;

public class Ejercicio06SalarioSemanal {
    
    
    public static void main(String[] args) {
        int horas;
        double salario;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido al programa de salario ");
        System.out.println("--------------------------------------------------------");
        System.out.println("Introduce las horas trabajadas: ");
        horas = LeerDatosTeclado.leerIntSinNeg("Introduce las horas trabajadas: ", 0);
        
        salario = horas*12;
       
        System.out.println("Tu salario por "+horas+" horas trabajadas es: "+salario);
    }
}
