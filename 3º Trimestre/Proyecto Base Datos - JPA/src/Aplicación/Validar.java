package Aplicación;

import static Aplicación.TarjetaCredito.comprobarNumeroTarjeta;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase validar� los datos antes de crear cualquier objeto. Es una versi�n
 * inicial que he creado sobre el trabajo de Tarjetas de Cr�dito.
 *
 * @author Carlos Bernal Barrionuevo.
 */
public class Validar {

    /**
     * Validaci�n de un nombre real. Se encarga de validar de s� un nombre tiene
     * los caracteres y longitud de un nombre real, en caso de no serlo
     * devolver� false.
     *
     * @param texto Valor escrito por teclado como nombre.
     * @return Devolver� true si es un nombre v�lido y false si no.
     */
    public static boolean validarNombre(String texto) {
        boolean esValido = false;
        Pattern pat = Pattern.compile("^[a-zA-Z������������\\s]*$");
        Matcher mat = pat.matcher(texto);
        if (mat.matches() && texto.length() > 14 && texto.length() < 81) {
            esValido = true;
        }
        return esValido;
    }

    /**
     * Validaci�n de un NIE/NIF/CIF real. Se encarga de validar de s� un
     * NIE/NIF/CIF tiene los caracteres y longitud de un NIE/NIF/CIF real,
     * aparte de validar la letra para saber si el conjunto de n�meros coincide
     * con un NIE/NIF/CIF real.
     *
     * @param texto Valor escrito por teclado como NIE/NIF/CIF.
     * @return Devolver� true si es un NIE/NIF/CIF v�lido y si no false.
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
     * Validar un PIN de 4 cifras. Comprobar� si un el pin introducido por
     * par�metro tiene una longitud de 4 cifras y son n�meros enteros.
     *
     * @param texto Valor escrito por teclado como PIN.
     * @return Devolver� true si es un pin v�lido y false si no.
     */
    public static boolean validarPin(String texto) {
        Pattern patronPIN = Pattern.compile("([0-9]{4})");
        Matcher mat = patronPIN.matcher(texto);
        return mat.matches();
    }

    /**
     * Validar l�mite de una tarjeta de cr�dito. Comprueba que al crear un
     * objeto tarjeta no se cree con un l�mite inferior a 500 y superior a 5000.
     *
     * @param limit Valor escrito por teclado como l�mite.
     * @return Devolver� true si es un l�mite v�lido y false si no.
     */
    public static boolean validarLimite(int limit) {
        return (limit < 500 || limit > 5000);
    }

    /**
     * Validar n�mero de tarjeta de cr�dito/d�bito. Comprueba que el n�mero
     * escrito por teclado sea un n�mero v�lido, para ello primero miramos que
     * solo ha introducido n�mero y que tenga una longitud de 16 n�meros, si no
     * devolver� false y saldr�, despu�s llamaremos a la funci�n
     * "comprobarNumeroTarjeta" donde se sacara el �ltimo d�gito de la tarjeta y
     * se guardar�, despu�s, con el resto de n�meros realizaremos el algoritmo
     * de Luhn que consiste en multiplicar por 2 los numero en las posiciones
     * pares empezando por el final, los que est�n en las posiciones impares, se
     * sumar�n con los d�gitos obtenidos de las multiplicaciones anteriores, si
     * el resto de dividir el total entre 10 es igual a cero, el n�mero es
     * correcto y devolver� true.
     *
     * @param numero Valor escrito por teclado como n�mero de la tarjeta.
     * @return Devolver� true si es un n�mero de tarjeta v�lido y false si no.
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
     * Valida si un número es válido.
     *
     * @param numero El número a validar.
     * @return true si el número es válido, false en caso contrario.
     */
    public static boolean validarCantidad(String numero) {
        boolean esValido = false;
        Pattern pat = Pattern.compile("\\d+");
        Matcher mat = pat.matcher(numero);
        if (mat.matches()) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
    }

    /**
     *
     * @param concepto
     * @param maximo Valor escrito por teclado como longitud m�xima del
     * concepto.
     * @return Devolver� true si es un pin v�lido y false si no.
     */
    public static boolean validarConcepto(String concepto, int maximo) {
        boolean esValido = false;
        if (concepto.length() > maximo && concepto.length() < 0) {
            esValido = true;
        }
        return esValido;
    }

    /**
     * Validaci�n de una cantidad. Comprobar� si una cantidad pasada por
     * par�metro es menor que el l�mite puesto como rango, en caso de serlo
     * devolver� false.
     *
     * @param cantidad Valor escrito por teclado como cantidad del pago.
     * @param minimo Valor escrito por teclado como cantidad m�nima del pago.
     * @return Devolver� true si es una cantidad v�lida y false si no.
     */
    public static boolean validarCantidad(double cantidad, int minimo) {
        return cantidad >= minimo;
    }

    /**
     * Validaci�n de una cantidad al pagar. Comprobar� si una cantidad pasada
     * por par�metro es menor que 0 puesto como m�nimo, ay que no se pueden
     * hacer pagos negativos ni de 0, en caso de serlo devolver� false.
     *
     * @param cantidad Valor escrito por teclado como cantidad superior del
     * pago.
     * @return Devolvera true si es una cantidad valida y false si no.
     */
    public static boolean validarPagar(double cantidad) {
        return (cantidad < 0);
    }

    /**
     * Validar n�mero entre un rango. Comprobar� que el n�mero escrito por
     * teclado est� entre un rango, comprobar� que no sea menor que el m�nimo ni
     * mayor que el m�ximo, en caso de serlo volver� a pedirlo, tambi�n
     * comprobar� que solo pueda meter n�mero enteros, en caso de no serlo
     * tambi�n volver� a pedirlo.
     *
     * @param minimo Valor escrito por teclado como tama�o m�nimo de un rango de
     * n�meros.
     * @param maximo Valor escrito por teclado como tama�o m�ximo de un rango de
     * n�meros.
     * @return Devolver� true si es un n�mero v�lido y false si no.
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
