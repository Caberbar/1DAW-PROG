package DiscoDuroDeRoer;

// Lee un n�mero por teclado que pida el precio de un producto (puede tener decimales) y calcule el precio final con IVA. El IVA sera una constante que sera del 21%.

import java.util.Scanner;


public class EjerciciosB�sicos_9 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un n�mero: ");
        double num = teclado.nextDouble();
        double iva = num * 0.21;
        num += iva;
        System.out.println("El precio final del producto con un iva de un 21% es: "+num);
        
    }
    
}
