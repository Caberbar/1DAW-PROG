package DiscoDuroDeRoer;

// Recorre el String del ejercicio 22 y transforma cada car�cter a su c�digo ASCII. Muestralos en linea recta, separados por un espacio entre cada car�cter.
public class EjerciciosB�sicos_24 {

    public static void main(String[] args) {

        String frase = "La lluvia en Sevilla es una maravilla";

        int caracter = 0;
        
        for (int i = 0; i < frase.length(); i++) {
            char codigo = frase.charAt(i);
            caracter = (int) codigo;
            System.out.print(caracter+" ");
        }

    }

}
