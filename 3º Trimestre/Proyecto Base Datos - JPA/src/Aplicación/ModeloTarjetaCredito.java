package Aplicación;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Esta clase crea un modelo de TarjetaCredito.
 * Es una versi�n inicial que he creado sobre el trabajo de Tarjetas de Cr�dito 
 * en base de datos.
 * @author Carlos Bernal Barrionuevo.
 */
public class ModeloTarjetaCredito extends AbstractTableModel {

    private ArrayList<TarjetaCredito> listaTarjetas; //ArrayList que contendra las tarjetas
    private final String[] nombresColumnas = {"Nombre", "DNI/NIF/NIE", "PIN", "Limite", "Número tarjeta", "Fecha"}; //Nombres de las columnas del JTable

    /**
     * Crea una nueva instancia de la clase ModeloTarjetaCredito. Inicializa la
     * lista de tarjetas como una lista vacía.
     */
    public ModeloTarjetaCredito() {
        this.listaTarjetas = new ArrayList<>();
    }

    /**
     * Crea una nueva instancia de la clase ModeloTarjetaCredito. Inicializa la
     * lista de tarjetas con la lista proporcionada.
     *
     * @param listaTarjetas la lista de tarjetas de crédito
     */
    public ModeloTarjetaCredito(ArrayList<TarjetaCredito> listaTarjetas) {
        this.listaTarjetas = listaTarjetas;
    }

    /**
     * Devuelve la lista de tarjetas de crédito del modelo.
     *
     * @return la lista de tarjetas de crédito del modelo
     */
    public ArrayList<TarjetaCredito> getListaTarjetas() {
        return listaTarjetas;
    }

    /**
     * Añade una lista de tarjetas al modelo.
     * 
     * @param tarjetas lista de tarjetas a añadir
     * @return una lsta de tarjeta de credito
     */
    public ArrayList<TarjetaCredito> agregarTarjetas(List<TarjetaCredito> tarjetas) {
    for (TarjetaCredito tarjeta : tarjetas) {
        this.listaTarjetas.add(tarjeta);
    }
    this.fireTableDataChanged();
    return this.listaTarjetas;
}
    
    /**
     * Añade una tarjeta de crédito al modelo de tarjetas. Agrega la tarjeta de
     * crédito proporcionada a la lista de tarjetas y notifica a la tabla para
     * que se actualice.
     *
     * @param t la tarjeta de crédito a añadir
     */
    public void añadirTarjetaModelo(TarjetaCredito t) {
        this.listaTarjetas.add(new TarjetaCredito(t.getNombre(), t.getNif(), t.getPin(), t.getLimite(), t.getNumero()));
        this.fireTableStructureChanged();
    }

    /**
     * Actualiza una tarjeta de crédito en el modelo de tarjetas. Reemplaza la
     * tarjeta en la posición especificada con la tarjeta proporcionada. Después
     * de actualizar la tarjeta, se notifica a la tabla para que se actualice.
     *
     * @param posicion la posición de la tarjeta a actualizar
     * @param t la nueva tarjeta de crédito
     */
    public void actualizarTarjetaModelo(int posicion, TarjetaCredito t) {
        this.listaTarjetas.set(posicion, t);
        this.fireTableDataChanged();
    }

    /**
     * Elimina una tarjeta de crédito del modelo de tarjetas. Elimina la tarjeta
     * en la posición especificada de la lista de tarjetas.
     *
     * @param posicion la posición de la tarjeta a eliminar
     * @return true si la tarjeta se eliminó correctamente, false de lo
     * contrario
     */
    public boolean eliminarTarjetaModelo(int posicion) {
        boolean eliminado = false;
        if (posicion >= 0 && posicion < listaTarjetas.size()) {
            listaTarjetas.remove(posicion);
            eliminado = true;
        }
        this.fireTableDataChanged();
        return eliminado;
    }

    /**
     * Obtiene una tarjeta de crédito de la lista en la posición especificada.
     *
     * @param pos la posición de la tarjeta
     * @return la tarjeta de crédito en la posición especificada
     */
    public TarjetaCredito getTarjeta(int pos) {
        return this.listaTarjetas.get(pos);
    }

    /**
     * Devuelve el nombre de la columna en el índice especificado.
     *
     * @param index el índice de la columna
     * @return el nombre de la columna en el índice especificado
     */
    @Override
    public String getColumnName(int index) {
        return this.nombresColumnas[index];
    }

    /**
     * Devuelve el número de filas en el modelo.
     *
     * @return el número de filas en el modelo
     */
    @Override
    public int getRowCount() {
        return this.listaTarjetas.size();
    }

    /**
     * Devuelve la lista de tarjetas del modelo.
     *
     * @return la lista de tarjetas del modelo
     */
    public ArrayList<TarjetaCredito> getListatarjetas() {
        return this.listaTarjetas;
    }
    
    /**
     * Añade un conjunto de tarjetas al modelo.
     *
     * @param t la lista de tarjeats a añadir
     */
    public void añadirMovimientos(ArrayList<TarjetaCredito> t) {
        for (int i = 0; i < t.size(); i++) {
            this.listaTarjetas.add(t.get(i));
        }
    }
    
    /**
     * Devuelve el número de columnas en el modelo.
     *
     * @return el número de columnas en el modelo
     */
    public int getColumnCount() {
        return 6;
    }

    /**
     * Devuelve el valor en la celda especificada por el índice de fila y el
     * índice de columna.
     *
     * @param rowIndex el índice de fila
     * @param columnIndex el índice de columna
     * @return el valor en la celda especificada
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        TarjetaCredito t = listaTarjetas.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = t.getNombre();
                break;
            case 1:
                value = t.getNif();
                break;
            case 2:
                value = t.getPin();
                break;
            case 3:
                value = t.getLimite();
                break;
            case 4:
                value = t.getNumero();
                break;
            case 5:
                value = t.getFecha();
                //t.getMes()+" - "+t.getAnno();
                break;
        }
        return value;
    }
}
