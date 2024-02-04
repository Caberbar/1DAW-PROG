package figurasgeometricas;

/**
 * Esta clase representa un punto en 2 dimensiones.
 * Es una versión inicial que hemos creado para aprender Programación Orientada a Objetos.
 * @author Carlos B
 * @version 1.1
 * @since 1.2
 * @see Circulo
 */

public class Punto {
   private double x;
   private double y;

   /**
    * Contruye el objeto`punto a través de las coordenadas x e y
    * Se construirá un objeto con un valor(x,y)
    * @param x El valor de la coordenada x y del punto
    * @param y El valor de la coordenada y y del punto
    */
   
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
   
    /**
    * Contruye el objeto`punto a través de una única coordenada.
    * Se construirá un objeto con un valor(p,p)
    * @param p El valor de la coordenada que se usara para crear el punto.
    */
   public Punto(Punto p){
       this.x = p.x;
        this.y = p.y;
   }
   
   /**
    * Contruye el objeto`punto a través de nínguna coordenada.
    * Se construirá un objeto con un valor(0,0)
    */
    public Punto() {
        this.x = 0;
        this.y = 0;
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

    boolean equals(Punto p){
       return this.x==p.x && this.y==p.y;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "X-{" + x + "} Y-{" + y + '}';
    }
    
}
