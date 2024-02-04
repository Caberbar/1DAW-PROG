package Aplicacion;

import java.time.*;
import java.util.Objects;
/**
 * Esta clase crea un movimiento dentro del array Movimiento.
 * Es una versión inicial que he creado sobre el trabajo de Tarjetas de Crédito.
 * @author Carlos Bernal Barrionuevo.
 */
public class Movimiento {
    private double cantidad; //debe ser positivo
    private String concepto; //maximo 50 de caracteres
    private LocalDateTime fecha; //Introduce automaticamente la fecha del sistema

    /**
     * Construye el objeto Movimiento a través de los parámetros, cantidad y concepto.
     * Se construirá un objeto con la cantidad y el concepto pasados por 
     * parámetro y asignará la fecha del sistema al movimiento.
     * @param cantidad El valor que tiene el movimiento, debe ser positivo.
     * @param concepto El concepto que lleva dicho movimiento, es una cadena de máximo 50 caracteres de longitud.
     * 
     * @throws Cantidad, En caso de no introducir una cantidad positiva se lanzara una excepcion.
     * @throws Concepto, En caso de no un concepto con una cieta longitud sin pasar de x limite se lanzara una excepcion.
     */
    public Movimiento(double cantidad, String concepto) {
        if(!Validar.validarCantidad(cantidad, 0)){  
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
        if(!Validar.validarConcepto(concepto,51)){ 
            throw new IllegalArgumentException("Debes introducir un concepto valido (50 caracteres máximo):");
        }
        this.cantidad = cantidad;
        this.concepto = concepto;
        this.fecha = LocalDateTime.now();
    }

    /**
     * Construye una copia Movimiento a través de un único parámetro.
     * Se construirá un objeto con un valor(m), copiando los parámetros 
     * de otro objeto.
     * 
     * @param m El valor del movimiento que se usará para crearlo.
     */
    public Movimiento(Movimiento m) {
        this(m.cantidad,m.concepto);
        this.fecha = m.fecha;
    }

    /**
     * Extrae la cantidad del objeto.
     * @return Devuelve la cantidad del movimiento pasado por parámetro.
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Extrae el concepto del objeto.
     * @return Devuelve el concepto del movimiento pasado por parámetro.
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Extrae la fecha del objeto.
     * @return Devuelve la fecha del movimiento pasado por parámetro.
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * Validar concepto.
     * Esta función se encargará de verificar que el concepto sea válido, en 
     * caso de no serlo lanzará una excepción.
     * @param concepto Texto que va junto al pago, dándole información detallada.
     */
    public void setConcepto(String concepto) {
        if(Validar.validarConcepto(concepto, 51)){
            this.concepto = concepto;
        }    
    }

    /**
     * Mostrar objeto por pantalla.
     * @return Mensaje por pantalla con información detallada del movimiento.
     */
    @Override
    public String toString() {
        return "Movimiento:"+" Cantidad:"+cantidad+"$  Concepto: "+concepto+" - Fecha: "+fecha.getYear()+"-"+fecha.getMonthValue()+"-"+fecha.getDayOfMonth()+" "+ fecha.getHour()+":"+fecha.getMinute()+":"+fecha.getSecond();
    }

        /**
     * Compara si dos objetos son iguales.
     * @param obj El valor del movimiento que se usará para compararlo con el movimiento actual.
     * @return Devolverá true si hay un movimiento igual, si no devolverá false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movimiento other = (Movimiento) obj;
        if (Double.doubleToLongBits(this.cantidad) != Double.doubleToLongBits(other.cantidad)) {
            return false;
        }
        if (!Objects.equals(this.concepto, other.concepto)) {
            return false;
        }
        return Objects.equals(this.fecha, other.fecha);
    }       
}
