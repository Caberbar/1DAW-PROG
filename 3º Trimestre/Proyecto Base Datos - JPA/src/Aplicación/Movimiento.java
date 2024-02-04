package Aplicación;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Esta clase crea un movimiento dentro del array Movimiento. Es una versi�n
 * inicial que he creado sobre el trabajo de Tarjetas de Cr�dito en base de
 * datos.
 *
 * @author Carlos Bernal Barrionuevo.
 */
@Entity
@Table(name = "movimientos")
public class Movimiento implements Serializable {

    @Basic(optional = false) //Atributo básico(simple o primitivo)
    @Column(name = "cantidad", nullable = false) //Nombre de la columna
    private double cantidad;

    @Basic(optional = false) //Atributo básico(simple o primitivo)
    @Column(name = "fecha", nullable = false) //Nombre de la columna
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Id //Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generar automaticamente
    @Column(name = "id") //Nombre de la columna
    private int id;

    @Column(name = "concepto") //Nombre de la columna
    private String concepto; // máximo 50 caracteres

    @ManyToOne //De muchos a uno
    @JoinColumn(name = "numero_tarjeta") //Nombre de la columna y la unia a la tabla
    private TarjetaCredito tarjetaCredito;

    /**
     * Construye el objeto Movimiento. Crea una instancia de Movimiento sin
     * especificar ningún parámetro.
     */
    public Movimiento() {
    }

    /**
     * Construye el objeto Movimiento a través de los parámetros cantidad y
     * concepto. Se construirá un objeto con la cantidad y el concepto pasados
     * por parámetro y asignará la fecha del sistema al movimiento.
     *
     * @param cantidad El valor que tiene el movimiento, debe ser positivo.
     * @param concepto El concepto que lleva dicho movimiento, es una cadena de
     * máximo 50 caracteres de longitud.
     */
    public Movimiento(double cantidad, String concepto) {
        if (!Validar.validarCantidad(cantidad, 0)) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
        if (Validar.validarConcepto(concepto, 51)) {
            throw new IllegalArgumentException("Debes introducir un concepto valido (50 caracteres m�ximo):");
        }
        this.cantidad = cantidad;
        this.concepto = concepto;
        this.fecha = new Date();
    }

    /**
     * Construye un objeto Movimiento con los parámetros especificados. El
     * objeto se crea con una cantidad, un concepto y una tarjeta de crédito
     * asociada.
     *
     * @param cantidad La cantidad del movimiento.
     * @param concepto El concepto del movimiento.
     * @param tarjetaCredito La tarjeta de crédito asociada al movimiento.
     */
    public Movimiento(double cantidad, String concepto, TarjetaCredito tarjetaCredito) {
        this.cantidad = cantidad;
        this.concepto = concepto;
        this.tarjetaCredito = tarjetaCredito;
    }

    /**
     * Establece la tarjeta de crédito asociada al movimiento.
     *
     * @param tarjetaCredito La tarjeta de crédito a establecer.
     */
    public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    /**
     * Construye una copia Movimiento a través de un único parámetro. Se
     * construirá un objeto con un valor (m), copiando los parámetros de otro
     * objeto.
     *
     * @param m El valor del movimiento que se usará para crearlo.
     */
    public Movimiento(Movimiento m) {
        this(m.cantidad, m.concepto);
        this.fecha = m.fecha;
    }

    /**
     * Obtiene la fecha del movimiento.
     *
     * @return La fecha del movimiento.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del movimiento.
     *
     * @param fecha La fecha del movimiento a establecer.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la cantidad del movimiento.
     *
     * @return La cantidad del movimiento.
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del movimiento.
     *
     * @param cantidad La cantidad del movimiento a establecer.
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el concepto del movimiento.
     *
     * @return El concepto del movimiento.
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Validar concepto. Esta funci�n se encargar� de verificar que el concepto
     * sea v�lido, en caso de no serlo lanzar� una excepci�n.
     *
     * @param concepto Texto que va junto al pago, d�ndole informaci�n
     * detallada.
     */
    public void setConcepto(String concepto) {
        if (Validar.validarConcepto(concepto, 51)) {
            throw new IllegalArgumentException("Debes introducir un concepto valido (5-50 caracteres): ");
        } else {
            this.concepto = concepto;
        }
    }

    /**
     * Mostrar objeto por pantalla.
     *
     * @return Mensaje por pantalla con informaci�n detallada del movimiento.
     */
    @Override
    public String toString() {
        return "Movimiento:" + " Cantidad:" + cantidad + "$  Concepto: " + concepto + " - Fecha: " + fecha;
    }

    /**
     * Compara si dos objetos son iguales.
     *
     * @param m El valor del movimiento que se usar� para compararlo con el
     * movimiento actual.
     * @return Devolver� true si hay un movimiento igual, si no devolver� false.
     */
    public boolean equals(Movimiento m) {
        return this.cantidad == m.cantidad && this.concepto.equals(m.concepto) && this.fecha.equals(m.fecha);
    }

}
