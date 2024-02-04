package vergeflix;

/**
 * Esta clase encargará de modelar una interfaz llamada Valorable. 
 * Es una versión inicial que he creado sobre el trabajo de Vergeflix.
 *
 * La interfaz se implementarán en las clases, Capítulo, Temporada, Series y Película.
 * 
 * @author Carlos Bernal Barrionuevo.
 */
public interface Valorable {

    /**
     * Método calcular puntuación.
     * Se calculará un valor entre 0 y 10.
     * @return //Devolverá un número entero.
     */
    int calcularPuntuacion();
}
