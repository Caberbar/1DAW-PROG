package DiscoDuroDeRoer;

// Escribe una aplicación con un String que contenga una contraseña cualquiera. Después se te pedirá que introduzcas la contraseña, con 3 
// intentos. Cuando aciertes ya no pedirá mas la contraseña y mostrara un mensaje diciendo «Enhorabuena». Piensa bien en la condición de salida 
//(3 intentos y si acierta sale, aunque le queden intentos).

import java.util.Scanner;

public class EjerciciosBásicos_16 {

    public static void main(String[] args) {
        String contra = "hola123";        
        int contador=3;
        boolean esValido = false;
        Scanner teclado = new Scanner(System.in);
        
//        for (int i = 3; i > 0 && !esValido; i--) {
//            System.out.println("Introduce la contraseña: ");
//            System.out.println("Te quedan "+i+" intento/s:");
//            String codigo = teclado.next();
//            if(codigo.equals(contra)){
//                esValido = true;
//                System.out.println("Enhorabuena, acertastes.");
//            }
//        }
        
        do{
            System.out.println("Introduce la contraseña: ");
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
