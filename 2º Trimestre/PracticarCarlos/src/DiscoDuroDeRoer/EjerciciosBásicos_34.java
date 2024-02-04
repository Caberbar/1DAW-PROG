package DiscoDuroDeRoer;

//Dada una frase, separarlo en palabras.

public class EjerciciosBásicos_34 {
    
    public static void main(String[] args) {

        String frase = "Hola a todos esto es una prueba";
        
        String palabras[] = frase.split(" ");
        
        for (int i = 0; i < palabras.length; i++) {
            System.out.println(palabras[i]);
        }
    }
    
}
