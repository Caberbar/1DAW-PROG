package Aplicación;

import java.io.Serializable;
import java.time.*;
/**
 * Esta clase crea un movimiento dentro del array Movimiento.
 * Es una versi�n inicial que he creado sobre el trabajo de Tarjetas de Cr�dito 
 * en base de datos.
 * @author Carlos Bernal Barrionuevo.
 */
public class Movimiento implements Serializable{
    private double cantidad; //debe ser positivo
    private String concepto; //maximo 50 de caracteres
    private LocalDateTime fecha; //Introduce automaticamente la fecha del sistema

    /**
     * Construye el objeto Movimiento a trav�s de los par�metros, cantidad y concepto.
     * Se construir� un objeto con la cantidad y el concepto pasados por 
     * par�metro y asignar� la fecha del sistema al movimiento.
     * @param cantidad El valor que tiene el movimiento, debe ser positivo.
     * @param concepto El concepto que lleva dicho movimiento, es una cadena de m�ximo 50 caracteres de longitud.
     * @throws IllegalArgumentException si la cantidad no es positiva o el concepto excede los 50 caracteres.
     */
    public Movimiento(double cantidad, String concepto) {
        if(!Validar.validarCantidad(cantidad, 0)){
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
        if(Validar.validarConcepto(concepto,51)){
            throw new IllegalArgumentException("Debes introducir un concepto valido (50 caracteres m�ximo):");
        }
        this.cantidad = cantidad;
        this.concepto = concepto;
        this.fecha = LocalDateTime.now();
    }

    /**
     * Construye una copia Movimiento a trav�s de un �nico par�metro.
     * Se construir� un objeto con un valor(m), copiando los par�metros 
     * de otro objeto.
     * 
     * @param m El valor del movimiento que se usar� para crearlo.
     */
    public Movimiento(Movimiento m) {
        this(m.cantidad,m.concepto);
        this.fecha = m.fecha;
    }

    /**
     * Extrae la cantidad del objeto.
     * @return Devuelve la cantidad del movimiento pasado por par�metro.
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Devuelve  el concepto del objeto.
     * @return Devuelve el concepto del movimiento pasado por par�metro.
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Devuelve  la fecha del objeto.
     * @return Devuelve la fecha del movimiento pasado por par�metro.
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * Validar concepto.
     * Esta funci�n se encargar� de verificar que el concepto sea v�lido, en 
     * caso de no serlo lanzar� una excepci�n.
     * @param concepto Texto que va junto al pago, d�ndole informaci�n detallada.
     */
    public void setConcepto(String concepto) {
        if(Validar.validarConcepto(concepto, 51)){
            throw new IllegalArgumentException("Debes introducir un concepto valido (5-50 caracteres): ");
        }else{
            this.concepto = concepto;
        }     
    }

    /**
     * Mostrar objeto por pantalla.
     * @return Mensaje por pantalla con informaci�n detallada del movimiento.
     */
    @Override
    public String toString() {
        return "Movimiento:"+" Cantidad:"+cantidad+"$  Concepto: "+concepto+" - Fecha: "+fecha.getYear()+"-"+fecha.getMonthValue()+"-"+fecha.getDayOfMonth()+" "+ fecha.getHour()+":"+fecha.getMinute()+":"+fecha.getSecond();
    }
    
    /**
     * Compara si dos objetos son iguales.
     * @param m El valor del movimiento que se usar� para compararlo con el movimiento actual.
     * @return Devolver� true si hay un movimiento igual, si no devolver� false.
     */
    public boolean equals(Movimiento m) {
        return this.cantidad==m.cantidad && this.concepto.equals(m.concepto) && this.fecha.equals(m.fecha);
    }
    
    
}
