package cafetera;

/**
 * Esta clase representa una cafetera con su la su cantidad actual y sun
 * capacidad másima. Es una versión inicial que hemos creado para aprender
 * Programación Orientada a Objetos.
 *
 * @author Carlos B,
 * @version 1.1
 * @since 1.2
 */
public class Cafetera {

    private int capacidadMaxima;
    private int CantidadActual;

    /**
     * Contruye el objeto`punto a través de nínguna cantidad o capacidad. Se
     * construirá un objeto con una capadida maxima de 1000 y una cantidad
     * actual a 0.
     */
    public Cafetera() {
        this(1000, 0);
    }

    /**
     * Contruye el objeto`punto a través de la capacidad máxima. Inicializa la
     * cantidad actual de café a la capacidad máxima.
     *
     * @param capacidadMaxima La capacidad máxima que puede tener la cafetera.
     */
    public Cafetera(int capacidadMaxima) {
        this(capacidadMaxima, capacidadMaxima);
    }

    /**
     *
     * @param capacidadMaxima
     * @param CantidadActual
     */
    public Cafetera(int capacidadMaxima, int CantidadActual) {

        this.capacidadMaxima = capacidadMaxima;
        this.CantidadActual = CantidadActual;
        this.CantidadActual = this.ValidarCantidad();
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.capacidadMaxima = this.ValidarCantidad();
    }

    public int getCantidadActual() {
        return CantidadActual;
    }

    public void setCantidadActual(int CantidadActual) {
        this.CantidadActual = CantidadActual;
        this.CantidadActual = this.ValidarCantidad();
    }

    public void llenarCafetera() {
        this.CantidadActual = this.capacidadMaxima;
    }

    public void servirTaza(int servir) {
        int cantidadNueva;
        
        cantidadNueva = CantidadActual - servir;

        if (cantidadNueva < 0) {
            CantidadActual = 0;
        } else if (cantidadNueva > capacidadMaxima) {
            cantidadNueva = capacidadMaxima;
            CantidadActual = cantidadNueva;
        } else {
            CantidadActual = cantidadNueva;
        }
    }

    public void vaciarCafetera() {
        this.CantidadActual = 0;
    }

    public void agregarCafe(int agregar) {
        int cantidadNueva;

        cantidadNueva = CantidadActual + agregar;

        if (cantidadNueva < 0) {
            CantidadActual = 0;
        } else if (cantidadNueva > capacidadMaxima) {
            cantidadNueva = capacidadMaxima;
            CantidadActual = cantidadNueva;
        } else {
            CantidadActual = cantidadNueva;
        }
    }

    @Override
    public String toString() {
        return "Cafetera:" + " capacidad máxima:" + capacidadMaxima + ", capacidad actual:" + CantidadActual;
    }

    public int ValidarCantidad() {
        if (this.CantidadActual > this.capacidadMaxima) {
            this.CantidadActual = this.capacidadMaxima;
        }
        return this.CantidadActual;
    }

}
