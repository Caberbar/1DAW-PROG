package figurasgeometricas;

public class PuntoColor extends Punto {
    private String color;
    public PuntoColor(double x, double y, String c) {
        super(x, y);
        this.color = c;
    }

    public PuntoColor(double v, String c) {
        this(v, v, c);
    }
    
    public PuntoColor(){
        this(0,0,"Neutro");
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public String toString() {
        return "Punto "+super.toString()+" con color: "+color;
    }


}
