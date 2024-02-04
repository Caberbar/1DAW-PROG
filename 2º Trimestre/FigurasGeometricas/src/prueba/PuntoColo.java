package prueba;

import figurasgeometricas.Punto;

public class PuntoColo extends Punto {

    private String color;

    public PuntoColo(double x, double y, String c) {
        super(x, y);
        this.color = c;
    }

    public PuntoColo(double v, String c) {
        this(v, v, c);
    }

    
    @Override
    public String toString() {
        return "Punto " + super.toString() + " con color " + color;
    }

}
