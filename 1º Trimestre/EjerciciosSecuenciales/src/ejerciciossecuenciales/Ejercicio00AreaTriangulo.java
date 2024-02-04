package ejerciciossecuenciales;

import funciones.Operaciones;
import funciones.LeerDatosTeclado;
import java.util.Scanner;

public class Ejercicio00AreaTriangulo {

    public static void main(String[] args) {
        double base, altura, area;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido al programa de c�lculo de �reas de triangulos");
        System.out.println("--------------------------------------------------------");
        
        base = LeerDatosTeclado.leerDoubleSinNeg("Introduce la base del tri�ngulo",0);
        altura = LeerDatosTeclado.leerDoubleSinNeg("Introduce la altura del tri�ngulo",0);
        
 
        
        area = Operaciones.areaTriangulo(base,altura);
        System.out.println("El area del tringulo con base "+base+" y altura "+altura+" es: "+area);
        
        
    }
    
    
    
    
}
