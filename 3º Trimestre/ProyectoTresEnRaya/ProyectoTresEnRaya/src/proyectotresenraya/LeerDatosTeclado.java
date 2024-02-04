package proyectotresenraya;

import java.util.Scanner;

/**
 * Clase de utilidad para leer datos desde teclado.
 *
 * @author Jose L. Berenguel
 */
public class LeerDatosTeclado {

        public static String leerString(String mensaje) {

        //Creamos el Scanner
        Scanner teclado = new Scanner(System.in);

        System.out.println(mensaje);

        return teclado.nextLine();

    }
    
    public static int leerEntero(String mensaje) {

        //Creamos el Scanner
        Scanner teclado = new Scanner(System.in);

        System.out.println(mensaje);

        //Este bucle se encarga de comprobar que se haya introducido en el teclado
        //una cadena que coincida con el tipo a leer (int) para que se pueda convertir
        //adecuadamente
        while (!teclado.hasNextInt()) {
            System.out.println("Error. No has introducido un entero: ");
            teclado.next();
        }

        //Ya podemos hacer la lectura y conversión sin que haya errores.
        int numero = teclado.nextInt();
        return numero;

    }

    public static int leerEntero(String mensaje, int minimo) {
        int numero;
        do {

            numero = leerEntero(mensaje);
        } while (numero < minimo);

        return numero;
    }

    public static int leerEntero(String mensaje, int minimo, int maximo) {
        int numero;
        do {

            numero = leerEntero(mensaje);
        } while (numero < minimo || numero > maximo);

        return numero;

    }

    public static double leerDouble(String mensaje) {

        //Creamos el Scanner
        Scanner teclado = new Scanner(System.in);

        System.out.println(mensaje);

        //Este bucle se encarga de comprobar que se haya introducido en el teclado
        //una cadena que coincida con el tipo a leer (int) para que se pueda convertir
        //adecuadamente
        while (!teclado.hasNextDouble()) {
            System.out.println("Error. No has introducido un entero: ");
            teclado.next();
        }

        //Ya podemos hacer la lectura y conversión sin que haya errores.
        double numero = teclado.nextDouble();
        return numero;

    }

    public static double leerDouble(String mensaje, double minimo) {
        double numero;
        do {

            numero = leerDouble(mensaje);
        } while (numero < minimo);

        return numero;
    }

    public static double leerDouble(String mensaje, double minimo, double maximo) {
        double numero;
        do {

            numero = leerDouble(mensaje);
        } while (numero < minimo || numero > maximo);

        return numero;

    }
}
