package ProyectoJPA;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * Esta clase crea un modelo de Movimientos.
 * Es una versi�n inicial que he creado sobre el trabajo de Tarjetas de Cr�dito 
 * en base de datos.
 * @author Carlos Bernal Barrionuevo.
 */
public class ModeloMovimientos extends AbstractTableModel {

    private ArrayList<Movimiento> listaMovimientos; //ArrayList que contendra las movimientos
    private final String[] nombresColumnas = {"Cantidad", "Concepto", "Fecha"}; //Nombres de las columnas del JTable

    /**
     * Crea una nueva instancia de la clase ModeloListaMovimientos. Inicializa la
     * lista de movimientos como una lista vacía.
     */
    public ModeloMovimientos() {
        this.listaMovimientos = new ArrayList<>();
    }

    /**
     * Crea una nueva instancia de la clase ModeloMovimientos. Inicializa la lista
     * de movimientos con la lista proporcionada.
     *
     * @param listaMovimientos la lista de movimientos
     */
    public ModeloMovimientos(ArrayList<Movimiento> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
    }

    /**
     * Añade un movimiento al modelo de lista de movimientos. 
     * Agrega un movimiento proporcionada ya creada a la lista .
     *
     * @param m el movimiento a añadir
     */
    public void añadirMovimientoModelo(Movimiento m) {
        this.listaMovimientos.add(new Movimiento(m.getCantidad(), m.getConcepto()));
        this.fireTableStructureChanged();
    }

    /**
     * Actualiza un movimiento en el modelo de movimientos. Reemplaza el movimiento
     * en la posición especificada con el movimiento proporcionado. Después de actualizar
     * el movimiento, se notifica a la tabla para que se actualice.
     *
     * @param posicion la posición del movimiento a actualizar
     * @param m el nuevo movimiento
     */
    public void actualizarTarjetaModelo(int posicion, Movimiento m) {
        this.listaMovimientos.set(posicion, m);
        this.fireTableDataChanged();
    }

    /**
     * Elimina un movimiento del modelo de movimientos. Elimina el movimiento en
     * la posición especificada de la lista de movimientos.
     *
     * @param posicion la posición del movimiento a eliminar
     * @return true si el movimiento se eliminó correctamente, false de lo contrario
     */
    public boolean eliminarTarjetaModelo(int posicion) {
        boolean eliminado = false;
        if (posicion >= 0 && posicion < listaMovimientos.size()) {
            listaMovimientos.remove(posicion);
            eliminado = true;
        }
        return eliminado;
    }

    /**
     * Obtiene un movimiento de la lista en la posición especificada.
     *
     * @param pos la posición del movimiento
     * @return el movimiento en la posición especificada
     */
    public Movimiento getMovimiento(int pos) {
        return this.listaMovimientos.get(pos);
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
        return this.listaMovimientos.size();
    }

    /**
     * Devuelve la lista de movimientos del modelo.
     *
     * @return la lista de movimientos del modelo
     */
    public ArrayList<Movimiento> getListatarjetas() {
        return this.listaMovimientos;
    }

    /**
     * Añade un conjunto de movimientos al modelo.
     *
     * @param m la lista de movimientos a añadir
     */
    public void añadirMovimientos(ArrayList<Movimiento> m) {
        for (int i = 0; i < m.size(); i++) {
            this.listaMovimientos.add(m.get(i));
        }
    }
    
    /**
     * Devuelve el número de columnas en el modelo.
     *
     * @return el número de columnas en el modelo
     */
    @Override
    public int getColumnCount() {
        return 3;
    }

    /**
     * Devuelve el valor en la celda especificada por el índice de fila y el
     * índice de columna.
     *
     * @param rowIndex el índice de fila
     * @param columnIndex el índice de columna
     * @return el valor en la celda especificada
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Movimiento m = listaMovimientos.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = m.getCantidad();
                break;
            case 1:
                value = m.getConcepto();
                break;
            case 2:
                value = m.getFecha();
                break;
        }
        return value;
    }
}
