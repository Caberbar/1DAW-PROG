package vergeflix;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase validar� los datos antes de crear cualquier objeto.
 * Es una versi�n inicial que he creado sobre el trabajo de Tarjetas de Cr�dito.
 * 
 * @author Carlos Bernal Barrionuevo.
 */
public class Validar {

    /**
     * Validaci�n de un nombre real.
     * Se encarga de validar de s� un nombre tiene los caracteres y longitud 
     * de un nombre real, en caso de no serlo devolver� false.
     * @param texto Valor escrito por teclado como nombre.
     * @return Devolver� true si es un nombre v�lido y false si no.
     */
    public static boolean validarNombre(String texto) {
        boolean esValido = false;
        Pattern pat = Pattern.compile("^[a-zA-Z\\s]*$");
        Matcher mat = pat.matcher(texto);
        if (mat.matches() && texto.length() > 14 && texto.length() < 81) {
            esValido = true;
        }
        return esValido;
    }

    /**
     * Validar n�mero entre un rango.
     * Comprobar� que el n�mero escrito por teclado est� entre un rango, 
     * comprobar� que no sea menor que el m�nimo ni mayor que el m�ximo, en caso
     * de serlo volver� a pedirlo, tambi�n comprobar� que solo pueda meter n�mero
     * enteros, en caso de no serlo tambi�n volver� a pedirlo.
     * @param minimo Valor escrito por teclado como tama�o m�nimo de un rango de n�meros.
     * @param maximo Valor escrito por teclado como tama�o m�ximo de un rango de n�meros.
     * @return Devolver� true si es un n�mero v�lido y false si no.
     */
    public static int leerIntSinNegConMax(int minimo, int maximo) {
        Scanner teclado = new Scanner(System.in);
        int valor;

        do {
            while (!teclado.hasNextInt()) {
                System.out.println("Formato incompatible, puebe otra vez.");
                teclado.nextLine();
            }
            valor = teclado.nextInt();
            if (valor <= minimo || valor >= maximo) {
                System.out.println("El valor no tiene un rango adecuado, puebe otra vez.");
            }
        } while (valor <= minimo || valor >= maximo);
        return valor;
    }
    
    public static boolean comprobarNombre(String nombre, String tipo){
        boolean valido = false;
        if (nombre.isEmpty() || nombre.isBlank()) {
            System.out.println("Escribe un "+tipo+" valido.");
        }else{
            valido = true;
        }
        return valido;
        
    }
}
