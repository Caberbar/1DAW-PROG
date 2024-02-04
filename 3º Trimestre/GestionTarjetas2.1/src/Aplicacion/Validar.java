package Aplicacion;



import static Aplicacion.TarjetaCredito.comprobarNumeroTarjeta;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase validará los datos antes de crear cualquier objeto.
 * Es una versión inicial que he creado sobre el trabajo de Tarjetas de Crédito.
 * 
 * @author Carlos Bernal Barrionuevo.
 */
public class Validar {

    /**
     * Validación de un nombre real.
     * Se encarga de validar de sí un nombre tiene los caracteres y longitud 
     * de un nombre real, en caso de no serlo devolverá false.
     * @param texto Valor escrito por teclado como nombre.
     * @return Devolverá true si es un nombre válido y false si no.
     */
    public static boolean validarNombre(String texto) {
        boolean esValido = false;
        Pattern pat = Pattern.compile("^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]*$");
        Matcher mat = pat.matcher(texto);
        if (mat.matches() && texto.length() > 14 && texto.length() < 81) {
            esValido = true;
        }
        return esValido;
    }

    /**
     * Validación de un NIE/NIF/CIF real.
     * Se encarga de validar de sí un NIE/NIF/CIF tiene los caracteres y longitud 
     * de un NIE/NIF/CIF real, aparte de validar la letra para saber si el 
     * conjunto de números coincide con un NIE/NIF/CIF real.
     * @param texto Valor escrito por teclado como NIE/NIF/CIF.
     * @return Devolverá true si es un NIE/NIF/CIF válido y si no false.
     */
    public static boolean validarNIE(String texto) {
        texto = texto.toUpperCase();
        char letra = texto.charAt(texto.length() - 1); //Guarda la letra del final            

        char caracteres[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        boolean esValido = false;
        Pattern pat = Pattern.compile("([ABCDEFGHJKLMNPQRSUVWXYZ0-9]{1})([0-9]{7})([A-Za-z]{1})");
        Matcher mat = pat.matcher(texto);

        if (mat.matches()) {
            if (Character.isDigit(texto.charAt(0))) { //NIF DNI 
                texto = texto.substring(0, texto.length() - 1); //Elimina la letra del final
                int dni = Integer.parseInt(texto);
                int resto1 = dni % 23;
                if (caracteres[resto1] == letra) {
                    esValido = true;
                }
            }

            char NIE = texto.charAt(0); //NIE
            if (NIE == 'X' || NIE == 'Y' || NIE == 'Z') {
                int dni = 0;
                texto = texto.substring(0, texto.length() - 1);
                if (NIE == 'X') {
                    texto = texto.replace("X", "0");
                    dni = Integer.parseInt(texto);
                }
                if (NIE == 'Y') {
                    texto = texto.replace("Y", "1");
                    dni = Integer.parseInt(texto);
                }
                if (NIE == 'Z') {
                    texto = texto.replace("Z", "2");
                    dni = Integer.parseInt(texto);
                }
                int resto2 = dni % 23;
                if (caracteres[resto2] == letra) {
                    esValido = true;
                }
            }
        }
        return esValido;
    }

    /**
     * Validar un PIN de 4 cifras.
     * Comprobará si un el pin introducido por parámetro tiene una longitud de 4
     * cifras y son números enteros.
     * @param texto Valor escrito por teclado como PIN.
     * @return Devolverá true si es un pin válido y false si no.
     */
    public static boolean validarPin(String texto) {
        Pattern patronPIN = Pattern.compile("([0-9]{4})");
        Matcher mat = patronPIN.matcher(texto);
        return mat.matches();
    }

    /**
     * Validar límite de una tarjeta de crédito.
     * Comprueba que al crear un objeto tarjeta no se cree con un límite inferior
     * a 500 y superior a 5000.
     * @param limit Valor escrito por teclado como límite.
     * @return Devolverá true si es un límite válido y false si no.
     */
    public static boolean validarLimite(int limit) {
        return (limit < 500 || limit > 5000);
    }

    /**
     * Validar número de tarjeta de crédito/débito.
     * Comprueba que el número escrito por teclado sea un número válido, para
     * ello primero miramos que solo ha introducido número y que tenga una 
     * longitud de 16 números, si no devolverá false y saldrá, después 
     * llamaremos a la función "comprobarNumeroTarjeta" donde se sacara el 
     * último dígito de la tarjeta y se guardará, después, con el resto de 
     * números realizaremos el algoritmo de Luhn que consiste en multiplicar por 
     * 2 los numero en las posiciones pares empezando por el final, los que 
     * están en las posiciones impares, se sumarán con los dígitos obtenidos de
     * las multiplicaciones anteriores, si el resto de dividir el total entre 10
     * es igual a cero, el número es correcto y devolverá true.
     * @param número Valor escrito por teclado como número de la tarjeta.
     * @return Devolverá true si es un número de tarjeta válido y false si no.
     */
    public static boolean validarNumero(String numero) {
        boolean esValido = false;
        Pattern pat = Pattern.compile("([0-9]{16})");
        Matcher mat = pat.matcher(numero);
        if (mat.matches()) {
            esValido = true;
        } else {
            esValido = false;
        }
        if (comprobarNumeroTarjeta(numero) == true) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }

    /**
     *
     * @param concepto
     * @param maximo Valor escrito por teclado como longitud máxima del concepto.
     * @return Devolverá true si es un pin válido y false si no.
     */
    public static boolean validarConcepto(String concepto, int maximo) {
        boolean esValido = false;
        if (concepto.length() > maximo && concepto.length() < 0) {
            esValido = true;
        }
        return esValido;
    }

    /**
     * Validación de una cantidad.
     * Comprobará si una cantidad pasada por parámetro es menor que el límite 
     * puesto como rango, en caso de serlo devolverá false.
     * @param cantidad Valor escrito por teclado como cantidad del pago.
     * @param minimo Valor escrito por teclado como cantidad mínima del pago.
     * @return Devolverá true si es una cantidad válida y false si no.
     */
    public static boolean validarCantidad(double cantidad, int minimo) {
        return cantidad >= minimo;
    }

    /**
     * Validación de una cantidad al pagar.
     * Comprobará si una cantidad pasada por parámetro es menor que 0 
     * puesto como mínimo, ay que no se pueden hacer pagos negativos ni de 0, en 
     * caso de serlo devolverá false.
     * @param cantidad Valor escrito por teclado como cantidad superior del pago.
     * @return Devolvera true si es una cantidad valida y false si no.
     */
    public static boolean validarPagar(double cantidad) {
        return (cantidad < 0);
    }

    /**
     * Validar número entre un rango.
     * Comprobará que el número escrito por teclado está entre un rango, 
     * comprobará que no sea menor que el mínimo ni mayor que el máximo, en caso
     * de serlo volverá a pedirlo, también comprobará que solo pueda meter número
     * enteros, en caso de no serlo también volverá a pedirlo.
     * @param minimo Valor escrito por teclado como tamaño mínimo de un rango de números.
     * @param maximo Valor escrito por teclado como tamaño máximo de un rango de números.
     * @return Devolverá true si es un número válido y false si no.
     */
    public static int leerIntSinNegConMax(int minimo, int maximo) {
        Scanner teclado = new Scanner(System.in);
        int valor;

        do {
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
