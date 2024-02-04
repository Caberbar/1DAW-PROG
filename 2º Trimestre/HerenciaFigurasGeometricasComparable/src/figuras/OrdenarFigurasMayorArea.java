
package figuras;

import java.util.Comparator;


public class OrdenarFigurasMayorArea implements Comparator<Figura>{

    @Override
    public int compare(Figura o1, Figura o2) {
        return (int)(o1.area() - o2.area()) * (-1);
    }
    
}
