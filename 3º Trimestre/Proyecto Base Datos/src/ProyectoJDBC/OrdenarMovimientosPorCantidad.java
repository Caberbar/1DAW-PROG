package ProyectoJDBC;

import java.util.Comparator;


/**
 * Esta clase implementa la interfaz Comparator y define un comparador para 
 * ordenar objetos Movimiento por su cantidad.
 * Compara dos objetos Movimiento y devuelve un valor negativo, cero o positivo 
 * dependiendo de si el primer objeto es menor, igual o mayor que el segundo 
 * objeto en términos de cantidad.
 */
public class OrdenarMovimientosPorCantidad implements Comparator<Movimiento> {

    /**
     * Compara dos objetos Movimiento por su cantidad.
     *
     * @param o1 el primer objeto Movimiento a comparar
     * @param o2 el segundo objeto Movimiento a comparar
     * @return un valor negativo si o1 es menor que o2, cero si son iguales, o
     * un valor positivo si o1 es mayor que o2 en términos de cantidad.
     */
    @Override
    public int compare(Movimiento o1, Movimiento o2) {
        return (int) (o1.getCantidad() - o2.getCantidad());
    }

}
