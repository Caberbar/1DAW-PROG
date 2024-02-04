package DiscoDuroDeRoer;

// Crea dos arrays multidimensionales de 2×3 y rellenalos como quieras (números aleatorios, por teclado o definido al crear el array).

//Haz un método que sume los arrays multidimensionales, es decir, la posición 0, 0 del array1 con la posición del array2 y así sucesivamente, 
//este metodo no debe devolver nada, haciendo que deba pasarse el array multidimensional de suma como parámetro. Muestra el contenido de cada 
//array multidimensional.

public class EjercicioMatrices_10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        //Creamos los arrays multidimensionales
        int tabla1[][]=new int [2][3];
        int tabla2[][]=new int [2][3];
        int sumamatrices[][]=new int [tabla1.length][tabla1[0].length];
 
        //Rellenamos los dos primeros arrays
        rellenarArrays(tabla1, 1, 200);
        rellenarArrays(tabla2, 1, 200);
 
        //Sumamos los arrays
        SumaMatrices(tabla1, tabla2, sumamatrices);
 
        //Mostramos los arrays
        System.out.println("Array1 ");
        imprimirTabla(tabla1);
 
        System.out.println("Array2");
        imprimirTabla(tabla2);
 
        System.out.println("La suma de matrices es ");
        imprimirTabla(sumamatrices);
    }
    public static void rellenarArrays(int tabla[][], int a, int b){
        for(int i=0;i<tabla.length;i++){
            for(int j=0;j<tabla[0].length;j++){
                tabla[i][j]=((int)Math.floor(Math.random()*(a-b)+b));
            }
        }
    }
 
    public static void imprimirTabla (int tabla[][]){
        for (int i=0;i<tabla.length;i++){
            for (int j=0;j<tabla[0].length;j++){
                System.out.print(tabla[i][j]+ " ");
            }
            System.out.println("");
        }
        System.out.println("");
 
    }
    public static int[][] SumaMatrices (int tabla1[][], int tabla2[][], int sumamatrices[][]){
 
        for (int i=0;i<sumamatrices.length;i++){
            for (int j=0;j<sumamatrices[0].length;j++){
                sumamatrices[i][j]=tabla1[i][j]+tabla2[i][j];
            }
            System.out.println("");
        }
        return sumamatrices;
    }
    
}
