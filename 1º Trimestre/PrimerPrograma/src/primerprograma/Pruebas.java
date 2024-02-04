package primerprograma;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author DAW-B
 */
public class Pruebas {

    public static void main(String[] args) {

        int[] prueba = {0, 1, 5, 3, 4};

        int[] prueba2 = new int[10];
        int[] copia = Arrays.copyOfRange(prueba, 0,3);
        System.arraycopy(prueba, 0, prueba2, 0, prueba.length);
        System.out.println(Arrays.toString(prueba2));
        String[] prueba3 = {"hola", "adios", "buenas"};

        Arrays.sort(prueba);
        //System.out.println(Arrays.toString(prueba));

        char myChar = '5';
        int myInt = Character.getNumericValue(myChar);
        //System.out.println(myInt);  

        int value_int = '1';
        char value_char = (char) value_int;
        //System.out.println(value_char);    

        String hola = "buenas";
        char adios = hola.charAt(0);
        //System.out.println(adios);

        char ch = 'A';
        String s = String.valueOf(ch);
        //System.out.println(s);

        int entr = 1;
        String x = String.valueOf(entr);
        //System.out.println(x);  

        String wenas = "3";
        int adeu = Integer.parseInt(wenas);
        //System.out.println(adeu);

        int matriz[][] = new int[2][];
        matriz[0] = new int[3];
        matriz[1] = new int[5];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                //System.out.print(matriz[i][j]);
            }
            //System.out.println();
        }


        int[] numeros = new int[5];
            for (int i = 0; i < numeros.length; i++) {
                numeros[i] = 5 + i + 1;
            }
            //System.out.println(numeros);
        
    

}
}
