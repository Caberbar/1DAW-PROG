package ejerciciosconcondicionales;

import funciones.LeerDatosTeclado;
import java.util.Scanner;

public class Ejercicio03SalarioSemanal {
    public static void main(String[] args) {
        int horas;
        double salario;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido al programa de salario");
        System.out.println("--------------------------------------------------------");
        horas = LeerDatosTeclado.leerIntSinNeg("Introduce las horas trabajadas: ", 0);
        
        if (horas > 40){
           salario = 4.80*(horas-40)*16;
        }else{
           salario = horas*12;     
        }
        
        System.out.println("Tu salario por haber trabajado "+horas+" es de: "+salario);
        
    }

}
