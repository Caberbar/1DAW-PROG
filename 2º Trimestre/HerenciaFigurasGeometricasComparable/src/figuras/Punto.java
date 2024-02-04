package figuras;


/** 
 * Esta clase representa un punto en 2 dimensiones. 
 * Es una versión inicial que hemos creado para aprender Programación Orientada a Objetos.
 * @author Jose L. Berenguel
 * @version  1.1
 * @since 1.0
 * @see Circulo 
 */
public class Punto {

    private double x;
    private double y;

    
    /**
     * Construye el objeto punto a través de las coordenadas x e y. 
     * Se construirá un objeto con un valor (x,y).
     * @param x El valor de la coordenada x del punto.
     * @param y El valor de la coordenada y del punto.
     */
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Construye el objeto punto a través de una única coordenada. 
     * Se construirá un objeto con un valor (v,v).
     * @param v El valor de la coordenada que se usuará para crear el punto.
     */    
    public Punto(double v) {
        this(v, v);
    }

    /**
     * Construye por defecto para crear un punto en el origen de coordenadas. 
     * Se construirá un objeto con un valor (0,0).
     * 
     */       
    public Punto() {
        this(0, 0);
    }

    /**
     *
     * @param p
     */
    public Punto(Punto p) {
        this(p.x, p.y);
    }

    /**
     *
     * @return
     */
    public double getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    public double getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     *
     * @param p
     * @return
     */
    public boolean equals(Punto p){
        return this.x==p.x && this.y==p.y;
    }
    
}
