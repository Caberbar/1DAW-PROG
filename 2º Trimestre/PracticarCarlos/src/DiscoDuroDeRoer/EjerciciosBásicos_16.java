package DiscoDuroDeRoer;

// Escribe una aplicaci�n con un String que contenga una contrase�a cualquiera. Despu�s se te pedir� que introduzcas la contrase�a, con 3 
// intentos. Cuando aciertes ya no pedir� mas la contrase�a y mostrara un mensaje diciendo �Enhorabuena�. Piensa bien en la condici�n de salida 
//(3 intentos y si acierta sale, aunque le queden intentos).

import java.util.Scanner;

public class EjerciciosB�sicos_16 {

    public static void main(String[] args) {
        String contra = "hola123";        
        int contador=3;
        boolean esValido = false;
        Scanner teclado = new Scanner(System.in);
        
//        for (int i = 3; i > 0 && !esValido; i--) {
//            System.out.println("Introduce la contrase�a: ");
//            System.out.println("Te quedan "+i+" intento/s:");
//            String codigo = teclado.next();
//            if(codigo.equals(contra)){
//                esValido = true;
//                System.out.println("Enhorabuena, acertastes.");
//            }
//        }
        
        do{
            System.out.println("Introduce la contrase�a: ");
            System.out.println("Te quedan "+contador+" intento/s:");
            String codigo = teclado.nextLine();
            if(codigo.equals(contra)){
                esValido = true;
                System.out.println("Enhorabuena, acertastes.");
            }else{
                contador--;
            }           
        }while(!esValido&&contador!=0);
    }
    
}
