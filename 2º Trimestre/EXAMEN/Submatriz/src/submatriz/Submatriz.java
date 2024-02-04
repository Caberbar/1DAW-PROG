package submatriz;

import java.util.Arrays;

public class Submatriz {

    public static void main(String[] args) {
        int[][] matriz1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        mostrarMatriz(matriz1);

        int[][] submatriz1 = submatriz(matriz1, 0, 0, 1, 1);

        System.out.println("Submatriz:");
        mostrarMatriz(submatriz1);
    }

    public static int[][] submatriz(int[][] matriz, int filaInicial, int colInicial, int filaFinal, int colFinal) {

        int filasSubmatriz = filaFinal - filaInicial + 1;
        int columnasSubmatriz = colFinal - colInicial + 1;
        
        if(matriz.length != matriz[0].length){
            throw new IllegalArgumentException("La matriz no es cuadrada");
        }
        if(filasSubmatriz<2 || columnasSubmatriz<2 || filasSubmatriz!=columnasSubmatriz){
            throw new IllegalArgumentException("Los índices de la submatriz no son correctos");
        }
        
        int[][] submatriz = new int[filasSubmatriz][columnasSubmatriz];

        for (int i = filaInicial, filaSub = 0; i <= filaFinal; i++, filaSub++) {
            for (int j = colInicial, colSub = 0; j <= colFinal; j++, colSub++) {
                submatriz[filaSub][colSub] = matriz[i][j];
            }
        }
        return submatriz;

    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }

}
