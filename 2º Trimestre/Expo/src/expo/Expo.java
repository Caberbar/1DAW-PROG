package expo;

import java.util.Scanner;

public class Expo {
    
    public static void main(String[] args) {
        
        int opcion = 0;
        
        Zona principal = new Zona(1000);
        Zona venta = new Zona(200);
        Zona vip = new Zona(25);
        
         Scanner teclado = new Scanner(System.in);

            do {
            System.out.println("--------------------------------------------------------");
            System.out.println("ELIGE UNA OPCIÓN");
            System.out.println("1.- Entradas sin vernder");
            System.out.println("2.- Vender entradas");
            System.out.println("3.- Salir");
            
            System.out.println();
            
            opcion = LeerDatosTeclado.leerIntSinNegConMax("Introduce un numero: ",0,4);
               
            if (opcion == 1){
                System.out.println();
                System.out.println("En la zona principal quedán "+principal.getEntradasPorVender()+" Entradas");
                System.out.println("En la zona de venta quedán "+venta.getEntradasPorVender()+" Entradas");
                System.out.println("En la zona vip quedán "+vip.getEntradasPorVender()+" Entradas");
            }
            if (opcion == 2){
                System.out.println();
                System.out.println("ELIGE UNA OPCIÓN");
                System.out.println("1.- Principal");
                System.out.println("2.- Compra-Venta");
                System.out.println("3.- Vip");
                int lugar = LeerDatosTeclado.leerIntSinNegConMax("Elige una zona: ",0,4);
                System.out.println();
                int entradas = LeerDatosTeclado.leerInt("¿Cuantas quieres?: ");
                
                switch (lugar) {
                    case 1:
                        principal.vender(entradas);
                        break;
                    case 2:
                        venta.vender(entradas);
                        break;
                    case 3:
                        vip.vender(entradas);
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            }while (opcion < 3);
    }
    
}
