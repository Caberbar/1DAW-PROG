package figurasgeometricas;

//reutilizar codigo
/**
 * Esta clase representa un circulo en 2 dimensiones.
 * Es una versión inicial que hemos creado para aprender Programación Orientada a Objetos.
 * @author Carlos B.
 */

public class Circulo extends Figura{
    private Punto centro;
    private double radio;

    /**
     *
     */
    public Circulo() {
        this(0,0,0);
    }

    /**
     *
     * @param p
     * @param radio
     */
    public Circulo(Punto p, double radio) {
        //this.centro = p; NUNCA HACER ESTO, se guarda la referencia, hay que crear un nuevo objeto dentro, es decir, una copia (AGREGACIÓN, COMPOSICIÓN)
        this(p.getX(), p.getY(), radio);
        
        //lo de abajo hace lo mismo

        //this.centro = new Punto(p);
        //this.radio = radio;
    }
    
    /**
     *
     * @param c
     */
    public Circulo(Circulo c) {
        //this.centro = new Punto(c.centro);
        //this.radio = c.radio;
        this(c.centro.getX(), c.centro.getY(), c.radio);
    }
    
    
    /**
     * Contructor que crea un objeto Circulo, que contiene las coordenadas del centro del circulo y el valor del radio.
     * Este contructor crea un objeto con un valor en las coordenadas(x, y) recibidas por parametro.
     * @param origen_x El valor de la coordenada x del centro del circulo
     * @param origen_y El valor de la coordenada y del centro del circulo
     * @param radio El valor del radio del circulo
     * @throws IllegalArgumentException cuando el radio es negativo
     */
    public Circulo(double origen_x, double origen_y, double radio){
        if(!validarDato(radio)){
            throw new IllegalArgumentException("El radio no puede ser negativo");
        }
        this.centro = new Punto(origen_x,origen_y);
        this.radio = radio;
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
        if(validarDato(radio)){
            this.radio = radio;
        }
    }
    
    /**
     *
     * @return
     */
    @Override
    public double area() {
        return Math.PI*Math.pow(radio, 2); 
    }
    
    /**
     *
     * @return
     */
    public double getCircunferencia() {
        return 2*Math.PI*this.radio;
    }

    private boolean validarDato(double radio) {
       return radio >= 0;
    }
    
    /**
     *
     * @param c
     * @return
     */
    public boolean equals(Circulo c) {
        return this.radio==c.radio && this.centro.equals(c.centro);
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "[" + centro.toString() + "\t, radio =" + radio + "]";
    }   
    
}
