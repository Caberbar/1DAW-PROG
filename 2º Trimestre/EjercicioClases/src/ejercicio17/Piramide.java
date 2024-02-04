package ejercicio17;

public class Piramide {
    private int altura;
    public static int PiramidesCreadas;
     
    public Piramide(int altura) {
        if(!validarDato(altura)){
            System.err.println("Introduzca una base permitida");
        }
        this.altura = altura;
        PiramidesCreadas ++;
    }

    public static int getPiramidesCreadas() {
        return PiramidesCreadas;
    }
    
    private boolean validarDato(int dato) {
        return dato >= 0;
    }
    
    @Override
    public String toString() {
        String Triangulo = "";
        int planta = 1;
        int longitudDeLinea = 1;
        int espacios = altura - 1;
        while (planta++ <= altura) {
        // inserta espacios
            for (int i = 1; i <= espacios; i++) {
                Triangulo += " ";
            }
            // pinta la línea
            for (int i = 1; i <= longitudDeLinea; i++) {
                Triangulo += "*";
            }
            Triangulo = Triangulo + "\n";
            espacios--;
            longitudDeLinea += 2;
        }
        return Triangulo;
    }   
}

