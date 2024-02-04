package Aplicacion;

import java.util.Comparator;

public class OrdenarMovimientosPorCantidad  implements Comparator<Movimiento>{

    @Override
    public int compare(Movimiento o1, Movimiento o2) {
        return (int)(o1.getCantidad() - o2.getCantidad());
    }
    
    
    
}
