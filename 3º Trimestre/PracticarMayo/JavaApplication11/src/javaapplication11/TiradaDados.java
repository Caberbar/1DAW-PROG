package javaapplication11;

import java.util.Arrays;

public class TiradaDados {

    public static void main(String[] args) {

        int [] noValido1 = {1,2,3};
        int [] noValido2 = {1,3,4,5,6,6};
        int [] noValido3 = {1,2,3,4,0};
        int [] repoker = {1,1,1,1,1};
        int [] poker = {1,2,2,2,2};
        int [] full = {1,2,2,1,1};
        int [] trio = {1,2,2,2,3};
        int [] dobles = {1,2,2,4,4};
        int [] pareja = {1,2,2,3,6};
        int [] nada = {1,2,4,3,5};
        
        comprobarTirada(full);
        
    }
    
    public static int comprobarTirada(int []tirada){        
        if (!tiradaValida(tirada)) {
            return -1;
        }
        
        int [] repeticiones = new int[6];
        for (int i = 0; i < tirada.length; i++) {
            int dado = tirada[i];
            System.out.println(dado+" dado");
            repeticiones[dado -1]++;
        }
        
        for (int i = 0; i < repeticiones.length; i++) {
            System.out.println(repeticiones[i]);
        }
        
        Arrays.sort(repeticiones);
        
        //Comprobamos la tirada
        int valorTirada=0;
        if(repeticiones[5]==5){
            valorTirada=6;
        }else if(repeticiones[5]==4){
            valorTirada=5;
        }else if(repeticiones[5]==3 && repeticiones[4]==2){
            valorTirada=4;
        }else if(repeticiones[5]==3){
            valorTirada=3;
        }else if(repeticiones[5]==2 && repeticiones[4]==2){
            valorTirada=2;
        }else if(repeticiones[5]==2){
            valorTirada=1;
        }
    
        return valorTirada;
    }
    
    
    public static boolean tiradaValida(int []tirada){
        boolean esValido = true;
        
        if (tirada.length != 5) {
            esValido = false;
        }
        
        for (int i = 0;i<tirada.length && esValido; i++) {
            if (tirada[i]<1 || tirada[i]>6) {
                esValido = false;
            }
        }
        
        return esValido;
        
    }
    
}
