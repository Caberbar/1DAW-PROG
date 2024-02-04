package Modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * Esta clase modela un ArrayList de canciones. Es una versión inicial que he
 * creado sobre el trabajo de Lista Musicales.
 *
 * @author Carlos Bernal Barrionuevo.
 */
public class ModeloListaCanciones extends AbstractTableModel {

    private ArrayList<Cancion> canciones; //ArrayList que contendra las canciones
    private final String[] nombresColumnas = {"Titulo", "Ruta", "Duración"}; //Nombres de las columnas del JTable

    /**
     * Crea una nueva instancia de la clase ModeloListaCanciones. Inicializa la
     * lista de canciones como una lista vacía.
     */
    public ModeloListaCanciones() {
        this.canciones = new ArrayList<>();
    }

    /**
     * Añade una canción al modelo de lista de canciones. 
     * Agrega la canción proporcionada ya creada a la lista .
     *
     * @param c la canción a añadir
     */
    public void añadirCancionModelo(Cancion c) {
        this.canciones.add(new Cancion(c.getTitulo(),c.getRuta(),c.getDuracion()));
    }

    /**
     * Actualiza una canción en el modelo de lista de canciones. Reemplaza la
     * canción en la posición especificada con la canción proporcionada. Después
     * de actualizar la canción, se notifica a la tabla para que se actualice.
     *
     * @param posicion la posición de la canción a actualizar
     * @param c la nueva canción
     */
    public void actualizarCancionModelo(int posicion, Cancion c) {
        this.canciones.set(posicion, c);
        fireTableDataChanged();
    }

    /**
     * Elimina una canción del modelo de lista de canciones. Elimina la canción
     * en la posición especificada de la lista.
     *
     * @param posicion la posición de la canción a eliminar
     */
    public void eliminarCancionModelo(int posicion) {
        this.canciones.remove(posicion);
    }

    /**
     * Obtiene una canción de la lista en la posición especificada.
     *
     * @param pos la posición de la canción
     * @return la canción en la posición especificada
     */
    public Cancion getCancion(int pos) {
        return this.canciones.get(pos);
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
        return this.canciones.size();
    }

    /**
     * Devuelve la lista de canciones del modelo.
     *
     * @return la lista de canciones del modelo
     */
    public ArrayList<Cancion> getListatarjetas() {
        return canciones;
    }

    /**
     * Añade un conjunto de canciones al modelo.
     *
     * @param c la lista de canciones a añadir
     */
    public void añadirCanciones(ArrayList<Cancion> c) {
        for (int i = 0; i < c.size(); i++) {
            this.canciones.add(c.get(i));
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
        Cancion c = canciones.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = c.getTitulo();
                break;
            case 1:
                value = c.getRuta();
                break;
            case 2:
                value = c.getDuracion();
                break;
        }
        return value;
    }
}
