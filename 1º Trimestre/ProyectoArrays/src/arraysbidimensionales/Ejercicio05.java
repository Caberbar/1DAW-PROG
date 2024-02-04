package arraysbidimensionales;

public class Ejercicio05 {
    public static void main(String[] args) {
        int[][] numeros = new int[6][10];
    
        int fila;
        int columna;
    
        for (int contador = 0; contador < numeros.length; contador++) {
            for (int contador2 = 0; contador2 < numeros.length; contador2++) {
                numeros[contador][contador2] = (int) (Math.random() * 11);
            }
            System.out.println("---------");
            System.out.println(contador);
            System.out.println("---------");
        }
        
    }
}


//Realiza un programa que rellene un array de 6 filas por 10 columnas con
//números enteros positivos comprendidos entre 0 y 1000 (ambos incluidos). A
//continuación, el programa deberá dar la posición tanto del máximo como del
//mínimo.