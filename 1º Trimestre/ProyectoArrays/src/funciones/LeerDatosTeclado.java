package funciones;

import java.util.Scanner;

public class LeerDatosTeclado {

    
    
// validar datos que sean números double
    public static double leerDouble(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(mensaje);
        while (!teclado.hasNextDouble()) {
            System.out.println("Formato incompatible");
            teclado.nextLine();
        }
        double valor = teclado.nextDouble();
        return valor;
    }

    
    
    // validar datos que sean números double y no sean negativos con un mínimo
    public static double leerDoubleSinNeg(String mensaje, double minimo) {
        Scanner teclado = new Scanner(System.in);
        double valor;

        do {
            System.out.println(mensaje);
            while (!teclado.hasNextDouble()) {
                System.out.println("Formato incompatible");
                teclado.nextLine();
            }
            valor = teclado.nextDouble();
            if (valor <= minimo) {
                System.out.println("El valor no tiene un rango adecuado");
            }
        } while (valor <= minimo);
        return valor;
    }
    
    
    
    // validar datos que sean números double y no sean negativos con un mínimo y máximo
    public static double leerDoubleSinNegConMax(String mensaje, double minimo, double maximo) {
        Scanner teclado = new Scanner(System.in);
        double valor;

        do {
            System.out.println(mensaje);
            while (!teclado.hasNextDouble()) {
                System.out.println("Formato incompatible");
                teclado.nextLine();
            }
            valor = teclado.nextDouble();
            if (valor <= minimo || valor >= maximo) {
                System.out.println("El valor no tiene un rango adecuado");
            }
        } while (valor <= minimo || valor >= maximo);
        return valor;
    }

    
    
    // validar datos que sean números short
    public static short leerShort(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(mensaje);
        while (!teclado.hasNextShort()) {
            System.out.println("Formato incompatible");
            teclado.nextLine();
        }
        short valor = teclado.nextShort();
        return valor;
    }
    
    
    
    // validar datos que sean números short y no sean negativos con un mínimo
    public static double leerShortSinNeg(String mensaje, double minimo) {
        Scanner teclado = new Scanner(System.in);
        short valor;

        do {
            System.out.println(mensaje);
            while (!teclado.hasNextShort()) {
                System.out.println("Formato incompatible");
                teclado.nextLine();
            }
            valor = teclado.nextShort();
            if (valor <= minimo) {
                System.out.println("El valor no tiene un rango adecuado");
            }
        } while (valor <= minimo);
        return valor;
    }
    
    
    
    // validar datos que sean números double y no sean negativos con un mínimo y máximo
    public static double leerShortSinNegConMax(String mensaje, double minimo, double maximo) {
            Scanner teclado = new Scanner(System.in);
            short valor;

            do {
                System.out.println(mensaje);
                while (!teclado.hasNextShort()) {
                    System.out.println("Formato incompatible");
                    teclado.nextLine();
                }
                valor = teclado.nextShort();
                if (valor <= minimo || valor >= maximo) {
                    System.out.println("El valor no tiene un rango adecuado");
                }
            } while (valor <= minimo || valor >= maximo);
            return valor;
    }   
    
    
    
    // validar datos que sean numeros int
    public static int leerInt(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(mensaje);
        while (!teclado.hasNextInt()) {
            System.out.println("Formato incompatible");
            teclado.nextLine();
        }
        int valor = teclado.nextInt();
        return valor;
    }
    
    
    
    // validar datos que sean numeros int y no negativos
    public static int leerIntSinNeg(String mensaje, int minimo) {
            Scanner teclado = new Scanner(System.in);
            int valor;

            do {
                System.out.println(mensaje);
                while (!teclado.hasNextInt()) {
                    System.out.println("Formato incompatible");
                    teclado.nextLine();
                }
                valor = teclado.nextInt();
                if (valor <= minimo) {
                    System.out.println("El valor no tiene un rango adecuado");
                }
            } while (valor <= minimo);
            return valor;
        }
    
    
    
    // validar datos que sean números double y no sean negativos con un mínimo y máximo
    public static int leerIntSinNegConMax(String mensaje, int minimo, int maximo) {
            Scanner teclado = new Scanner(System.in);
            int valor;

            do {
                System.out.println(mensaje);
                while (!teclado.hasNextInt()) {
                    System.out.println("Formato incompatible");
                    teclado.nextLine();
                }
                valor = teclado.nextInt();
                if (valor <= minimo || valor >= maximo) {
                    System.out.println("El valor no tiene un rango adecuado");
                }
            } while (valor <= minimo || valor >= maximo);
            return valor;
    } 
    
    
}




