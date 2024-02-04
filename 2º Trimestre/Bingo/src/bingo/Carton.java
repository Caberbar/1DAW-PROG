package bingo;

import java.util.Random;

public class Carton {
    private int [][] datos;

    public Carton() {
        datos = new int[3][5];
        Random numeros = new Random();
        
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[i].length; j++) {
                int num;
                boolean repetido;
                do{
                    repetido = false;
                    num = numeros.nextInt(50) +1;
                    
                    for (int k = 0; k < i && !repetido; k++) {
                        for (int l = 0; l < 5 && !repetido; l++) {
                            if(datos[k][l] == num){
                                repetido = true;
                            }
                        }
                    }
                    for (int k = 0; k < j; k++) {
                        if (datos[i][k] == num) {
                            repetido = true;
                        }
                    }
                }while (repetido);
                datos[i][j] = num;
            }
        }
    }
    
    
    public Carton(Carton carton){
        datos = new int[3][5];
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[i].length; j++) {
                datos[i][j] = carton.getValor(i, j);
            }
        }
    }
    
    public int getValor(int fila, int columna){
        if (fila < 0 || fila >= 3 || columna < 0 || columna >= 5) {
            throw new IndexOutOfBoundsException("Los valores de fila y columna no son válidos");
        }
        return datos[fila][columna];
    }
    
    public boolean marcarCasilla(int bola){
       if (bola < 1 || bola > 50) {
            throw new IllegalArgumentException("El valor de la bola no está en el intervalo [1, 50]");
        }       
        boolean marcado = false;
        for (int i = 0; i < this.datos.length; i++) {
            for (int j = 0; j < this.datos[i].length; j++) {
                if (datos[i][j] == bola) {
                    datos[i][j] = -1;
                    marcado = true;
                }
            }
        }
        return marcado;
    }
    
public boolean cantarFila() {
    boolean cantado = false;
        for (int i = 0; i < datos.length; i++) {
            boolean filaCompleta = true;
            for (int j = 0; j < datos[i].length; j++) {
                if (datos[i][j] != -1) {
                    filaCompleta = false;
                    break;
                }
            }
            if (filaCompleta) {
                cantado = true;
            }
        }
        return cantado;
    }

    public boolean cantarBingo() {
        boolean cantado = true;
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[i].length; j++) {
                if (datos[i][j] != -1) {
                    cantado = false;
                }
            }
        }
        return cantado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[i].length; j++) {
                sb.append(String.format("%2d ", datos[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    
    }
    
    
}
