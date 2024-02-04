package ejercicio17;

public class Rectangulo {
    private int base;
    private int altura;
    public static int RectangulosCreados;

    
    public Rectangulo(int base, int altura) {
        if(!validarDato(base)){
            System.err.println("Introduzca una base permitida");
        }
        if(!validarDato(altura)){
            System.err.println("Introduzca una altura permitida");
        }
        this.base = base;
        this.altura = altura;
        RectangulosCreados ++;
    }

    public static int getRectangulosCreados() {
        return RectangulosCreados;
    }

    public static void setRectangulosCreados(int RectangulosCreados) {
        Rectangulo.RectangulosCreados = RectangulosCreados;
    }

    private boolean validarDato(int dato) {
        return dato >= 0;
    }

    @Override
    public String toString() {
        String Rectangulo = "";
        for (int i = 0; i < this.altura; i++) {
            for (int j = 0; j < this.base; j++) {
                Rectangulo = Rectangulo+"*";//println es linea nueva, cuidado
            }
            Rectangulo = Rectangulo+"\n";
        }
        return Rectangulo;
    }   
}

