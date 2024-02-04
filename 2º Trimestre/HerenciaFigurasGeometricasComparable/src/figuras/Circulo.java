package figuras;


/**
 * Clase que representa un círculo en 2 dimensiones.
 * 
 * @author José L. Berenguel
 */
public class Circulo extends Figura{

    private Punto centro;
    private double radio;

    /**
     *
     */
    public Circulo(){
        this(0,0,0);
    }

    /**
     *
     * @param p
     * @param radio
     */
    public Circulo(Punto p, double radio){
        this(p.getX(), p.getY(), radio);
    }
    
    /**
     * Constructor que crea un objeto Circulo, que contiene las coordenadas del centro del círculo y el valor del radio.
     * Este constructor crea un objeto con un valor del centro en las coordenadas (x, y) recibidas por parámetro.
     * @param origen_x El valor de la coordenada x del centro del círculo.
     * @param origen_y El valor de la coordenada y del centro del círculo.
     * @param radio  El valor del radio del círculo
     * @throws IllegalArgumentException cuando el radio es negativo.
     */
    public Circulo(double origen_x, double origen_y, double radio){
        if(radio<0){
            throw new IllegalArgumentException("El radio debe ser mayor o igual que 0");
        }
        this.centro = new Punto(origen_x, origen_y);
        this.radio = radio;
    }
        
    /**
     *
     * @param c
     */
    public Circulo(Circulo c){
//        this.centro = new Punto(c.centro);
//        this.radio = c.radio;
        this(c.centro.getX(), c.centro.getY(), c.radio);
    }

    /**
     *
     * @return
     */
    public Punto getCentro() {
        return new Punto(centro);
    }

    /**
     *
     * @param centro
     */
    public void setCentro(Punto centro) {
        this.centro = new Punto(centro);
    }

    /**
     *
     * @return
     */
    public double getRadio() {
        return radio;
    }

    /**
     *
     * @param radio
     */
    public void setRadio(double radio) {
        if(radio>=0)
            this.radio = radio;
    }
    
    /**
     *
     * @return
     */
    public double getArea(){
        return Math.PI*this.radio*this.radio;
    }
    
    /**
     *
     * @return
     */
    public double getCircunferencia(){
        return 2*Math.PI*this.radio;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "[" + centro + "\t, radio=" + radio + "]";
    }
    
    /**
     *
     * @param c
     * @return
     */
    public boolean equals(Circulo c){
        return this.radio==c.radio && this.centro.equals(c.centro);
    }

    @Override
    public double area() {
        return Math.PI*this.radio*this.radio;
    }

    @Override
    public void arrancar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
